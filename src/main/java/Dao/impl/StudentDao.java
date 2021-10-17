package Dao.impl;

import Dao.IBaseDao;
import Dao.IStudentDao;
import Entity.Student;
import Util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentDao extends BaseDao<Student> implements IStudentDao {
    @Override
    public boolean Login(String name, String password) {
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "select s from Student s where s.name=:username and s.password=:password ";
        Query query = manager.createQuery(sql);
        query.setParameter("username",name);
        query.setParameter("password",password);
        List list = query.getResultList();
        manager.close();
        return list.size()>=1;

        /*if (list.size()>=1)
            return true;
        else
            return false;*/
    }
}
