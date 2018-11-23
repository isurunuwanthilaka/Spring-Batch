package com.millenniumit.cdraggregation.repository;

import com.millenniumit.cdraggregation.entity.DataUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataUsageRepository extends JpaRepository<DataUsageEntity,Long> {

    List<DataUsageEntity> findAllByAggregatedIsFalseAndSessionId(String sessionID);

    @Modifying
    @Query("UPDATE DataUsageEntity SET aggregated = True WHERE id IN :ids")
    void updateIds(@Param("ids") List<Long> ids);

}
