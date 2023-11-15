package th.ac.tu.cs.services.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import th.ac.tu.cs.services.model.User;

@Service
public class TuApiService {
    
    @Value("${tu.api.url}")
    private String tuApiUrl;

    @Value("${tu.api.token}")
    private String tuApiToken;

    private static final Logger logger = LoggerFactory.getLogger(TuApiService.class);

    private final RestTemplate restTemplate;

    public TuApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Authenticates a user against the TU API.
     *
     * @param username the username of the user to authenticate
     * @param password the password of the user to authenticate
     * @return the authenticated User object, or null if authentication fails
     * @throws HttpClientErrorException if there is a client error during authentication
     * @throws HttpServerErrorException if there is a server error during authentication
     * @throws RestClientException if there is an error while making the authentication request
     */
    public User authenticate(String username, String password) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Application-Key", tuApiToken);

            Map<String, String> body = new HashMap<>();
            body.put("UserName", username);
            body.put("PassWord", password);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body, headers);

            String apiURlAuth = UriComponentsBuilder.fromUriString(tuApiUrl)
                .path("/v1/auth/Ad/verify")
                .build()
                .toUriString();

            ResponseEntity<User> responseEntity = restTemplate.postForEntity(apiURlAuth, requestEntity, User.class);

            if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
                return responseEntity.getBody();
            } else {
                if (responseEntity.getStatusCode() == HttpStatus.FORBIDDEN) {
                    logger.error("Authentication failed due to invalid token. Please check the token and try again.");
                } else {
                    logger.error("Authentication failed. Invalid response from the external API. Status code: {}",
                            responseEntity.getStatusCode());
                }
                return null;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                logger.error("Authentication failed due to invalid token. Please check the token and try again.", e);
            } else {
                logger.error("Client error during authentication", e);
            }
            return null;
        } catch (HttpServerErrorException e) {
            logger.error("Server error during authentication. Please try again later.", e);
            return null;
        } catch (RestClientException e) {
            logger.error("Error while making the authentication request. Please check the request and try again.", e);
            return null;
        }
    }
}
