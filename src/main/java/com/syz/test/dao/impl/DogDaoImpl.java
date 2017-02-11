package com.syz.test.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.syz.test.dao.DogDao;
import com.syz.test.entity.Dog;


//@Repository(value = "DogDao")  
@Scope("prototype")
@Service("dogDao")
public class DogDaoImpl  extends BaseDaoImpl<Dog> implements DogDao{

}
