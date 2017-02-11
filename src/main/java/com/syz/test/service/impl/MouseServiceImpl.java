package com.syz.test.service.impl;

import com.syz.test.dao.BaseDao;
import com.syz.test.dao.MouseDao;
import com.syz.test.entity.Mouse;
import com.syz.test.service.MouseService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/12/13.
 */
@Scope("prototype")
@Service("mouseService")
public class MouseServiceImpl extends BaseServiceImpl<Mouse> implements MouseService {
    @Resource(name = "mouseDao")
    public void setDao(BaseDao<Mouse> dao) {
        super.setDao(dao);
    }
}
