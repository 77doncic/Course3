package Dao;

import Entity.Student;

public interface IStudentDao extends IBaseDao<Student>{
    public boolean Login(String name,String password);
}
