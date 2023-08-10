package com.team.winey.wine;


import com.team.winey.wine.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wine-matches")
public class WineMatchController {

    private final WineMatchService wineMatchService;

    @Autowired
    public WineMatchController(WineMatchService wineMatchService) {
        this.wineMatchService = wineMatchService;
    }

    /*@PostMapping
    public int postWine(WineInsDto dto) {
        return wineMatchService.insWine(dto);
    }*/

    @GetMapping("/list")
    public ResponseEntity<List<Match>> getWineMatches() {
        List<Match> wineMatches = wineMatchService.getWineMatches();
        return ResponseEntity.ok(wineMatches);
    }
}
