package com.dqzhou.userservice.component;

import com.dqzhou.userservice.entity.Member;
import com.dqzhou.userservice.entity.UserInfo;

public interface MemberComponent {

    void addMember(Member member);

    void checkPassword(String username, String password);

    UserInfo getMemberByUid(int uid);
}
