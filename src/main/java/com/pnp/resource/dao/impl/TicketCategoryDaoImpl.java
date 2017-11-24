package com.pnp.resource.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.TicketCategoryDao;
import com.pnp.resource.model.TicketCategory;
import com.pnp.resource.util.HibernateUtilReward;

@Repository("ticketCategoryDao")
public class TicketCategoryDaoImpl implements TicketCategoryDao {

	private Session session;
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<TicketCategory> getAllData() {
		List<TicketCategory> listCategory = new ArrayList<>();
		try{
			System.out.println("Retrieving data category ticket...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(TicketCategory.class)
					.add(Restrictions.eq("status", "AKTIF"));
			listCategory = crt.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if (session.isOpen()){
                session.close();
            }
		}
		return listCategory;
	}

	@Override
	public TicketCategory findById(int id) {
		TicketCategory category = null;
		try{
			System.out.println("Retrieving data category ticket...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(TicketCategory.class)
					.add(Restrictions.eq("categoryId", id));
			category = (TicketCategory)crt.uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if (session.isOpen()){
                session.close();
            }
		}
		return category;
	}

	@Override
	public boolean addTicketCategory(TicketCategory category) {
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(category);
	        session.getTransaction().commit();
	        return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			 if(session.isOpen()){
	            session.close();
	         }
		}
	}

	@Override
	public boolean updateTicketCategory(TicketCategory category) {
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(category);
	        session.getTransaction().commit();
	        return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			 if(session.isOpen()){
	            session.close();
	         }
		}
	}

}
