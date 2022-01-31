package com.jobSearch.jobservice.dto.user;



import java.util.Date;

public class Education {

    private String institutionName;
    private EducationLevel educationlevel;

    private Date startDate;

    private Date endDate;
    public Education(){}
    public Education(String institutionName, EducationLevel educationlevel, Date startDate, Date endDate) {
        this.institutionName = institutionName;
        this.educationlevel = educationlevel;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public EducationLevel getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(EducationLevel educationlevel) {
        this.educationlevel = educationlevel;
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
