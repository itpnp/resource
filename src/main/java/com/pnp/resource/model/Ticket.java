package com.pnp.resource.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tilang")
public class Ticket {
	
	@Id
	@Column(name="id_tilang")
	private int ticketId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nik", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Employee subject;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nik_penilang", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Employee officer;
	
	@Column(name="tanggal_tilang")
	private Date ticketDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_sub_kategori")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TicketSubCategory subCategoryTicket;
	
	@Column(name="keterangan")
	private String additionalInfo;
	
	@Column(name="nominal_tilang")
	private Long fine;

	public Ticket() {
		super();
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Employee getSubject() {
		return subject;
	}

	public void setSubject(Employee subject) {
		this.subject = subject;
	}

	public Employee getOfficer() {
		return officer;
	}

	public void setOfficer(Employee officer) {
		this.officer = officer;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	public TicketSubCategory getSubCategoryTicket() {
		return subCategoryTicket;
	}

	public void setSubCategoryTicket(TicketSubCategory subCategoryTicket) {
		this.subCategoryTicket = subCategoryTicket;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Long getFine() {
		return fine;
	}

	public void setFine(Long fine) {
		this.fine = fine;
	}
	
}
