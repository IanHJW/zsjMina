package com.wyy.zsj.mapper;


import com.wyy.zsj.entity.Test;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: hjw
 * Data: 2018/4/13 13:58
 * Description: Test的Dao 层
 */
@Mapper
public interface TestMapper {
    /**
     * deleteByPrimaryKey
     * @param id 根据id删除数据
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert
     * @param record 插入整条数据
     * @return
     */
    int insert(Test record);

    /**
     * insertSelective
     * @param record 插入动态数据
     * @return
     */
    int insertSelective(Test record);

    /**
     * selectByPrimaryKey
     * @param id 根据id查询数据
     * @return
     */
    Test selectByPrimaryKey(Integer id);

    /**
     * updateByPrimaryKeySelective
     * @param record 根据主键（id）动态更新
     * @return
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * updateByPrimaryKey
     * @param record 根据id 更新
     * @return
     */
    int updateByPrimaryKey(Test record);
}
