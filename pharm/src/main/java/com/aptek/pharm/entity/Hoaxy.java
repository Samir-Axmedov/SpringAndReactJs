package com.aptek.pharm.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Hoaxy {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

}
