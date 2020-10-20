package com.project.recruitmentoperation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.recruitmentoperation.entity.JobApplication;
import com.project.recruitmentoperation.entity.JobProcessDetails;
import com.project.recruitmentoperation.entity.User;

@Repository
public class JobApplicationDaoImpl implements JobApplicationDao {
	  @Autowired
	    private SessionFactory sessionFactory;
	  
	  
	     
	    public JobApplicationDaoImpl() {
	    }
	 
	    public JobApplicationDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	    @Override
	    public void save(JobProcessDetails uploadFile) {
	   
	        sessionFactory.getCurrentSession().save(uploadFile);
	        
	    }

		@Override
		public boolean validate(User user) {
			JobProcessDetails users = null;
		        try (Session session = sessionFactory.openSession()) {
		              users = (JobProcessDetails) session.createQuery("FROM JobProcessDetails U WHERE U.user = :user " )
		            		  .setParameter("user", user) .uniqueResult();

		       
		        }
		        if(users==null)
		       return true;
		        else
		        	return false;
	   		}
		
	
		@Override
		public JobApplication getJob(int id)
		{ Session currentSession = sessionFactory.getCurrentSession();
		JobApplication jobApplication =(JobApplication) currentSession.get(JobApplication.class, id);
        return jobApplication;
			
		}

}
