package com.millenniumit.cdraggregation.config;

import com.millenniumit.cdraggregation.DTO.AggSessionDataUsageIdsDTO;
import com.millenniumit.cdraggregation.DTO.SessionDataUsageDTO;
import com.millenniumit.cdraggregation.itemprocessor.AggSessionDataUsageListener;
import com.millenniumit.cdraggregation.itemprocessor.AggSessionDataUsageProcessor;
import com.millenniumit.cdraggregation.itemprocessor.AggSessionDataUsageReader;
import com.millenniumit.cdraggregation.itemprocessor.AggSessionDataUsageWriter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public AggSessionDataUsageReader aggSessionDataUsageReader;

    @Autowired
    public AggSessionDataUsageProcessor aggSessionDataUsageProcessor;

    @Autowired
    public AggSessionDataUsageWriter aggSessionDataUsageWriter;


    @Bean
    public Job job1() {
        return jobBuilderFactory.get("job1").incrementer(new RunIdIncrementer())
                .listener(new AggSessionDataUsageListener())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<SessionDataUsageDTO, AggSessionDataUsageIdsDTO>chunk(2)
                .reader(aggSessionDataUsageReader)
                .processor(aggSessionDataUsageProcessor)
                .writer(aggSessionDataUsageWriter)
                .build();
    }

    }
