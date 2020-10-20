package com.project.recruitmentoperation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.recruitmentoperation.dao.JobAppDAO;
import com.project.recruitmentoperation.entity.JobApplication;
import com.project.recruitmentoperation.entity.JobProcessDetails;
import com.project.recruitmentoperation.entity.User;
import com.project.recruitmentoperation.service.JobApplicationService;
import com.project.recruitmentoperation.service.UserService;

@Controller
@SessionAttributes("job")
public class JobProcessController {
	 @Autowired
	    private JobApplicationService JobApplicationService;
	 @Autowired
	    private UserService userService;
	 @Autowired
		JobAppDAO jobAppDao;
	 List<JobApplication> lst;

		
//		CANDIDATE PART
		@RequestMapping(value = "/candidateJobAppList", method = RequestMethod.GET)
		public ModelAndView candidateJobAppList(HttpServletRequest request) {
			ModelAndView m = new ModelAndView();

			
			 HttpSession session = request.getSession();
				
				int id=(int) session.getAttribute("id");
				      
		          User user=userService.viewprofile(id);
		     

//	    	Getting list of interviewer from database
			lst = jobAppDao.getAll();
			   boolean jobs=  JobApplicationService.validate(user);
				  if(jobs)
				  {
					  m.setViewName("CandidateJobApplicationList");
			m.addObject("lst", lst);
			 JobProcessDetails job=new JobProcessDetails();
			    m.addObject("job",job);
				  }
				  else
				  {
					  JobProcessDetails job=user.getJobProcessDetails();
					   m.addObject("job",job);
						
					  m.setViewName("status");
					  
				  }

			return m;
		}
		
		 @RequestMapping(value = "/apply")
		 public ModelAndView applyforjob(@RequestParam("id") int id,HttpServletRequest request)
		 {
			 JobApplication jobApplication=JobApplicationService.getJob(id);
			 HttpSession session = request.getSession();
			   session.setAttribute("jid",jobApplication.getJid());
			 
			   ModelAndView mav = new ModelAndView("jobapplication");
			   return mav;
				 
		 }
		 @RequestMapping(value = "/uploadresume", method = RequestMethod.POST)
		    public ModelAndView handleFileUpload(@ModelAttribute("job")  JobProcessDetails job,HttpServletRequest request)  {
			   ModelAndView mav = new ModelAndView("status");
				
			 HttpSession session = request.getSession();
				
				int id=(int) session.getAttribute("id");
				   int jid=(int)  session.getAttribute("jid"); 
		          User user=userService.viewprofile(id);
		     
		          JobApplication jobApplication=JobApplicationService.getJob(jid);
					job.setJobApplication(jobApplication);
					
					  job.setUser(user);
					  user.setJobProcessDetails(job);
		             	JobApplicationService.save(job);
		             	mav.addObject("job",job);
				  
		        		 
		  
		        return mav;
		    }  


}
