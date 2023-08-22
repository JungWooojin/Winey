package com.team.winey.config.security.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class MyUserDetails implements UserDetails {
    private Long userId;
    private String email;
    private String name;
    private String pw;

    @Builder.Default
    private List<String> roles = new ArrayList<>();


    //UserDetails라는 기본 스프링 메소드를 오버라이딩한다고생각
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() { return this.pw; }

    @Override
    public String getUsername() { return String.valueOf(userId); }


    //이 밑으로는 건드리기 ㄴㄴ 디테일해서 안건드리기로함
    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}
