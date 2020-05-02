package com.zhihao.account.service;

import com.zhihao.common.dto.UserInfoDTO;
import com.zhihao.common.DO.UserInfoDO;

import java.security.NoSuchAlgorithmException;

/**
 * @author tianyi
 * @date 2020-04-19 15:44
 */
public interface UserService {

    /**
     * 用户登录
     * @param loginInfo
     * @return
     */
    public UserInfoDTO login(UserInfoDO loginInfo) throws NoSuchAlgorithmException;

    /**
     * 用户注册
     * @param userInfoDO
     * @return
     */
    public int register(UserInfoDO userInfoDO) throws NoSuchAlgorithmException;

    /**
     * 修改账号信息（包括密码）
     * @param userInfoDO 传进来的密码要先完成MD5加密
     * @return
     */
    public int update(UserInfoDO userInfoDO) throws NoSuchAlgorithmException;
}
