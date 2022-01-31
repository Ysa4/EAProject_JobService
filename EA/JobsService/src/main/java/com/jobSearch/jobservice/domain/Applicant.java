package com.jobSearch.jobservice.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Applicant {
@Id
@GeneratedValue
private Long id;
private Long userId;
public  Applicant(){};
    public Applicant(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }
    public Applicant(Long userId) {

        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
