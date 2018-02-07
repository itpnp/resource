package com.pnp.resource.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
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
			for (Ticket detail : listTicket) {
			    Hibernate.initialize(detail.getSubject());
			    Hibernate.initialize(detail.getSubject().getOccupation());
			    Hibernate.initialize(detail.getSubject().getDepartment());
			    Hibernate.initialize(detail.getSubject().getCreatedBy());
			    Hibernate.initialize(detail.getOfficer());
			    Hibernate.initialize(detail.getOfficer().getOccupation());
			    Hibernate.initialize(detail.getOfficer().getDepartment());
			    Hibernate.initialize(detail.getOfficer().getCreatedBy());
			    Hibernate.initialize(detail.getSubCategoryTicket());
			    Hibernate.initialize(detail.getSubCategoryTicket().getTicketCategory());
			}
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
		Ticket ticket = new Ticket();
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Ticket.class,"ticket")
					.add(Restrictions.eq("ticket.ticketId", id));
			ticket = (Ticket)crt.uniqueResult();
			if(ticket != null){
			    Hibernate.initialize(ticket.getSubject());
			    Hibernate.initialize(ticket.getSubject().getOccupation());
			    Hibernate.initialize(ticket.getSubject().getDepartment());
			    Hibernate.initialize(ticket.getSubject().getCreatedBy());
			    Hibernate.initialize(ticket.getOfficer());
			    Hibernate.initialize(ticket.getOfficer().getOccupation());
			    Hibernate.initialize(ticket.getOfficer().getDepartment());
			    Hibernate.initialize(ticket.getOfficer().getCreatedBy());
			    Hibernate.initialize(ticket.getSubCategoryTicket());
			    Hibernate.initialize(ticket.getSubCategoryTicket().getTicketCategory());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return ticket;
	}

	@Override
	public List<Ticket> findByNik(String nik) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findByDepartmentName(String name) {
		List<Ticket> listTicket = new ArrayList<>();
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Ticket.class,"ticket")
					.createAlias("ticket.subject", "pelaku")
					.createAlias("pelaku.department", "department")
					.add(Restrictions.eq("department.departmentName", name));
			listTicket = crt.list();
			for (Ticket detail : listTicket) {
			    Hibernate.initialize(detail.getSubject());
			    Hibernate.initialize(detail.getSubject().getOccupation());
			    Hibernate.initialize(detail.getSubject().getDepartment());
			    Hibernate.initialize(detail.getSubject().getCreatedBy());
			    Hibernate.initialize(detail.getOfficer());
			    Hibernate.initialize(detail.getOfficer().getOccupation());
			    Hibernate.initialize(detail.getOfficer().getDepartment());
			    Hibernate.initialize(detail.getOfficer().getCreatedBy());
			    Hibernate.initialize(detail.getSubCategoryTicket());
			    Hibernate.initialize(detail.getSubCategoryTicket().getTicketCategory());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return listTicket;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findByDepartmentAndMonth(String name, String month, String year) {
		List<Ticket> listTicket = new ArrayList<>();
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Ticket.class,"ticket")
					.createAlias("ticket.subject", "pelaku")
					.createAlias("pelaku.department", "department")
					.add(Restrictions.eq("department.departmentName", name))
					.add(Restrictions.sqlRestriction("MONTH(tanggal_tilang) = '"+month+"' and YEAR(tanggal_tilang) = '"+year+"'"));

			listTicket = crt.list();
			for (Ticket detail : listTicket) {
			    Hibernate.initialize(detail.getSubject());
			    Hibernate.initialize(detail.getSubject().getOccupation());
			    Hibernate.initialize(detail.getSubject().getDepartment());
			    Hibernate.initialize(detail.getSubject().getCreatedBy());
			    Hibernate.initialize(detail.getOfficer());
			    Hibernate.initialize(detail.getOfficer().getOccupation());
			    Hibernate.initialize(detail.getOfficer().getDepartment());
			    Hibernate.initialize(detail.getOfficer().getCreatedBy());
			    Hibernate.initialize(detail.getSubCategoryTicket());
			    Hibernate.initialize(detail.getSubCategoryTicket().getTicketCategory());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return listTicket;
	}

	@Override
	public Long getTotalTicketByEmployeeAndMonth(String nik, String month, String year) {
		long total = 0;
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Ticket.class,"ticket")
					.createAlias("ticket.subject", "emp")
					.add(Restrictions.eq("emp.nik", nik))
					.add(Restrictions.sqlRestriction("MONTH(tanggal_tilang) = '"+month+"' and YEAR(tanggal_tilang) = '"+year+"'"));
					crt.setProjection(Projections.rowCount());
			total = (long)crt.uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findByMonth(String month, String year) {
		List<Ticket> listTicket = new ArrayList<>();
		try{
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria crt = session.createCriteria(Ticket.class,"ticket")
					.add(Restrictions.sqlRestriction("MONTH(tanggal_tilang) = '"+month+"' and YEAR(tanggal_tilang) = '"+year+"'"));
			listTicket = crt.list();
			for (Ticket detail : listTicket) {
			    Hibernate.initialize(detail.getSubject());
			    Hibernate.initialize(detail.getSubject().getOccupation());
			    Hibernate.initialize(detail.getSubject().getDepartment());
			    Hibernate.initialize(detail.getSubject().getCreatedBy());
			    Hibernate.initialize(detail.getOfficer());
			    Hibernate.initialize(detail.getOfficer().getOccupation());
			    Hibernate.initialize(detail.getOfficer().getDepartment());
			    Hibernate.initialize(detail.getOfficer().getCreatedBy());
			    Hibernate.initialize(detail.getSubCategoryTicket());
			    Hibernate.initialize(detail.getSubCategoryTicket().getTicketCategory());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return listTicket;
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		try{
			System.out.println("updating data ticket...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(ticket);
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			if (session.isOpen()){
                session.close();
            }
		}
	}

	@Override
	public boolean addTicket(Ticket ticket) {
		try{
			System.out.println("saving data ticket...");
			session = HibernateUtilReward.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(ticket);
			session.getTransaction().commit();
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally{
			if (session.isOpen()){
                session.close();
            }
		}
	}
	
}
