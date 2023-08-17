package com.team.winey.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class CartCharEncodingConfiguration {

    @Bean
    public CharacterEncodingFilter characterEncodingFilter(){
        return new CharacterEncodingFilter("UTF-8",true);
    }
}
