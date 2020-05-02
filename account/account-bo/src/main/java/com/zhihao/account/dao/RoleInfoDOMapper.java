package com.zhihao.account.dao;

import com.zhihao.common.DO.RoleInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface RoleInfoDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleInfoDO record);

    int insertSelective(RoleInfoDO record);

    RoleInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleInfoDO record);

    int updateByPrimaryKey(RoleInfoDO record);
}