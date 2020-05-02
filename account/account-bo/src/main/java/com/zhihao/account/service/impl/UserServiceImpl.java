package com.zhihao.account.service.impl;

import com.zhihao.account.dao.UserInfoDOMapper;
import com.zhihao.common.dto.UserInfoDTO;
import com.zhihao.account.service.UserService;
import com.zhihao.common.DO.UserInfoDO;
import com.zhihao.common.util.md5.MD5;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author tianyi
 * @date 2020-04-19 15:49
 */
@Component
public class UserServiceImpl implements UserService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    /**
     * 用户登录
     *
     * @param loginInfo
     * @return
     */
    @Override
    public UserInfoDTO login(UserInfoDO loginInfo) throws NoSuchAlgorithmException {
        // 对用户输入的密码进行MD5加密
        try {
            loginInfo.setPassword(MD5.encrypt(loginInfo.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            log.error("找不到加密算法", e);
            throw e;
        }
        // 检查密码正确性
        UserInfoDTO passwordObj = userInfoDOMapper.checkPassword(loginInfo);
        if (passwordObj == null){
            log.warn("用户不存在，参数={}", loginInfo);
            return null;
        }
        return passwordObj;
    }

    /**
     * 用户注册
     *
     * @param userInfoDO
     * @return
     */
    @Override
    public int register(UserInfoDO userInfoDO) throws NoSuchAlgorithmException {
        // 检查手机号是否已存在
        UserInfoDTO userIdObj = userInfoDOMapper.checkExistByPhone(userInfoDO);
        if (userIdObj != null){
            // -1 表示手机号已存在
            return -1;
        }
        // 密码加密
        if (!StringUtils.isBlank(userInfoDO.getPassword())){
            try {
                userInfoDO.setPassword(MD5.encrypt(userInfoDO.getPassword()));
            } catch (NoSuchAlgorithmException e) {
                log.error("找不到加密算法", e);
                throw e;
            }
        }else{
            log.warn("密码为空，参数={}",userInfoDO);
            return 0;
        }
        userInfoDO.setCreateTime(new Date());
        userInfoDO.setUpdateTime(new Date());
        return userInfoDOMapper.insertSelective(userInfoDO);
    }

    /**
     * 修改账号信息（包括密码）
     *
     * @param userInfoDO
     * @return
     */
    @Override
    public int update(UserInfoDO userInfoDO) throws NoSuchAlgorithmException {
        // 如果密码非空，则加密
        if (!StringUtils.isBlank(userInfoDO.getPassword())){
            try {
                userInfoDO.setPassword(MD5.encrypt(userInfoDO.getPassword()));
            } catch (NoSuchAlgorithmException e) {
                log.error("找不到加密算法", e);
                throw e;
            }
        }
        // 其他参数处理
        userInfoDO.setUpdateTime(new Date());

        return userInfoDOMapper.updateByPrimaryKeySelective(userInfoDO);
    }
}
