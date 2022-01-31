package com.jobSearch.jobservice;

import com.jobSearch.jobservice.domain.Job;
import com.jobSearch.jobservice.domain.JobStatus;
import com.jobSearch.jobservice.domain.JobType;
import com.jobSearch.jobservice.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Bean
    public CommandLineRunner insertData(JobRepository jobRepository) {

    return  args ->
    {
        Job  jobOne = new Job("Software Developer",
                new Date(02/19/2022),
                "Lorem ipsum dolor sit amet, nisl dolores in cum, per vitae intellegebat et, ei veniam iriure minimum sea. Cum facilisi accommodare ut, eos utinam sensibus ei. Ut vide partiendo definitiones nec, lorem voluptaria pro no. Per elit principes et, vix quod animal in.",
                100000.00,
                JobType.FULLTIME,
                JobStatus.AVAILABLE,
                1L,
                1L,
                "2 Years Experence",
                2,
                new Date()
        );
        jobRepository.save(jobOne);


    };

    }


}
