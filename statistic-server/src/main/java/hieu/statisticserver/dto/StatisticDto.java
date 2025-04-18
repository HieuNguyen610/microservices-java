package hieu.statisticserver.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class StatisticDto {
    private Long id;

    private String message;

    private Date createdDate;
}
