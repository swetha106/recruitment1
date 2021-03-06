package com.project.recruitmentoperation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Entity
@Table(name = "jobprocess")

public class JobProcessDetails {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "jobid")
	    private int jobid;
	
	 private int currentround;
	 private int marks;
	 private boolean selected;
	 private CommonsMultipartFile[]  resume;
  @OneToOne
  private User user;
  @ManyToOne
	private JobApplication jobApplication;

	  public int getJobid() {
	        return jobid;
	    }

	    public void setJobid(int jobid) {
	        this.jobid = jobid;
	    }
	    public int getCurrentround() {
	        return currentround;
	    }

	    public void setCurrentround(int currentround) {
	        this.currentround = currentround;
	    }
	    public int getMarks() {
	        return marks;
	    }

	    public void setMarks(int marks) {
	        this.marks = marks;
	    }
	    public Boolean getSelected() {
		    return selected;
		  }

		  public void setSelected(Boolean selected) {
		    this.selected = selected;
		  }
		  public JobApplication getJobApplication() {
		        return jobApplication;
		    }
		 
		    public void setJobApplication(JobApplication jobApplication) {
		        this.jobApplication = jobApplication;
		    }
		    public User getUser() {
		        return user;
		    }
		 
		    public void setUser(User user) {
		        this.user = user;
		    }
	 
	 
	 @Column(name = "resume")
	    public CommonsMultipartFile[] getResume() {
	        return resume;
	    }
	 
	    public void setResume(CommonsMultipartFile[] resume) {
	        this.resume = resume;
	    }
	    
	    @Override
		public String toString() {
			return "JobProcessDetails [jobid=" + jobid +"currentround=" + currentround + ", marks=" + marks  + ", selected=" + selected+", resume=" + resume + "]";
		}

}
