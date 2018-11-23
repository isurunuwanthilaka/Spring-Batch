package com.millenniumit.cdraggregation.DTO;

import com.millenniumit.cdraggregation.entity.AggSessionDataUsageEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
public class AggSessionDataUsageIdsDTO {
    public AggSessionDataUsageEntity aggSessionDataUsageEntity;
    public List<Long> ids;
}
