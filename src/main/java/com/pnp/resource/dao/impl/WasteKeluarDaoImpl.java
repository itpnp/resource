package com.pnp.resource.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.WasteKeluarDao;
import com.pnp.resource.model.KartuKerja;
import com.pnp.resource.model.WasteKeluar;
import com.pnp.resource.util.HibernateUtil;

@Repository("wasteKeluarDao")
public class WasteKeluarDaoImpl implements WasteKeluarDao {

	private Session session;
	@Override
	public int getLastId() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria crt = session.createCriteria(WasteKeluar.class);
		ProjectionList projList = Projections.projectionList();
        projList.add(Projections.max("id"));
        crt.setProjection(projList);
        
        if(crt.list().get(0)!=null){
        	 List results = crt.list();
        	 System.out.println(results);
        	 return 1;
        }else{
        	return 0;
        }
       
	}

	@Override
	public boolean saveWaste(WasteKeluar wasteKeluar) {
		// TODO Auto-generated method stub
		return false;
	}

}
