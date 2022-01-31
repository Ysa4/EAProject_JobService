package com.jobSearch.jobservice.repository;

import com.jobSearch.jobservice.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

}
