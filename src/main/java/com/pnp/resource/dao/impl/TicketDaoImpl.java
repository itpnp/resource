package com.pnp.resource.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.resource.dao.TicketDao;
import com.pnp.resource.model.Ticket;
import com.pnp.resource.util.HibernateUtilReward;

@Repository("ticketDao")
public class TicketDaoImpl implements TicketDao {

	private Session session;
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Ticket> getAllData() {
		List<Ticket> listTicket = new ArrayList<>();
		try{
			System.out.println("Retrieving data ticket...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("From Ticket");
			listTicket = query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if (session.isOpen()){
                session.close();
            }
		}
		return listTicket;
	}

	@Override
	public Ticket findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findByNik(String nik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findByDepartmentName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> findByDepartmentAndMonth(String name, String month, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalTicketByEmployeeAndMonth(String nik, String month, String year) {
		int total = 0;
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Ticket.class,"ticket")
					.createAlias("ticket.employee", "emp")
					.add(Restrictions.eq("emp.nik", nik))
					.add(Restrictions.sqlRestriction("MONTH(ticket.ticketDate) = '"+month+"' and YEAR(ticket.ticketDate) = '"+year+"'"));
					crt.setProjection(Projections.rowCount());
			total = (int)crt.uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return total;
	}

	@Override
	public List<Ticket> findByMonth(String month, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
