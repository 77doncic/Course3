package Dao.impl;

import Dao.IBaseDao;
import Util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.io.Serializable;
import java.util.List;

public class BaseDao<T> implements IBaseDao<T> {
    private Class<T> clz;

    public BaseDao() {
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        clz = (Class<T>) actualTypeArguments[0];
    }

    @Override
    public void save(T s) {
        EntityManager manager = JPAUtil.getEntityManager();//获取实体管理器
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(T s) {
        EntityManager manager = JPAUtil.getEntityManager();//获取实体管理器
        manager.getTransaction().begin();
        manager.merge(s);//合并
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Serializable i) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        T s = manager.find(clz,i);//从字符串反射出对象
        manager.remove(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public T getOne(Serializable i) {
        EntityManager manager = JPAUtil.getEntityManager();
        T t = manager.find(clz, i);
        manager.close();
        return t;
    }

    @Override
    public List<T> getAll() {
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "select p from "+ clz.getName() +" as p";
        Query query = manager.createQuery(sql);
        return query.getResultList();
    }
}
