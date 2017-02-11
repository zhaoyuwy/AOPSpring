package com.syz.test.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.syz.test.dao.BaseDao;
import com.syz.test.service.BaseService;

/**
 * 
 * BaseServiceImpl 定义Service的通用操作的实现
 * 
 * 
 * 
 * @author Monday
 * 
 */

// @Service("baseSersvice")
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

	/**
	 * 
	 * 注入BaseDao
	 * 
	 */

	private BaseDao<T> dao;

	@Resource

	public void setDao(BaseDao<T> dao) {

		this.dao = dao;

	}

	public void save(T entity) {

		dao.save(entity);

	}

	public void update(T entity) {

		dao.update(entity);

	}

	public void delete(Serializable id) {

		dao.delete(id);

	}

	public T getById(Serializable id) {

		return dao.findById(id);

	}

	public List<T> getByHQL(String hql, Object... params) {

		return dao.findByHQL(hql, params);

	}

	public List<T>  getAllList() {
		return dao.getAllList();
	}

}