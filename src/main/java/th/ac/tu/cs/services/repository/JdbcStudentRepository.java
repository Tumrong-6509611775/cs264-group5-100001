package th.ac.tu.cs.services.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import th.ac.tu.cs.services.model.User;

/**
 * This class implements the StudentRepository interface using JDBC to interact with the database.
 * It provides methods to save, find, and delete students from the database.
 */
@Repository
public class JdbcStudentRepository implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Saves a user to the database.
     * 
     * @param user the user to be saved
     * @return the number of rows affected by the save operation
     */
    @Override
    public int save(User user) {
        String INSERT_STUDENTS_SQL = "INSERT INTO Students (type, username, tu_status, statusid, displayname_th, displayname_en, email, department, faculty) VALUES (?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(INSERT_STUDENTS_SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getType());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getTu_status());
                ps.setString(4, user.getStatusid());
                ps.setString(5, user.getDisplayname_th());
                ps.setString(6, user.getDisplayname_en());
                ps.setString(7, user.getEmail());
                ps.setString(8, user.getDepartment());
                ps.setString(9, user.getFaculty());
            }
        });
    }
    
    /**
     * Retrieves a user from the database by their username.
     *
     * @param username the username of the user to be retrieved
     * @return the user with the specified username, or null if no such user exists
     */
    @Override
    public User findByUsername(String username) {
        try {
            String SELECT_STUDENTS_BY_USERNAME_SQL = "SELECT * FROM Students WHERE username = ?";
            return jdbcTemplate.queryForObject(SELECT_STUDENTS_BY_USERNAME_SQL, 
                BeanPropertyRowMapper.newInstance(User.class), username);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    /**
     * Deletes a student from the database by their username.
     *
     * @param username the username of the student to be deleted
     * @return the number of rows affected by the delete operation
     */
    @Override
    public int deleteByUsername(String username) {
        String DELETE_STUDENTS_BY_USERNAME_SQL = "DELETE FROM Students WHERE username = ?";
        return jdbcTemplate.update(DELETE_STUDENTS_BY_USERNAME_SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, username);
            }
        });
    }

    /**
     * Retrieves all the users from the database.
     *
     * @return a list of all the users in the database.
     */
    @Override
    public List<User> findAll() {
        String SELECT_ALL_STUDENTS_SQL = "SELECT * FROM Students";
        return jdbcTemplate.query(SELECT_ALL_STUDENTS_SQL, BeanPropertyRowMapper.newInstance(User.class));
    }

    /**
     * Retrieves a list of users whose display name in Thai contains the specified string.
     *
     * @param displayname_th the string to search for in the display name in Thai
     * @return a list of users whose display name in Thai contains the specified string
     */
    @Override
    public List<User> findByDisplayName_th(String displayname_th) {
        String SELECT_STUDENTS_BY_NAME_SQL = "SELECT * FROM Students WHERE displayname_th LIKE ?";
        return jdbcTemplate.query(
            SELECT_STUDENTS_BY_NAME_SQL, 
            new PreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1, "%" + displayname_th + "%");
                }
            }, 
            new BeanPropertyRowMapper<>(User.class)
        );
    }

    /**
     * Retrieves a list of users with email containing the specified email string.
     *
     * @param email the email string to search for
     * @return a list of users with email containing the specified email string
     */
    @Override
    public List<User> findByEmail(String email) {
        String SELECT_STUDENTS_BY_EMAIL_SQL = "SELECT * FROM Students WHERE email LIKE ?";
        return jdbcTemplate.query(
            SELECT_STUDENTS_BY_EMAIL_SQL, 
            new PreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1, "%" + email + "%");
                }
            }, 
            new BeanPropertyRowMapper<>(User.class)
        );
    }

    /**
     * Deletes all students from the database.
     *
     * @return the number of students deleted
     */
    @Override
    public int deleteAll() {
        String DELETE_ALL_STUDENTS_SQL = "DELETE FROM Students";
        return jdbcTemplate.update(DELETE_ALL_STUDENTS_SQL);
    }
    
}
