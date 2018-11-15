package com.millenniumit.cdraggregation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "session")
@Setter
@Getter
public class SessionEntity {
    @Id
    public Long Id;

}
