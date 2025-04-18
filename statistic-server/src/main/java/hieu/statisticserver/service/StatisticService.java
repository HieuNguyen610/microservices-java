package hieu.statisticserver.service;

import hieu.statisticserver.dto.StatisticDto;

import java.util.List;

public interface StatisticService {
    void add(StatisticDto statisticDto);
    List<StatisticDto> getAll();
    StatisticDto getOne(Long id);
}
