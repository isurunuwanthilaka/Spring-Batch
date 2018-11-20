package com.millenniumit.cdraggregation.repository;

import com.millenniumit.cdraggregation.entity.DataUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataUsageRepository extends JpaRepository<DataUsageEntity,Long> {
    List<DataUsageEntity> findAllByAggregatedIsFalseAndSessionId(String sessionID);
}
