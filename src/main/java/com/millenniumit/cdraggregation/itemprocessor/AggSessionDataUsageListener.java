package com.millenniumit.cdraggregation.itemprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class AggSessionDataUsageListener extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(AggSessionDataUsageListener.class);

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Finish Job! Check the results");

        }
    }
}