package com.dqzhou.userservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Donnie
 * @Create 2020-04-07 23:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "user", keepGlobalPrefix = true)
public class User {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String phone;

    private String nickname;

    private String password;

    private String avatar;
}
