package com.pnp.resource.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.KartuKerjaDao;
import com.pnp.resource.model.KartuKerja;
import com.pnp.resource.util.HibernateUtil;

@Repository("kartuKerjaDao")
public class KartuKerjaDaoImpl implements KartuKerjaDao{

	private Session session;

	@SuppressWarnings("unchecked")
	@Override
	public List<KartuKerja> getAllData() {
		List<KartuKerja> listKartuKerja = new ArrayList<KartuKerja>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(KartuKerja.class);
			listKartuKerja = crt.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return listKartuKerja;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KartuKerja> findByDesain(String desain) {
		List<KartuKerja> listKartuKerja = new ArrayList<KartuKerja>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(KartuKerja.class)
					.add(Restrictions.eq("desain", desain));
			listKartuKerja = crt.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return listKartuKerja;
	}

	@Override
	public boolean save(KartuKerja kartuKerja) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
