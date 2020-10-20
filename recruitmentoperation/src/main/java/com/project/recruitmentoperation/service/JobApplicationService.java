package com.project.recruitmentoperation.service;

import com.project.recruitmentoperation.entity.JobApplication;
import com.project.recruitmentoperation.entity.JobProcessDetails;
import com.project.recruitmentoperation.entity.User;

public interface JobApplicationService {
	
	public void	save (JobProcessDetails upload);

	public boolean validate(User user);

	public JobApplication getJob(int id);
	 

}
