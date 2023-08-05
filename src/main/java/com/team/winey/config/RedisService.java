package com.team.winey.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String, String> redisTemplate; //주소값들어오는게 레디스콘피규레이션에서 넘어오는 값이 저장된다.

    public void setValues(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }//영구저장

    // 만료시간 설정 -> 자동 삭제
    public void setValuesWithTimeout(String key, String value, long timeout){
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MILLISECONDS);//일정시간지나면 삭제
    }

    public String getValues(String key){
        return redisTemplate.opsForValue().get(key);//들고오기
    }

    public void deleteValues(String key) {
        redisTemplate.delete(key);
    } //삭제
}
