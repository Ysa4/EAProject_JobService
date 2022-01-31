package com.jobSearch.jobservice.controller;

import com.jobSearch.jobservice.domain.Job;
import com.jobSearch.jobservice.dto.JobData;
import com.jobSearch.jobservice.dto.user.User;
import com.jobSearch.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("/jobs")
    public List<JobData>  getAllJobs()
    {
        return  service.getAlljob();
    }

    @GetMapping("/jobs/{id}")
    public JobData getJob(@PathVariable Long id)
    {
        return service.getJob(id);
    }

    @PostMapping("/jobs")
    public void addNewJob(@RequestBody Job job)
    {
        service.addJOb(job);
    }

    @DeleteMapping("jobs/{id}")
    public void deleteJob(@PathVariable Long id)
    {
        service.deleteJob(id);
    }

    @PutMapping("/jobs/{id}")
    public void updateJob(@PathVariable Long id ,@RequestBody  Job job)
    {
        service.UpdateJob(id,job);
    }

    @GetMapping("/jobs/search")
    public List<Job> searchJobs()
    {
        return  service.search();
    }


    @PostMapping("/jobs/{jId}/apply/{uId}")
    public void applyJob(@PathVariable Long jId ,@PathVariable Long uId)
    {
       service.apply(jId,uId);
    }


    @GetMapping("/jobs/{id}/applicants")
    public List<User> getJobApplicants(@PathVariable Long id)
    {
        return  service.getJobApplicants(id);
    }

    @GetMapping("/jobs/{jid}/applicants/{aid}")
    public User getJobApplicant(@PathVariable Long jid ,@PathVariable Long aid)
    {
        return  service.getSingleJobApplicant(jid,aid);
    }

}
