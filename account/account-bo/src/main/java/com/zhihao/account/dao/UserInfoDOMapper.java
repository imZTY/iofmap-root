package com.zhihao.account.dao;

import com.zhihao.common.dto.UserInfoDTO;
import com.zhihao.common.DO.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserInfoDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoDO record);

    int insertSelective(UserInfoDO record);

    /* 返回脱敏内容 */
    UserInfoDTO selectByPrimaryKey(Integer id);

    /* 返回脱敏内容 */
    UserInfoDTO checkPassword(UserInfoDO record);

    /* 检查手机号是否已存在 */
    UserInfoDTO checkExistByPhone(UserInfoDO userInfoDO);

    int updateByPrimaryKeySelective(UserInfoDO record);

    int updateByPrimaryKey(UserInfoDO record);

}