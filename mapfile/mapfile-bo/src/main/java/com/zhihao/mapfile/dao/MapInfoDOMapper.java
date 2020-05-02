package com.zhihao.mapfile.dao;

import com.zhihao.common.DO.MapInfoDO;
import com.zhihao.common.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MapInfoDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MapInfoDO record);

    int insertSelective(MapInfoDO record);

    MapInfoDO selectByPrimaryKey(Integer id);

    /* 返回脱敏内容 */
    UserInfoDTO getUserInfo(Integer id);

    List<MapInfoDO> listByCityCode(String cityCode);

    List<MapInfoDO> listByUserId(Integer createBy);

    int updateByPrimaryKeySelective(MapInfoDO record);

    int updateByPrimaryKey(MapInfoDO record);

    int getMaxId();
}