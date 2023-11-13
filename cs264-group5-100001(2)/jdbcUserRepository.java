package th.ac.tu.cs.services.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import th.ac.tu.cs.services.model.User;

@Repository
public class jdbcUserRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO form (Date, nameTitles, studentFirstName, studentLastName, studentId, studentYear," +
                "    studyField, advisor, addressNumber, moo, tumbol, amphur, Province, postalCode," +
                "    mobilePhone, phone, cause," +
                "addsubject1Code, addsubject1Name, addsubject1Section,addsubject1Date, addsubject1Credit, addsubject1Teacher,addsubject1TeacherCheck"+
                ",addsubject2Code, addsubject2Name, addsubject2Section,addsubject2Date, addsubject2Credit, addsubject2Teacher,addsubject2TeacherCheck" +
                ",addsubject3Code, addsubject3Name, addsubject3Section,addsubject3Date, addsubject3Credit, addsubject3Teacher,addsubject3TeacherCheck" +
                ",addsubject4Code, addsubject4Name, addsubject4Section,addsubject4Date, addsubject4Credit, addsubject4Teacher,addsubject4TeacherCheck," +
                "addsubject5Code, addsubject5Name, addsubject5Section,addsubject5Date, addsubject5Credit, addsubject5Teacher,addsubject5TeacherCheck," +
                "addsubject6Code, addsubject6Name, addsubject6Section,addsubject6Date, addsubject6Credit, addsubject6Teacher,addsubject6TeacherCheck," +
                "addsubject7Code, addsubject7Name, addsubject7Section,addsubject7Date, addsubject7Credit, addsubject7Teacher,addsubject7TeacherCheck," +
                "addsubject8Code, addsubject8Name, addsubject8Section,addsubject8Date, addsubject8Credit, addsubject8Teacher,addsubject8TeacherCheck," +
                "addsubject9Code, addsubject9Name, addsubject9Section,addsubject9Date, addsubject9Credit, addsubject9Teacher,addsubject9TeacherCheck," +
                "addsubject10Code, addsubject10Name, addsubject10Section,addsubject10Date, addsubject10Credit, addsubject10Teacher,addsubject10TeacherCheck," +
                "dropsubject1Code, dropsubject1Name, dropsubject1Section,dropsubject1Date, dropsubject1Credit, dropsubject1Teacher,dropsubject1TeacherCheck" +
                ",dropsubject2Code, dropsubject2Name, dropsubject2Section,dropsubject2Date, dropsubject2Credit, dropsubject2Teacher,dropsubject2TeacherCheck," +
                "dropsubject3Code, dropsubject3Name, dropsubject3Section,dropsubject3Date, dropsubject3Credit, dropsubject3Teacher,dropsubject3TeacherCheck," +
                "dropsubject4Code, dropsubject4Name, dropsubject4Section,dropsubject4Date, dropsubject4Credit, dropsubject4Teacher,dropsubject4TeacherCheck," +
                "dropsubject5Code, dropsubject5Name, dropsubject5Section,dropsubject5Date, dropsubject5Credit, dropsubject5Teacher,dropsubject5TeacherCheck," +
                "dropsubject6Code, dropsubject6Name, dropsubject6Section,dropsubject6Date, dropsubject6Credit, dropsubject6Teacher,dropsubject6TeacherCheck," +
                "dropsubject7Code, dropsubject7Name, dropsubject7Section,dropsubject7Date, dropsubject7Credit, dropsubject7Teacher,dropsubject7TeacherCheck," +
                "dropsubject8Code, dropsubject8Name, dropsubject8Section,dropsubject8Date, dropsubject8Credit, dropsubject8Teacher,dropsubject8TeacherCheck," +
                "dropsubject9Code, dropsubject9Name, dropsubject9Section,dropsubject9Date, dropsubject9Credit, dropsubject9Teacher,dropsubject9TeacherCheck," +
                "dropsubject10Code, dropsubject10Name, dropsubject10Section,dropsubject10Date, dropsubject10Credit, dropsubject10Teacher,dropsubject10TeacherCheck"
                + ")" + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", user.getDate(),user.getNameTitles(), user.getStudentFirstName(),user.getStudentLastName(), user.getStudentId(),
                user.getStudentYear(), user.getStudyField(), user.getAdvisor(),
                user.getAddressNumber(), user.getMoo(), user.getTumbol(), user.getAmphur(),
                user.getProvince(), user.getPostalCode(), user.getMobilePhone(),
                user.getPhone(), user.getCause() ,

                user.getAddsubject1Code(),
                user.getAddsubject1Name(),
                user.getAddsubject1Section(),
                user.getAddsubject1Date(),
                user.getAddsubject1Credit(),
                user.getAddsubject1Teacher(),
                user.isAddsubject1TeacherCheck(),

                user.getAddsubject2Code(),
                user.getAddsubject2Name(),
                user.getAddsubject2Section(),
                user.getAddsubject2Date(),
                user.getAddsubject2Credit(),
                user.getAddsubject2Teacher(),
                user.isAddsubject2TeacherCheck(),

                user.getAddsubject3Code(),
                user.getAddsubject3Name(),
                user.getAddsubject3Section(),
                user.getAddsubject3Date(),
                user.getAddsubject3Credit(),
                user.getAddsubject3Teacher(),
                user.isAddsubject3TeacherCheck(),

                user.getAddsubject4Code(),
                user.getAddsubject4Name(),
                user.getAddsubject4Section(),
                user.getAddsubject4Date(),
                user.getAddsubject4Credit(),
                user.getAddsubject4Teacher(),
                user.isAddsubject4TeacherCheck(),

                user.getAddsubject5Code(),
                user.getAddsubject5Name(),
                user.getAddsubject5Section(),
                user.getAddsubject5Date(),
                user.getAddsubject5Credit(),
                user.getAddsubject5Teacher(),
                user.isAddsubject5TeacherCheck(),

                user.getAddsubject6Code(),
                user.getAddsubject6Name(),
                user.getAddsubject6Section(),
                user.getAddsubject6Date(),
                user.getAddsubject6Credit(),
                user.getAddsubject6Teacher(),
                user.isAddsubject6TeacherCheck(),

                user.getAddsubject7Code(),
                user.getAddsubject7Name(),
                user.getAddsubject7Section(),
                user.getAddsubject7Date(),
                user.getAddsubject7Credit(),
                user.getAddsubject7Teacher(),
                user.isAddsubject7TeacherCheck(),

                user.getAddsubject8Code(),
                user.getAddsubject8Name(),
                user.getAddsubject8Section(),
                user.getAddsubject8Date(),
                user.getAddsubject8Credit(),
                user.getAddsubject8Teacher(),
                user.isAddsubject8TeacherCheck(),

                user.getAddsubject9Code(),
                user.getAddsubject9Name(),
                user.getAddsubject9Section(),
                user.getAddsubject9Date(),
                user.getAddsubject9Credit(),
                user.getAddsubject9Teacher(),
                user.isAddsubject9TeacherCheck(),

                user.getAddsubject10Code(),
                user.getAddsubject10Name(),
                user.getAddsubject10Section(),
                user.getAddsubject10Date(),
                user.getAddsubject10Credit(),
                user.getAddsubject10Teacher(),
                user.isAddsubject10TeacherCheck(),

                user.getDropsubject1Code(),
                user.getDropsubject1Name(),
                user.getDropsubject1Section(),
                user.getDropsubject1Date(),
                user.getDropsubject1Credit(),
                user.getDropsubject1Teacher(),
                user.isAddsubject1TeacherCheck(),

                user.getDropsubject2Code(),
                user.getDropsubject2Name(),
                user.getDropsubject2Section(),
                user.getDropsubject2Date(),
                user.getDropsubject2Credit(),
                user.getDropsubject2Teacher(),
                user.isAddsubject2TeacherCheck(),

                user.getDropsubject3Code(),
                user.getDropsubject3Name(),
                user.getDropsubject3Section(),
                user.getDropsubject3Date(),
                user.getDropsubject3Credit(),
                user.getDropsubject3Teacher(),
                user.isAddsubject3TeacherCheck(),

                user.getDropsubject4Code(),
                user.getDropsubject4Name(),
                user.getDropsubject4Section(),
                user.getDropsubject4Date(),
                user.getDropsubject4Credit(),
                user.getDropsubject4Teacher(),
                user.isAddsubject4TeacherCheck(),

                user.getDropsubject5Code(),
                user.getDropsubject5Name(),
                user.getDropsubject5Section(),
                user.getDropsubject5Date(),
                user.getDropsubject5Credit(),
                user.getDropsubject5Teacher(),
                user.isAddsubject5TeacherCheck(),

                user.getDropsubject6Code(),
                user.getDropsubject6Name(),
                user.getDropsubject6Section(),
                user.getDropsubject6Date(),
                user.getDropsubject6Credit(),
                user.getDropsubject6Teacher(),
                user.isAddsubject6TeacherCheck(),

                user.getDropsubject7Code(),
                user.getDropsubject7Name(),
                user.getDropsubject7Section(),
                user.getDropsubject7Date(),
                user.getDropsubject7Credit(),
                user.getDropsubject7Teacher(),
                user.isAddsubject7TeacherCheck(),

                user.getDropsubject8Code(),
                user.getDropsubject8Name(),
                user.getDropsubject8Section(),
                user.getDropsubject8Date(),
                user.getDropsubject8Credit(),
                user.getDropsubject8Teacher(),
                user.isAddsubject8TeacherCheck(),

                user.getDropsubject9Code(),
                user.getDropsubject9Name(),
                user.getDropsubject9Section(),
                user.getDropsubject9Date(),
                user.getDropsubject9Credit(),
                user.getDropsubject9Teacher(),
                user.isAddsubject9TeacherCheck(),

                user.getDropsubject10Code(),
                user.getDropsubject10Name(),
                user.getDropsubject10Section(),
                user.getDropsubject10Date(),
                user.getDropsubject10Credit(),
                user.getDropsubject10Teacher(),
                user.isAddsubject10TeacherCheck());
    }
}
