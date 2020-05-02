package com.zhihao.mapfile.service;

import com.zhihao.common.DO.MapInfoDO;
import com.zhihao.mapfile.dto.MapDetailDTO;

import java.util.List;

/**
 * @author tianyi
 * @date 2020-04-19 16:48
 */
public interface MapService {

    /**
     * 在数据库创建地图记录（完成文件业务后调用）
     * @param mapInfoDO
     * @return
     */
    public int create(MapInfoDO mapInfoDO);

    /**
     * 获取城市地图列表
     * @param cityCode 城市电话区号
     * @return
     */
    public List<MapInfoDO> listAll(String cityCode);

    /**
     * 获取用户上传的地图
     * @param userId
     * @return
     */
    public List<MapInfoDO> listMine(int userId);

    /**
     * 获取图片详情
     * @param id
     * @return
     */
    public MapDetailDTO detail(int id);
}
