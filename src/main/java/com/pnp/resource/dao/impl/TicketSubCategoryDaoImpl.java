package com.pnp.resource.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.TicketSubCategoryDao;
import com.pnp.resource.model.TicketSubCategory;
import com.pnp.resource.util.HibernateUtilReward;

@Repository("ticketSubCategoryDao")
public class TicketSubCategoryDaoImpl implements TicketSubCategoryDao {

	private Session session;
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSubCategory> getAllData() {
		List<TicketSubCategory> listSubCategory = new ArrayList<>();
		try{
			System.out.println("Retrieving data sub category ticket...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(TicketSubCategory.class)
					.add(Restrictions.eq("status", "AKTIF"));
			listSubCategory = crt.list();
			for (TicketSubCategory detail : listSubCategory) {
			    Hibernate.initialize(detail.getTicketCategory());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if (session.isOpen()){
                session.close();
            }
		}
		return listSubCategory;
	}

	@Override
	public TicketSubCategory findById(int id) {
		TicketSubCategory subCategory = null;
		try{
			System.out.println("Retrieving data sub category ticket...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("From TicketCategory");
			subCategory = (TicketSubCategory) query.uniqueResult();
			if(subCategory != null){
				Hibernate.initialize(subCategory.getTicketCategory());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if (session.isOpen()){
                session.close();
            }
		}
		return subCategory;
	}

	@Override
	public boolean addTicketCategory(TicketSubCategory category) {
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
	public boolean deleteTicketCategory(TicketSubCategory category) {
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
