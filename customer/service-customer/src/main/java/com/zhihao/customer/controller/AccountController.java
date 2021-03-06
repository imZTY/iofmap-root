package com.zhihao.customer.controller;

import com.zhihao.account.service.UserService;
import com.zhihao.common.DO.UserInfoDO;
import com.zhihao.common.dto.ResultDTO;
import com.zhihao.common.dto.UserInfoDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * @author tianyi
 * @date 2020-04-19 16:22
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    /**
     * @apiDefine Account 账号
     */

    /**
     *  @apiDefine ResultDTO
     *  @apiSuccess {Integer} resultCode 响应结果
     *  @apiSuccess {String} resultMsg 结果描述
     *  @apiSuccess {Object} data 数据主体
     *  @apiSuccess {Integer} count 总数据量
     */

    /**
     * @api {post} /zhihao/account/login 账号登录
     * @apiGroup Account
     * @apiParam {String} phone 手机号【必填】
     * @apiParam {String} password 密码【必填】
     * @apiSuccessExample Success-Request:
     * {
     *     phone:18320444515
     * password:abc123
     * }
     * @apiUse ResultDTO
     * @apiSuccessExample Success-Response:
     * {
     *     "resultCode": 200,
     *     "resultMsg": "成功",
     *     "data": {
     *         "id": 1,
     *         "name": "zty",
     *         "phone": "18320444515",
     *         "roleId": null,
     *         "iofAge": 1,
     *         "organization": "广州中医药大学定向越野协会",
     *         "createTime": "2020-04-19T12:36:42.000+0000",
     *         "updateTime": "2020-04-19T12:36:42.000+0000"
     *     },
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse-有空:
     * {
     *     "resultCode": 403,
     *     "resultMsg": "登录密码不能为空",
     *     "data": null,
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse-错误:
     * {
     *     "resultCode": 444,
     *     "resultMsg": "手机号或密码错误",
     *     "data": null,
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse-异常:
     * {
     *     "resultCode": 500,
     *     "resultMsg": "密码加密时出错，请联系管理员",
     *     "data": null,
     *     "count": 0
     * }
     */
    @PostMapping("/login")
    public ResultDTO<UserInfoDTO> login(UserInfoDO userInfoDO){
        // 参数校验
        if (StringUtils.isBlank(userInfoDO.getPhone())){
            return ResultDTO.error(403, "登录手机号不能为空");
        }
        if (StringUtils.isBlank(userInfoDO.getPassword())){
            return ResultDTO.error(403, "登录密码不能为空");
        }
        // 执行业务
        try {
            UserInfoDTO rt = userService.login(userInfoDO);
            if (rt == null){
                return ResultDTO.error(444, "手机号或密码错误");
            }else {
                return ResultDTO.success(rt);
            }
        } catch (NoSuchAlgorithmException e) {
            return ResultDTO.error(500, "密码加密时出错，请联系管理员");
        }
    }

    /**
     * @api {post} /zhihao/account/register 注册账号
     * @apiGroup Account
     * @apiParam {String} name 姓名/昵称【必填】
     * @apiParam {String} phone 手机号【必填】
     * @apiParam {String} password 密码【必填】
     * @apiParam {float} iofAge 定向年龄
     * @apiParam {String} organization 所属组织/机构
     * @apiSuccessExample Success-Request:
     * {
     *     name:zty
     * phone:18320444515
     * password:abc123
     * iofAge:1.5
     * organization:广州中医药大学定向越野协会
     * }
     * @apiUse ResultDTO
     * @apiSuccessExample Success-Response:
     * {
     *     "resultCode": 200,
     *     "resultMsg": "成功",
     *     "data": 1,
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse-有空值:
     * {
     *     "resultCode": 403,
     *     "resultMsg": "登录手机号不能为空",
     *     "data": null,
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse-已存在:
     * {
     *     "resultCode": 444,
     *     "resultMsg": "注册失败，手机号已存在",
     *     "data": null,
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse-未知原因:
     * {
     *     "resultCode": 500,
     *     "resultMsg": "注册失败，未知原因",
     *     "data": null,
     *     "count": 0
     * }
     */
    @PostMapping("/register")
    public ResultDTO register(UserInfoDO userInfoDO){
        // 参数校验
        if (StringUtils.isBlank(userInfoDO.getPhone())){
            return ResultDTO.error(403, "登录手机号不能为空");
        }
        if (StringUtils.isBlank(userInfoDO.getPassword())){
            return ResultDTO.error(403, "登录密码不能为空");
        }
        // 执行业务
        try {
            int count = userService.register(userInfoDO);
            if (count == -1){
                return ResultDTO.error(444, "注册失败，手机号已存在");
            }else if (count == 0){
                return ResultDTO.error(500, "注册失败，未知原因");
            }else{
                return ResultDTO.success(count);
            }
        } catch (NoSuchAlgorithmException e) {
            return ResultDTO.error(500, "密码加密时出错，请联系管理员");
        }
    }

    /**
     * @api {post} /zhihao/account/update 修改账号信息
     * @apiGroup Account
     * @apiParam {int} id 用户id【必填】
     * @apiParam {String} name 姓名/昵称【可选】
     * @apiParam {String} phone 手机号【可选】
     * @apiParam {String} password 密码【可选】
     * @apiParam {float} iofAge 定向年龄【可选】
     * @apiParam {String} organization 所属组织/机构【可选】
     * @apiSuccessExample Success-Request:
     * {
     *     id:1
     * }
     * @apiUse ResultDTO
     * @apiSuccessExample Success-Response:
     * {
     *     "resultCode": 200,
     *     "resultMsg": "成功",
     *     "data": 1,
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse-有空:
     * {
     *     "resultCode": 403,
     *     "resultMsg": "用户id不可为空或为0",
     *      "data": null,
     *      "count": 0
     * }
     * @apiErrorExample Error-Respinse:
     * {
     *     "resultCode": 500,
     *     "resultMsg": "修改失败，密码加密时出错，请联系管理员",
     *     "data": null,
     *     "count": 0
     * }
     * @apiErrorExample Error-Respinse:
     * {
     *     "resultCode": 500,
     *     "resultMsg": "修改失败，未知原因",
     *     "data": null,
     *     "count": 0
     * }
     */
    @PostMapping("/update")
    public ResultDTO update(UserInfoDO userInfoDO){
        // 参数校验
        if (userInfoDO.getId() == null || userInfoDO.getId() == 0){
            return ResultDTO.error(403, "用户id不可为空或为0");
        }
        // 执行业务
        try {
            int count = userService.update(userInfoDO);
            if (count == 0){
                return ResultDTO.error(500, "修改失败，未知原因");
            }else{
                return ResultDTO.success(count);
            }
        } catch (NoSuchAlgorithmException e) {
            return ResultDTO.error(500, "修改失败，密码加密时出错，请联系管理员");
        }
    }
}
