package com.team.winey.config.security;

import com.team.winey.config.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//spring security 5.7.0부터 WebSecurityConfigurerAdapter deprecated 됨
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate<String, String> redisTemplate;
    private final RedisService redisService;
    //webSecurityCustomizer를 제외한 모든 것, 시큐리티를 거친다. 보안과 연관
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authz ->
                            authz.requestMatchers(
                                             "/swagger.html"
                                            , "/swagger-ui/**"
                                            , "/v3/api-docs/**"
                                            , "/**"
                                            , "/index.html"
                                            , "/static/**"

                                            ,"/sign-api/sign-in"
                                            , "/sign-api/sign-up"
                                            , "/sign-api/exception"

                                            , "/view/**"
                                             ,"/api/**"
                                    ).permitAll()
                                    .requestMatchers(HttpMethod.GET, "/sign-api/refresh-token").permitAll()
                                    .requestMatchers("**exception**").permitAll() //exception의  용도
                                    .requestMatchers("/todo-api").hasAnyRole("USER", "ADMIN")  // roles 값을 두개값으로 따로 check in 처럼 데이터에 제한을 두어야하는지 그냥 insert해야할지 ?
                                    .anyRequest().hasRole("ADMIN")
                ) //사용 권한 체크
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //세션 사용 X
        .httpBasic(http -> http.disable()) //UI 있는 시큐리티 설정을 비활성화
                .csrf(csrf -> csrf.disable()) //CSRF 보안이 필요 X, 쿠키와 세션을 이용해서 인증을 하고 있기 때문에 발생하는 일, https://kchanguk.tistory.com/197
                .exceptionHandling(except -> {
                    except.accessDeniedHandler(new CustomAccessDeniedHandler());
                    except.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
                })
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider, redisService), UsernamePasswordAuthenticationFilter.class);//요청이 들어오기 전에만 필터를 처리한다 혹시나 요청들어오고 나서 를 원하면 .addFilterAfter()을 사용하면 된다.

        return httpSecurity.build();
    }

    //시큐리티를 거치지 않는다. 보안과 전혀 상관없는 페이지 및 리소스

}
