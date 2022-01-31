package com.jobSearch.jobservice.dto;


import com.jobSearch.jobservice.domain.Applicant;
import com.jobSearch.jobservice.domain.JobStatus;
import com.jobSearch.jobservice.domain.JobType;
import com.jobSearch.jobservice.dto.company.Company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobData {




    private String title;

    private Date deadlineDate;

    private String description;

    private Double salary;

    private JobType jobType;

    private JobStatus status;
    private Company company;

    private String address;
    private String experenceNedded;
    private Integer personNeeded;
    private Date postedAt;

    private List<Applicant> applicants =new ArrayList<>();



    public JobData() {
    }


    public JobData(String title, Date deadlineDate, String description, Double salary, JobType jobType, JobStatus status, Company company, String address, String experenceNedded, Integer personNeeded, Date postedAt) {
        this.title = title;
        this.deadlineDate = deadlineDate;
        this.description = description;
        this.salary = salary;
        this.jobType = jobType;
        this.status = status;
        this.company = company;
        this.address = address;
        this.experenceNedded = experenceNedded;
        this.personNeeded = personNeeded;
        this.postedAt = postedAt;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExperenceNedded() {
        return experenceNedded;
    }

    public void setExperenceNedded(String experenceNedded) {
        this.experenceNedded = experenceNedded;
    }

    public Integer getPersonNeeded() {
        return personNeeded;
    }

    public void setPersonNeeded(Integer personNeeded) {
        this.personNeeded = personNeeded;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
    public void addApplicant(Applicant applicant) {
        this.applicants.add(applicant);
    }
}
