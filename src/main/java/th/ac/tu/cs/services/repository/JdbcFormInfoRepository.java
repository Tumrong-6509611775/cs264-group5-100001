package th.ac.tu.cs.services.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import th.ac.tu.cs.services.model.FormInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class JdbcFormInfoRepository implements FormInfoRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFormInfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(FormInfo formInfo) {
        String INSERT_STUDENTSINFO_SQL = "INSERT INTO StudentsInfo (username, studentFirstName, studentLastName, nameTitles, studentYear, studyField, mobilePhone, phone, advisor, addressNumber, moo, tumbol, amphur, province, postalcode) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(INSERT_STUDENTSINFO_SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, formInfo.getUsername());
                ps.setString(2, formInfo.getStudentFirstName());
                ps.setString(3, formInfo.getStudentLastName());
                ps.setString(4, formInfo.getNameTitles());
                ps.setString(5, formInfo.getStudentYear());
                ps.setString(6, formInfo.getStudyField());
                ps.setString(7, formInfo.getMobilePhone());
                ps.setString(8, formInfo.getPhone());
                ps.setString(9, formInfo.getAdvisor());
                ps.setString(10, formInfo.getAddressNumber());
                ps.setString(11, formInfo.getMoo());
                ps.setString(12, formInfo.getTumbol());
                ps.setString(13, formInfo.getAmphur());
                ps.setString(14, formInfo.getProvince());
                ps.setString(15, formInfo.getPostalcode());
            }
        });
    }
}
