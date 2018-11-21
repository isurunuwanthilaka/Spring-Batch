package com.millenniumit.cdraggregation.itemprocessor;

import com.millenniumit.cdraggregation.DTO.AggSessionDataUsageIdsDTO;
import com.millenniumit.cdraggregation.entity.AggSessionDataUsageEntity;
import com.millenniumit.cdraggregation.repository.AggSessionDataUsageRepository;
import com.millenniumit.cdraggregation.repository.DataUsageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AggSessionDataUsageWriter implements ItemWriter<AggSessionDataUsageIdsDTO> {

    private static final Logger log = LoggerFactory.getLogger(AggSessionDataUsageWriter.class);

    @Autowired
    private AggSessionDataUsageRepository aggSessionDataUsageRepository;

    @Autowired
    private DataUsageRepository dataUsageRepository;

    public List<AggSessionDataUsageEntity> extractorAggSessionDataUsageEntities(List<? extends AggSessionDataUsageIdsDTO> aggSessionDataUsageIdsDTOList){
        List<AggSessionDataUsageEntity> list1 = new ArrayList<AggSessionDataUsageEntity>();

        for (AggSessionDataUsageIdsDTO aggSessionDataUsageIdsDTO:aggSessionDataUsageIdsDTOList){
            list1.add(aggSessionDataUsageIdsDTO.getAggSessionDataUsageEntity());
        }
        return list1;
    }

    public List<Long> extractorIds(List<? extends AggSessionDataUsageIdsDTO> aggSessionDataUsageIdsDTOList){
        List<Long> list2 = new ArrayList<Long>();

        for (AggSessionDataUsageIdsDTO aggSessionDataUsageIdsDTO:aggSessionDataUsageIdsDTOList){
            list2.addAll(aggSessionDataUsageIdsDTO.getIds());
        }

        return list2;
    }

    @Override
    public void write(List<? extends AggSessionDataUsageIdsDTO> aggSessionDataUsageIdsDTOList) throws Exception {
        log.debug("Writing data");

        List<AggSessionDataUsageEntity> list1 = extractorAggSessionDataUsageEntities(aggSessionDataUsageIdsDTOList);
        List<Long> list2 = extractorIds(aggSessionDataUsageIdsDTOList);

        aggSessionDataUsageRepository.saveAll(list1);
        dataUsageRepository.updateIds(list2);
    }
}