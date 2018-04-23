/**
 * Author: hjw
 * Data: 2018/4/13 13:58
 * Description: Test的service层
 */
package com.wyy.zsj.service;

import com.wyy.zsj.entity.Test;

public interface TestService {
    /**
     * insert
     * @param test 插入数据
     * @return
     */
    int insert(Test test);

    /**
     * selectByPrimaryKey
     * @param id 根据id查询信息
     * @return
     */
    Test selectByPrimaryKey(Integer id);
}
