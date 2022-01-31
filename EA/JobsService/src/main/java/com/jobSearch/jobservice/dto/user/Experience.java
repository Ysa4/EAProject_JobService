package com.jobSearch.jobservice.dto.user;

import java.util.Date;

public class Experience {

    private String jobName;
    private String companyName;
    private String duration;
    private Date startDate;

    private Date endDate;

    public Experience(){}
    public Experience(String jobName, String companyName, String duration, Date startDate, Date endDate) {
        this.jobName = jobName;
        this.companyName = companyName;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
