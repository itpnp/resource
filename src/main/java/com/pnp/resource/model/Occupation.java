package com.pnp.resource.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jabatan")
public class Occupation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jabatan")
	private int occupationId;
	
	@Column(name="Kd_Jabatan")
	private String occupationCode;
	
	@Column(name="Nm_Jabatan")
	private String occupationName;
	
	@Column(name="Keterangan")
	private String additionalInfo;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "CreatedBy", nullable = false)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name="CreatedDate")
	private Date createdDate;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "UpdatedBy", nullable = false)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
	@Column(name = "UpdatedBy")
	private String updatedBy;
	
	@Column(name="UpdatedDate")
	private Date dateUpdated;
	
	@Column(name="level_jabatan")
	private int occupationLevel;

	public Occupation() {
		super();
	}

	public int getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public int getOccupationLevel() {
		return occupationLevel;
	}

	public void setOccupationLevel(int occupationLevel) {
		this.occupationLevel = occupationLevel;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}	
	
}
