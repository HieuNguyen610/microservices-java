package hieu.statisticserver.controller;

import hieu.statisticserver.dto.StatisticDto;
import hieu.statisticserver.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody StatisticDto statisticDto) {
        statisticService.add(statisticDto);
        return ResponseEntity.ok(statisticDto);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<StatisticDto> dtos = statisticService.getAll();
        return ResponseEntity.ok(dtos);
    }

}
