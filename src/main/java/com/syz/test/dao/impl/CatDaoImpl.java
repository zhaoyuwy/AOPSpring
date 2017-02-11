package com.syz.test.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.syz.test.dao.CatDao;
import com.syz.test.entity.Cat;


//@Repository(value = "DogDao")  
@Scope("prototype")
@Service("catDao")
public class CatDaoImpl  extends BaseDaoImpl<Cat> implements CatDao{

}
