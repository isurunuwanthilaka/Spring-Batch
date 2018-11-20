package com.millenniumit.cdraggregation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "agg_session_data_usage")
@Getter
@Setter
public class AggSessionDataUsageEntity {
    @Id
    public Long id;

    public String ip;
    public String sessionId;
    public int ssidId;
    public int statusId;
    public int aggMonthlyPackageAllocationDataUsageId;
    public Timestamp startedAt;
    public Timestamp endedAt;
    public int dataUsage;
    public Timestamp modifiedAt;


}
