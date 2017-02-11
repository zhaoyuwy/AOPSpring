package com.syz.test.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.syz.test.dao.BaseDao;

/**
 * 
 * BaseDaoImpl ����DAO��ͨ�ò�����ʵ��
 * 
 * 
 * 
 * @author Monday
 * 
 */
@Scope("prototype")
@Transactional
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private static Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	private Class<T> entityClass;
//	 protected SessionFactory sessionFactory;
	 @SuppressWarnings("unchecked")
	 public BaseDaoImpl() {
	  this.entityClass = null;
	  Class c = getClass();
	  Type type = c.getGenericSuperclass();
	  if (type instanceof ParameterizedType) {
	   Type[] parameterizedType = ((ParameterizedType) type)
	     .getActualTypeArguments();
	   this.entityClass = (Class<T>) parameterizedType[0];
	   logger.info(this.toString());
	   
	  }
	 }
//	 @Autowired
//	 @Override
//	 public void setSessionFactory(SessionFactory sessionFactory) {
//	  this.sessionFactory = sessionFactory;
//	 }
////	@Autowired
//	public BaseDaoImpl() {  
//        Type genType = getClass().getGenericSuperclass();  
//        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
//        entityClass = (Class<T>) params[0];  
//    } 
	@Transactional
	public void clear() {
		getHibernateTemplate().clear();
	}
	@Transactional
	public void save(T entity) {
//		System.out.println(Thread.getAllStackTraces());
		getHibernateTemplate().saveOrUpdate(entity);		
	}
	@Transactional
	public void update(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		
	}
	@Transactional
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
//		getHibernateTemplate().delete(entityClass, id);
//		getHibernateTemplate().load(entity, id);
	}
	@Transactional
	public T findById(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}
	@Transactional
	public List<T> findByHQL(String hql, Object... params) {
		return null;
	}
	public List<T> getAllList() {
//		return  getHibernateTemplate().loadAll(entityClass);
		String hql = "from " + entityClass.getName();
		  return getSession().createQuery(hql).list();
	}


}