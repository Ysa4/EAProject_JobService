package com.jobSearch.jobservice.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="job_title")
    private String title;
    @Temporal(TemporalType.DATE)
    private Date deadlineDate;
    @Lob
    @Column(name="job_description")
    private String description;
    @Column(name="job_salary")
    private Double salary;
    @Column(name="job_type")
    private JobType jobType;
    @Column(name="job_status")
    private  JobStatus status;
    @Column(name="job_postedby")
    private Long company;
    @Column(name="job_address")

    private Long address;
    private String experenceNedded;
    private Integer personNeeded;
    private Date postedAt;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="jobId")
    private List<Applicant> applicants =new ArrayList<>();



    public Job() {
    }


    public Job(String title, Date deadlineDate, String description, Double salary, JobType jobType, JobStatus status, Long company, Long address, String experenceNedded, Integer personNeeded, Date postedAt) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCompany() {
        return company;
    }

    public void setCompany(Long company) {
        this.company = company;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
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
