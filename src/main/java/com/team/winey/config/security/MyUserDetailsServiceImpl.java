package com.team.winey.config.security;

import com.team.winey.config.security.model.MyUserDetails;
import com.team.winey.config.security.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity entity = mapper.getByUid(email);
        return MyUserDetails.builder()
                .email(entity.getEmail())
                .userId(entity.getUserId())
                .pw(entity.getPw())
                .roles(Collections.singletonList(entity.getRole()))
                .build();
    }
}
