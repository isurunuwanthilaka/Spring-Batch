package com.millenniumit.cdraggregation.itemprocessor;

import com.millenniumit.cdraggregation.entity.AggSessionDataUsageEntity;
import com.millenniumit.cdraggregation.entity.DataUsageEntity;
import com.millenniumit.cdraggregation.DTO.SessionDataUsageDTO;
import com.millenniumit.cdraggregation.repository.AggSessionDataUsageRepository;
import com.millenniumit.cdraggregation.repository.DataUsageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AggSessionDataUsageReader implements ItemReader<SessionDataUsageDTO>{

    private static final Logger log = LoggerFactory.getLogger(AggSessionDataUsageReader.class);

    @Autowired
    DataUsageRepository dataUsageRepository;

    @Autowired
    AggSessionDataUsageRepository aggSessionDataUsageRepository;

    @Autowired
    SessionDataUsageDTO sessionDataUsageDTO;

    List<AggSessionDataUsageEntity> aggSessionDataUsageEntityList;
    List<DataUsageEntity> dataUsageEntityList;
    String sessionID;
    AggSessionDataUsageEntity aggSessionDataUsageEntity;


    @Override
    public SessionDataUsageDTO read() throws Exception {
        try {
            log.debug("Run the reading");
            aggSessionDataUsageEntity = aggSessionDataUsageRepository.findTopByStatusIdIs(2);
            sessionID = aggSessionDataUsageEntity.getSessionId();
            dataUsageEntityList = dataUsageRepository.findAllByAggregatedIsFalseAndSessionId(sessionID);
            sessionDataUsageDTO.setAggSessionDataUsageEntity(aggSessionDataUsageEntity);
            sessionDataUsageDTO.setDataUsageEntityList(dataUsageEntityList);

            return sessionDataUsageDTO;
        }catch (Exception e){
            return  null;
        }
    }
}