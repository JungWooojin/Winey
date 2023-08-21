package com.team.winey.config.security;

import com.team.winey.config.security.model.UserEntity;
import com.team.winey.config.security.model.UserTokenEntity;
import com.team.winey.sign.model.UserUpdDto;
import com.team.winey.sign.model.UserUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsMapper {
    int save(UserEntity p);
    UserEntity getByUid(String email);
    int updSecretKey(UserUpdDto dto);
    int updUserToken(UserTokenEntity p);
    UserTokenEntity selUserToken(UserTokenEntity p);

}
