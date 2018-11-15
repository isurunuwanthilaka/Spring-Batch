package com.millenniumit.cdraggregation.repository;

import com.millenniumit.cdraggregation.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<SessionEntity,Long> {
    List<SessionEntity> findAllById();
}
