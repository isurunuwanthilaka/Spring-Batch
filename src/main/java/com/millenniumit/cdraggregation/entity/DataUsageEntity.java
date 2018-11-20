package com.millenniumit.cdraggregation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name= "data_usage")
@Setter
@Getter
public class DataUsageEntity {

    @Id
    public Long id;

    @NotNull
    public int deviceId;

    public String sessionId;

    public Timestamp startedAt;
    public Timestamp endedAt;
    public int duration;
    public int packageAllocationId;
    public int packageQuotaId;
    public int quotaUsage;
    public boolean aggregated;

    @NotNull
    public Timestamp createdAt;

}
