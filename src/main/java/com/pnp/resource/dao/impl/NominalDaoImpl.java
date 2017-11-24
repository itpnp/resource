package com.pnp.resource.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.NominalDao;
import com.pnp.resource.model.Nominal;
import com.pnp.resource.util.HibernateUtilReward;

@Repository("nominalDao")
public class NominalDaoImpl implements NominalDao {

	private Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Nominal> getAllData() {
		List<Nominal> listNominal = new ArrayList<>();
		try{
			System.out.println("Opening...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Nominal.class);
			listNominal = crt.list();
			for (Nominal detail : listNominal) {
			    Hibernate.initialize(detail.getOccupation());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if (session.isOpen()){
	                session.close();
	            }
		}
		return listNominal;
	}

	@Override
	public Nominal findByOccupation(int occupationId) {
		Nominal nominal = null;
		try{
			System.out.println("Searching By Occupation id... ");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Nominal.class)
					.add(Restrictions.eq("occupation.occupationId", occupationId));
			nominal = (Nominal) crt.uniqueResult();
			if(nominal != null) {
			    Hibernate.initialize(nominal.getOccupation());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if(session.isOpen()){
	            session.close();
	         }
		}
		return nominal;
	}

	@Override
	public boolean addNominal(Nominal nominal) {
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(nominal);
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
	public boolean updateNominal(Nominal nominal) {
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(nominal);
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
