package com.syz.test.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import com.syz.test.dao.BaseDao;
import com.syz.test.entity.Dog;
import com.syz.test.service.DogService;
@Scope("prototype")
@Service("dogService")
public class DogSercivceImpl extends BaseServiceImpl<Dog> implements DogService {

	@Resource(name = "dogDao")
	public void setDao(BaseDao<Dog> dao) {
		super.setDao(dao);
	}
}
