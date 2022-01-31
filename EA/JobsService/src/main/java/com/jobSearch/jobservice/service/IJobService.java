package com.jobSearch.jobservice.service;

import com.jobSearch.jobservice.domain.Job;
import com.jobSearch.jobservice.dto.JobData;
import com.jobSearch.jobservice.dto.user.User;

import java.util.List;

public interface IJobService {

    public List<JobData>   getAlljob();
    public JobData getJob(Long id);
    public void addJOb(Job job);
    public void deleteJob(Long id);
    public void UpdateJob(Long id ,Job job);

    public List<User>getJobApplicants(Long jobId);
    public User getSingleJobApplicant(Long jobId,Long applicantId);

    public List<Job> search();
    public void apply(Long jobId ,Long userId);

    public User getUser(Long id);


}
