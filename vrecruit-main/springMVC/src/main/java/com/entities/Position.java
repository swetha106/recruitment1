package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Position {
	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "pid")
	    private int pid;
		
		private String position_type;
		
		
		public String getPosition_type() {
			return position_type;
		}

		public void setPosition_type(String position_type) {
			this.position_type = position_type;
		}
	
		 public int getPId() {
		        return pid;
		    }

		    public void setPId(int pid) {
		        this.pid = pid;
		    }

}
