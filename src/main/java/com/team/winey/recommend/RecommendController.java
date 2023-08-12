package com.team.winey.recommend;


import com.team.winey.recommend.model.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "사용자맞춤와인추천")
@Slf4j
@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendController {
    private final RecommendService service;


    @PostMapping("/wine")
    public List<Long> Recommendations(@RequestBody RecommendRes res) {
        return service.selRecommand(res);
    }

    @GetMapping("/getUserInfo")
    public List<Integer> getUserInfo() {
        return service.selUserinfo();
    }
}

