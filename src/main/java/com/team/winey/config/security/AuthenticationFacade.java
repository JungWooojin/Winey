package com.team.winey.config.security;

import com.team.winey.config.security.model.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public MyUserDetails getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        return userDetails;
    }

    public Long getLoginUserPk() {
        return getLoginUser().getUserId();
    }
}
