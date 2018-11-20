package com.millenniumit.cdraggregation.repository;

import com.millenniumit.cdraggregation.entity.AggSessionDataUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AggSessionDataUsageRepository extends JpaRepository<AggSessionDataUsageEntity,Long> {

    AggSessionDataUsageEntity findTopByStatusIdIs(int statusId);
}
