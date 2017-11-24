package com.pnp.resource.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.OccupationDao;
import com.pnp.resource.model.Occupation;
import com.pnp.resource.util.HibernateUtilReward;

@Repository("occupationDao")
public class OccupationDaoImpl implements OccupationDao {

	private Session session;
	@Override
	public Occupation findById(int id) {
		Occupation ocp = null;
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Occupation.class)
					.add(Restrictions.eq("occupationId", id));
			ocp = (Occupation) crt.uniqueResult();
			if(ocp != null) {
			    Hibernate.initialize(ocp.getCreatedBy());
			    Hibernate.initialize(ocp.getUpdatedBy());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if (session.isOpen()){
	                session.close();
	            }
		}
		return ocp;
	}

}
