package com.dqzhou.userservice.entity;

import lombok.Builder;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-04-08 22:25
 **/
@Data
@Builder
public class UserInfo implements Serializable {

    private String username;

    private int uid;

    private String nickname;

    private String avatar;

    public UserInfo() {}

    public UserInfo(Member member) {
        this.setUid(member.getUid());
        this.setNickname(member.getNickname());
        this.setAvatar(member.getAvatar());
        this.setUsername(member.getUsername());
    }
}
