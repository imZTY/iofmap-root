package com.zhihao.mapfile.dto;

import com.zhihao.common.DO.MapInfoDO;
import com.zhihao.common.dto.UserInfoDTO;

/**
 * @author tianyi
 * @date 2020-04-19 16:53
 */
public class MapDetailDTO {

    private MapInfoDO mapInfo;

    private UserInfoDTO author;

    public MapDetailDTO(MapInfoDO mapInfoDO, UserInfoDTO userInfoDTO) {
        this.mapInfo = mapInfoDO;
        this.author = userInfoDTO;
    }

    public MapDetailDTO(){

    }

    public MapInfoDO getMapInfo() {
        return mapInfo;
    }

    public void setMapInfo(MapInfoDO mapInfo) {
        this.mapInfo = mapInfo;
    }

    public UserInfoDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserInfoDTO author) {
        this.author = author;
    }
}
