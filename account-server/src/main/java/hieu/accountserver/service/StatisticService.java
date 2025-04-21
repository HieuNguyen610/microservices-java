package hieu.accountserver.service;

import hieu.accountserver.dao.StatisticDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-server", url = "http://localhost:9082")
public interface StatisticService {

    @PostMapping("/api/statistics")
    ResponseEntity<?> create(@RequestBody StatisticDto statisticDto);
}
