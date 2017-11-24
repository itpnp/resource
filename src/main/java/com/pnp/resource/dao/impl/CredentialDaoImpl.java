package com.pnp.resource.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.CredentialDao;
import com.pnp.resource.model.Credential;
import com.pnp.resource.model.Employee;
import com.pnp.resource.util.HibernateUtilReward;

@Repository("credentialDao")
public class CredentialDaoImpl implements CredentialDao {

	private Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Credential> listUserApp() {
		List<Credential> listCredential = new ArrayList<>();
		try{
			System.out.println("Opening...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Credential.class).add(Restrictions.eq("status", "1"));
			listCredential = crt.list();
			for (Credential detail : listCredential) {
			    Hibernate.initialize(detail.getEmployee());
			    Hibernate.initialize(detail.getEmployee().getOccupation());
			    Hibernate.initialize(detail.getEmployee().getDepartment());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if (session.isOpen()){
	                session.close();
	            }
		}
		return listCredential;
	}

	@Override
	public Credential login(String username, String password) {
		Credential credential = null;
		
		try{
			System.out.println("Checking Username And Password...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Credential.class)
					.add(Restrictions.eq("username", username))
					.add(Restrictions.eq("password", password));
			credential = (Credential) crt.uniqueResult();
			if(credential != null) {
			    Hibernate.initialize(credential.getEmployee());
			    Hibernate.initialize(credential.getEmployee().getOccupation());
			    Hibernate.initialize(credential.getEmployee().getDepartment());
			    Hibernate.initialize(credential.getEmployee().getCreatedBy());
			    Hibernate.initialize(credential.getEmployee().getUpdatedBy());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if (session.isOpen()){
	                session.close();
	            }
		}
		return credential;
	}

	@Override
	public boolean addCredential(Credential credential) {
		try{
			System.out.println("Checking Username And Password...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(credential);
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
	public Employee findByEmployeeId(String nik) {
		Employee employee = null;
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Employee.class)
					.add(Restrictions.eq("nik", nik));
			employee = (Employee) crt.uniqueResult();
			if(employee != null) {
			    Hibernate.initialize(employee.getCreatedBy());
			    Hibernate.initialize(employee.getDepartment().getCreatedBy());
			    Hibernate.initialize(employee.getDepartment().getUpdatedBy());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if (session.isOpen()){
	                session.close();
	            }
		}
		return employee;
	}

	@Override
	public boolean updateCredential(Credential credential) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Updating data...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(credential);
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
	public Credential findById(int id) {
		Credential credential = null;
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Credential.class)
					.add(Restrictions.eq("accessId", id));
			credential = (Credential) crt.uniqueResult();
			if(credential != null) {
			    Hibernate.initialize(credential.getEmployee());
			    Hibernate.initialize(credential.getEmployee().getDepartment());
			    Hibernate.initialize(credential.getEmployee().getOccupation());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if (session.isOpen()){
	                session.close();
	            }
		}
		return credential;
	}
	


}
