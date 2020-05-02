package com.zhihao.common.dto;

import java.util.Date;

/**
 * @author tianyi
 * @date 2020-04-19 15:45
 */
public class UserInfoDTO {
    private Integer id;

    private String name;

    private String phone;

    private Integer roleId;

    private Float iofAge;

    private String organization;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Float getIofAge() {
        return iofAge;
    }

    public void setIofAge(Float iofAge) {
        this.iofAge = iofAge;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
