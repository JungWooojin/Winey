package com.team.winey.recommand;


import com.team.winey.recommand.model.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "사용자맞춤와인추천")
@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class RecommandController {
    private final RecommandService service;


    @PostMapping()
    public List<Long> Recommendations(@RequestBody RecommandRes res) {
        return service.selRecommand(res);
    }

    @GetMapping("/getUserInfo")
    public List<Integer> getUserInfo() {
        return service.selUserinfo();
    }
}

