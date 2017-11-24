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

import com.pnp.resource.util.HibernateUtilReward;
import com.pnp.resource.dao.EmployeeDao;
import com.pnp.resource.model.Employee;

@Repository ("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
private Session session;

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		List<Employee> listEmployee = new ArrayList<>();
		try{
			System.out.println("Retrieving All Employee Data...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("From Employee");
			listEmployee = query.list();
			for (Employee detail : listEmployee) {
			    Hibernate.initialize(detail.getOccupation());
			    Hibernate.initialize(detail.getCreatedBy());
			    Hibernate.initialize(detail.getDepartment());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			 if (session.isOpen()){
	                session.close();
	            }
		}
		return listEmployee;
	}

	@Override
	public Employee findById(String nik) {
		Employee employee = null;
		try{
			System.out.println("Searching data "+ nik +"...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Employee.class)
					.add(Restrictions.eq("nik", nik));
			employee = (Employee) crt.uniqueResult();
			if(employee != null) {
				Hibernate.initialize(employee.getOccupation());
			    Hibernate.initialize(employee.getCreatedBy());
			    Hibernate.initialize(employee.getDepartment());
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

}
