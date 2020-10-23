package com.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Category;
import com.entities.Position;

@Repository
@Transactional
public class CategoryDao {

	
	 @Autowired
	    private SessionFactory sessionFactory;
	
		public List<Category> getCategory() {
			 Session session = sessionFactory.getCurrentSession();
		        CriteriaBuilder cb = session.getCriteriaBuilder();
		        CriteriaQuery < Category > cq = cb.createQuery(Category.class);
		        Root < Category > root = cq.from(Category.class);
		        cq.select(root);
		        Query query = session.createQuery(cq);
		        return query.getResultList();
			
		}

		
}
