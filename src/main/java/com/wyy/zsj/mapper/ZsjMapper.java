package com.wyy.zsj.mapper;

import com.wyy.zsj.entity.Zsj;

public interface ZsjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zsj record);

    int insertSelective(Zsj record);

    Zsj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zsj record);

    int updateByPrimaryKey(Zsj record);
}