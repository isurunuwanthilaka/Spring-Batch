package com.millenniumit.cdraggregation.config;

import com.millenniumit.cdraggregation.dao.CustomerDao;
import com.millenniumit.cdraggregation.item.Customer;
import com.millenniumit.cdraggregation.itemprocessor.Listener;
import com.millenniumit.cdraggregation.itemprocessor.Processor;
import com.millenniumit.cdraggregation.itemprocessor.Reader;
import com.millenniumit.cdraggregation.itemprocessor.Writer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
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
    public CustomerDao customerDao;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(customerDao))
                .flow(step1()).end().build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Customer, Customer>chunk(2)
                .reader(Reader.readFromPostgres())
                .processor(new Processor()).writer(new Writer(customerDao)).build();
    }
}
