package com.syz.test.dao.impl;

import com.syz.test.dao.MouseDao;
import com.syz.test.entity.Mouse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/13.
 */
@Scope("prototype")
@Service("mouseDao")
public class MouseDaoImpl extends BaseDaoImpl<Mouse> implements MouseDao {

}
