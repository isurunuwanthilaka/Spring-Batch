package com.millenniumit.cdraggregation.itemprocessor;

import com.millenniumit.cdraggregation.DTO.AggSessionDataUsageIdsDTO;
import com.millenniumit.cdraggregation.entity.AggSessionDataUsageEntity;
import com.millenniumit.cdraggregation.DTO.SessionDataUsageDTO;
import com.millenniumit.cdraggregation.entity.DataUsageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AggSessionDataUsageProcessor implements ItemProcessor<SessionDataUsageDTO,AggSessionDataUsageEntity> {

    private static final Logger log = LoggerFactory.getLogger(AggSessionDataUsageProcessor.class);

    public AggSessionDataUsageIdsDTO aggregate(SessionDataUsageDTO sessionDataUsageDTO){

        //aggregator

        AggSessionDataUsageEntity aggSessionDataUsageEntity = new AggSessionDataUsageEntity();
        AggSessionDataUsageIdsDTO aggSessionDataUsageIdsDTO = new AggSessionDataUsageIdsDTO();
        aggSessionDataUsageEntity = sessionDataUsageDTO.getAggSessionDataUsageEntity();

        List<Long> ids = new ArrayList<>();
        int tot = 0;

        for (DataUsageEntity dataUsageEntity : sessionDataUsageDTO.getDataUsageEntityList()){
            ids.add(dataUsageEntity.getId());
            tot += dataUsageEntity.getQuotaUsage();
        }

        aggSessionDataUsageEntity.setStatusId(3);
        aggSessionDataUsageEntity.setDataUsage(tot);

        aggSessionDataUsageIdsDTO.setAggSessionDataUsageEntity(aggSessionDataUsageEntity);
        aggSessionDataUsageIdsDTO.setIds(ids);

        return aggSessionDataUsageIdsDTO;
    }


    @Override
    public AggSessionDataUsageEntity process(SessionDataUsageDTO sessionDataUsageDTO) throws Exception {
        log.debug("Inside Processor : Processing for Session: " + sessionDataUsageDTO.getAggSessionDataUsageEntity().getSessionId());
        return aggregate(sessionDataUsageDTO).getAggSessionDataUsageEntity();
    }
}