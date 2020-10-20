package com.project.recruitmentoperation.dao;

import com.project.recruitmentoperation.entity.JobApplication;
import com.project.recruitmentoperation.entity.JobProcessDetails;
import com.project.recruitmentoperation.entity.User;

public interface JobApplicationDao {
	
	  public void save(JobProcessDetails uploadFile) ;

	public boolean validate(User user);

	public JobApplication getJob(int id);

}
