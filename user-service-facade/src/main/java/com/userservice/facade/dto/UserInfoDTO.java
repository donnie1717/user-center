package com.userservice.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: DonnieZhou
 * @Create 2020-04-11 21:57
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO implements Serializable {

    private String username;

    private String nickname;

    private String avatar;

    private String phone;

}
