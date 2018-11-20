package com.millenniumit.cdraggregation.itemprocessor;

import com.millenniumit.cdraggregation.entity.AggSessionDataUsageEntity;
import com.millenniumit.cdraggregation.repository.AggSessionDataUsageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AggSessionDataUsageWriter implements ItemWriter<AggSessionDataUsageEntity> {

    private static final Logger log = LoggerFactory.getLogger(AggSessionDataUsageWriter.class);


    @Autowired
    private AggSessionDataUsageRepository aggSessionDataUsageRepository;

    @Override
    public void write(List<? extends AggSessionDataUsageEntity> aggSessionDataUsageEntityList) throws Exception {
        log.debug("Writing data");
        aggSessionDataUsageRepository.saveAll(aggSessionDataUsageEntityList);
    }
}