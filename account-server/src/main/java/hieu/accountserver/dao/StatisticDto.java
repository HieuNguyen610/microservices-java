package hieu.accountserver.dao;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class StatisticDto {
    private Long id;

    private String message;

    private Date createdDate;
}
