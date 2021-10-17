import Dao.impl.StudentDao;
import Entity.Student;
import org.junit.Test;

public class StudentDaoTest {
    StudentDao sDao = new StudentDao();
    @Test
    public void TestSave(){
        Student s1 = new Student();
        s1.setId("1234");
        s1.setName("小王");
        s1.setPassword("1234567");

        sDao.save(s1);
    }

    @Test
    public void TestDelete(){
        sDao.delete("1234");
    }

    @Test
    public void TestUpdate(){
        Student s1 = new Student();
        s1.setId("20211900093");
        s1.setName("小王");
        s1.setPassword("wzycc618618");

        sDao.update(s1);
    }


}
