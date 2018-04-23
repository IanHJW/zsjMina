/**
 * Author: hjw
 * Data: 2018/4/13 14:20
 * Description: TestService的实现类
 */
package com.wyy.zsj.service.impl;

import com.wyy.zsj.entity.Test;
import com.wyy.zsj.mapper.TestMapper;
import com.wyy.zsj.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("testService")
public class TestServiceImpl implements TestService {
    private TestMapper testMapper;

    public TestServiceImpl(){

    }

    @Autowired
    public TestServiceImpl(TestMapper testMapper){
        Assert.notNull(testMapper,"testMapper不能为null");
        this.testMapper = testMapper;
    }

    @Override
    public int insert(Test test) {
        return testMapper.insert(test);
    }

    @Override
    public Test selectByPrimaryKey(Integer id) {
        return testMapper.selectByPrimaryKey(id);
    }
}
