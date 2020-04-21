package com.dqzhou.userservice.component;

import com.dqzhou.common.response.UserInfo;
import com.dqzhou.userservice.entity.Member;

public interface MemberComponent {

    void addMember(Member member);

    void checkPassword(String username, String password);

    UserInfo getMemberByUid(int uid);
}
