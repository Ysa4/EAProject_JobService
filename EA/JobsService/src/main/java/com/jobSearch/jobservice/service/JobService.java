package com.jobSearch.jobservice.service;


import com.jobSearch.jobservice.domain.Applicant;
import com.jobSearch.jobservice.domain.Job;
import com.jobSearch.jobservice.domain.JobStatus;
import com.jobSearch.jobservice.dto.JobData;
import com.jobSearch.jobservice.dto.company.Company;
import com.jobSearch.jobservice.dto.user.User;
import com.jobSearch.jobservice.repository.JobRepository;
import com.jobSearch.jobservice.util.RestTemplateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class JobService  implements  IJobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<JobData> getAlljob() {
     List<Job> returnedJobs = jobRepository.findAll();
      List<JobData>  jobDataList= new ArrayList<JobData>();
        for (Job job:returnedJobs) {
            JobData  newjobData = new JobData();
            newjobData.setTitle(job.getTitle());
            newjobData.setDeadlineDate(job.getDeadlineDate());
            newjobData.setDescription(job.getDescription());
            newjobData.setSalary(job.getSalary());
            newjobData.setJobType(job.getJobType());
            newjobData.setStatus(job.getStatus());
            newjobData.setAddress("");
            newjobData.setExperenceNedded(job.getExperenceNedded());
            newjobData.setPersonNeeded(job.getPersonNeeded());
            newjobData.setPostedAt(job.getPostedAt());
            Company company = RestTemplateHelper.getCompanyInfo(job.getId());
            newjobData.setCompany(company);
            jobDataList.add(newjobData);
        }


        return jobDataList;
    }

    @Override
    public JobData getJob(Long id) {

        Job job = jobRepository.findById(id).get();

            JobData  newjobData = new JobData();
            newjobData.setTitle(job.getTitle());
            newjobData.setDeadlineDate(job.getDeadlineDate());
            newjobData.setDescription(job.getDescription());
            newjobData.setSalary(job.getSalary());
            newjobData.setJobType(job.getJobType());
            newjobData.setStatus(job.getStatus());
            newjobData.setAddress("");
            newjobData.setExperenceNedded(job.getExperenceNedded());
            newjobData.setPersonNeeded(job.getPersonNeeded());
            newjobData.setPostedAt(job.getPostedAt());
            Company company = RestTemplateHelper.getCompanyInfo(job.getId());
            newjobData.setCompany(company);




        return newjobData;
    }

    @Override
    public void addJOb( Job job) {

        Job  newjob = new Job();
        newjob.setTitle(job.getTitle());
        newjob.setDeadlineDate(job.getDeadlineDate());
        newjob.setDescription(job.getDescription());
        newjob.setSalary(job.getSalary());
        newjob.setJobType(job.getJobType());
        newjob.setStatus(job.getStatus());
        newjob.setCompany(job.getCompany());
        newjob.setAddress(job.getAddress());
        newjob.setExperenceNedded(job.getExperenceNedded());
        newjob.setPersonNeeded(job.getPersonNeeded());
        newjob.setPostedAt(job.getPostedAt());
        jobRepository.save(newjob);

    }

    @Override
    public void deleteJob(Long id) {
          jobRepository.deleteById(id);
    }

    @Override
    public void UpdateJob(Long id ,Job job) {
        if(jobRepository.findById(id).isPresent())
        {
            Job  j = jobRepository.findById(id).get();
             j.setTitle(job.getTitle());
            j.setDeadlineDate(job.getDeadlineDate());
            j.setDescription(job.getDescription());
            j.setSalary(job.getSalary());
            j.setJobType(job.getJobType());
            j.setStatus(job.getStatus());
            j.setCompany(job.getCompany());
            j.setAddress(job.getAddress());
            j.setExperenceNedded(job.getExperenceNedded());
            j.setPersonNeeded(job.getPersonNeeded());
            j.setPostedAt(job.getPostedAt());
            jobRepository.save(j);
        }

    }




    @Override
    public List<Job> search() {
        return jobRepository.findAll().stream().filter(job -> job.getStatus() == JobStatus.AVAILABLE).toList();
    }

    public Boolean checkUser(Long id)
    {
       User user = this.getUser(id);
       if(Objects.isNull(user))
       {
           return false;
       }
       return  true;

    }

    @Override
    public void apply(Long jobId, Long userId) {


        if(this.checkUser(userId))
        {
            Job job = jobRepository.findById(jobId).get();
            Applicant applicant =  new Applicant(userId);
            job.addApplicant(applicant);
            jobRepository.save(job);
        }

    }

    @Override
    public User getUser(Long id) {
        return RestTemplateHelper.getUser(id);
    }



    @Override
    public List<User> getJobApplicants(Long jobId) {
        List<User> users = new ArrayList<>();
        this.getJob(jobId).getApplicants().forEach(a-> users.add(this.getUser(a.getUserId())));
      return users;
    }

    @Override
    public User getSingleJobApplicant(Long jobId, Long applicantId) {
        User user;
        Job job = jobRepository.findById(jobId).get();
        List<Applicant> applicants = job.getApplicants();
        if(applicants.stream().findFirst().isEmpty())
        {
            return null;
        }
        else{
            Applicant applicant =applicants.stream().filter(applicant1 ->applicant1.getId() == applicantId).findFirst().get();
            user = this.getUser(applicant.getUserId());
        }
        return user;
    }


}
