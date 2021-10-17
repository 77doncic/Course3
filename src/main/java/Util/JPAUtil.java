package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static EntityManagerFactory factory;
    //静态块
    static {
        factory = Persistence.createEntityManagerFactory("default");//创建实体管理工厂
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
