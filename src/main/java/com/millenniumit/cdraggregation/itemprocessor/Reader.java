package com.millenniumit.cdraggregation.itemprocessor;

import com.millenniumit.cdraggregation.entity.SessionEntity;
import com.millenniumit.cdraggregation.item.Customer;
import com.millenniumit.cdraggregation.repository.DataUsageRepository;
import com.millenniumit.cdraggregation.repository.SessionRepository;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.util.List;

public class Reader {

    @Autowired
    DataUsageRepository dataUsageRepository;

    @Autowired
    SessionRepository sessionRepository;

    public static FlatFileItemReader<Customer> reader(String path) {
        FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();

        reader.setResource(new ClassPathResource(path));
        reader.setLineMapper(new DefaultLineMapper<Customer>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "id", "firstName", "lastName" });
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {
                    {
                        setTargetType(Customer.class);
                    }
                });
            }
        });
        return reader;
    }

    public void readFromPostgres(){
        //load session and data usage details to in-memory
        return;
    }
}