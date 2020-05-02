package com.zhihao.mapfile.service.impl;

import com.zhihao.common.DO.MapInfoDO;
import com.zhihao.common.dto.UserInfoDTO;
import com.zhihao.mapfile.dao.MapInfoDOMapper;
import com.zhihao.mapfile.dto.MapDetailDTO;
import com.zhihao.mapfile.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author tianyi
 * @date 2020-04-19 16:56
 */
@Component
public class MapServiceImpl implements MapService {

    Logger log = LoggerFactory.getLogger(MapServiceImpl.class);

    @Autowired
    private MapInfoDOMapper mapInfoDOMapper;

    /**
     * 在数据库创建地图记录（完成文件业务后调用）
     *
     * @param mapInfoDO
     * @return
     */
    @Override
    public int create(MapInfoDO mapInfoDO) {
        return mapInfoDOMapper.insertSelective(mapInfoDO);
    }

    /**
     * 获取城市地图列表
     *
     * @param cityCode 城市电话区号
     * @return
     */
    @Override
    public List<MapInfoDO> listAll(String cityCode) {
        return mapInfoDOMapper.listByCityCode(cityCode);
    }

    /**
     * 获取用户上传的地图
     *
     * @param userId
     * @return
     */
    @Override
    public List<MapInfoDO> listMine(int userId) {
        return mapInfoDOMapper.listByUserId(userId);
    }

    /**
     * 获取图片详情
     *
     * @param mapId
     * @return
     */
    @Override
    public MapDetailDTO detail(int mapId) {
        MapInfoDO mapInfoDO = mapInfoDOMapper.selectByPrimaryKey(mapId);
        UserInfoDTO userInfoDTO = mapInfoDOMapper.getUserInfo(mapInfoDO.getCreateBy());
        return new MapDetailDTO(mapInfoDO, userInfoDTO);
    }
}
