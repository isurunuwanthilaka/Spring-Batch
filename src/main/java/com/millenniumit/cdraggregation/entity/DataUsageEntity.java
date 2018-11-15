package com.millenniumit.cdraggregation.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "data_usage")
@Setter
@Getter
public class DataUsageEntity {

    @Id
    public Long id;

    @NotNull
    public int device_id;
    public String session_id;
    public String started_at;
    public String ended_at;
    public int duration;
    public int package_allocation_id;
    public int package_quota_id;
    public int quota_usage;
    @NotNull
    public String created_at;

}
