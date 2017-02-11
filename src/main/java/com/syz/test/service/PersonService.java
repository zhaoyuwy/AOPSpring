package com.syz.test.service;

/**
 * Created by Administrator on 2016/12/17.
 */
public interface PersonService {
    public void save(String name);

    public void update(int name);

    public void throwException();

    public String getPersonName();

}