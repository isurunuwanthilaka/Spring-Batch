package com.millenniumit.cdraggregation.DTO;

import com.millenniumit.cdraggregation.entity.AggSessionDataUsageEntity;
import com.millenniumit.cdraggregation.entity.DataUsageEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
public class SessionDataUsageDTO {

    public AggSessionDataUsageEntity aggSessionDataUsageEntity;
    public List<DataUsageEntity> dataUsageEntityList;
}
