package hieu.statisticserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import hieu.statisticserver.dto.StatisticDto;
import hieu.statisticserver.entity.Statistic;
import hieu.statisticserver.repository.StatisticRepository;
import hieu.statisticserver.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {
    private final StatisticRepository statisticRepository;
    private final ObjectMapper objectMapper;

    private StatisticDto convertToDto(Statistic entity) {
        return objectMapper.convertValue(entity, StatisticDto.class);
    }

    private Statistic convertToEntity(StatisticDto dto) {
        return objectMapper.convertValue(dto, Statistic.class);
    }

    private List<StatisticDto> convertToDtos(List<Statistic> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void add(StatisticDto statisticDto) {
        Statistic statistic = Statistic.builder()
                .createdDate(new Date())
                .message(statisticDto.getMessage())
                .build();
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDto> getAll() {
        return convertToDtos(statisticRepository.findAll());
    }

    @Override
    public StatisticDto getOne(Long id) {
        return convertToDto(statisticRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Statistic id not found")));
    }
}
