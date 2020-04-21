package com.dqzhou.userservice.component.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dqzhou.common.response.UserInfo;
import com.dqzhou.userservice.component.MemberComponent;
import com.dqzhou.userservice.entity.Member;
import com.dqzhou.userservice.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-04-08 22:05
 **/
@Component
public class MemberComponentImpl implements MemberComponent {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void addMember(Member member) {
        memberMapper.insert(member);
    }

    @Override
    public void checkPassword(String username, String password) {

    }

    @Override
    public UserInfo getMemberByUid(int uid) {
        QueryWrapper<Member> queryWrapper = Wrappers.query();
        queryWrapper.eq("uid", uid);
        Member member = memberMapper.selectOne(queryWrapper);
        UserInfo userInfo = UserInfo.builder()
                .uid(member.getUid())
                .avatar(member.getAvatar())
                .nickname(member.getNickname())
                .username(member.getUsername()).build();
        return userInfo;
    }
}
