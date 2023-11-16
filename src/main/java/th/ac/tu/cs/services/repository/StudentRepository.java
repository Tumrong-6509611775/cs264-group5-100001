package th.ac.tu.cs.services.repository;

import java.util.List;

import th.ac.tu.cs.services.model.User;

/**
 * This interface represents a repository for managing student data.
 */
public interface StudentRepository {
    int save(User user);

    User findByUsername(String username);

    int deleteByUsername(String username);

    List<User> findAll();

    List<User> findByDisplayName_th(String displayname_th);

    List<User> findByEmail(String email);

    int deleteAll();
}
