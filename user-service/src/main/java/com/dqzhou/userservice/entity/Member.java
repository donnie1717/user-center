package com.dqzhou.userservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-04-07 23:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("tbl_member")
public class Member {

    @TableId(value = "id")
    private int id;

    private String username;

    private int uid;

    private String nickname;

    private String password;

    private String salt;

    private String avatar;
}
