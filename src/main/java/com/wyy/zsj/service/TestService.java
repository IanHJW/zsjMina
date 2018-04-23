/**
 * @author: hjw
 * Data: 2018/4/13 13:58
 * Description: Test的service层
 */
package com.wyy.zsj.service;

import com.wyy.zsj.entity.Test;

public interface TestService {
    /**
     * insert
     * @param test 插入数据
     * @return test
     */
    int insert(Test test);

    /**
     * selectByPrimaryKey
     * @param id integer
     * @return 一条数据
     */
    Test selectByPrimaryKey(Integer id);
}
