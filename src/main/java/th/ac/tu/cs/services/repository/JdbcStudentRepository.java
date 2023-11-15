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

@Repository
public class JdbcStudentRepository implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    @Override
    public List<User> findAll() {
        String SELECT_ALL_STUDENTS_SQL = "SELECT * FROM Students";
        return jdbcTemplate.query(SELECT_ALL_STUDENTS_SQL, BeanPropertyRowMapper.newInstance(User.class));
    }

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

    @Override
    public int deleteAll() {
        String DELETE_ALL_STUDENTS_SQL = "DELETE FROM Students";
        return jdbcTemplate.update(DELETE_ALL_STUDENTS_SQL);
    }
    
}
