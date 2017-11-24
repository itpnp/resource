package com.pnp.resource.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="karyawan")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NIK")
	private String nik;
	
	@Column(name="NoOs")
	private String osNumber;
	
	@Column(name="NoKtp")
	private String ktpNumber;
	
	@Column(name="Nm_Karyawan")
	private String employeeName;
	
	@Column(name="Sex")
	private Integer employeeSex;
	
	@Column(name="TmpLahir")
	private String placeOfBirth;
	
	@Column(name="TglLahir")
	private Date dateOfBirth;
	
	@Column(name="GolDarah")
	private String bloodType;
	
	@Column(name="Kd_Marital")
	private String maritalStatus;
	
	@Column(name="JmlAnak")
	private Double totalChildren;
	
	@Column(name="Agama")
	private String religion;
	
	@Column(name="Kd_Pendidikan")
	private String education;
	
	@Column(name="Jurusan")
	private String major;
	
	@Column(name="NPWP")
	private String npwp;
	
	@Column(name="Alamat")
	private String address;
	
	@Column(name="Kota")
	private String city;
	
	@Column(name="NoTelp")
	private String phoneNumber;
	
	@Column(name="NoHP")
	private String mobileNumber;
	
	@Column(name="Email")
	private String email;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_jabatan", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Occupation occupation;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_bagian")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Department department;
	
	@Column(name="Kd_Status")
	private String contractStatus;
	
	@Column(name="TglMasuk")
	private Date dateStartWorking;
	
	@Column(name="TglKeluar")
	private Date dateStopWorking;
	
	@Column(name="Picture")
	private String picture;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "create_by", nullable = true)
	@JsonIgnore
	private Employee createdBy;
	
	@Column(name="create_date")
	private Date dateCreated;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "update_by", nullable = true)
	@JsonIgnore
	private Employee updatedBy;
	
	@Column(name="update_date")
	private Date dateUpdated;
	
	@Column(name="Keterangan")
	private String additionalInfo;
	
	@Column(name="TglPenetapan")
	private Date dateHired;
		
	@Column(name="isActive")
	private int activeStatus;

	public Employee() {
		super();
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getOsNumber() {
		return osNumber;
	}

	public void setOsNumber(String osNumber) {
		this.osNumber = osNumber;
	}

	public String getKtpNumber() {
		return ktpNumber;
	}

	public void setKtpNumber(String ktpNumber) {
		this.ktpNumber = ktpNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(Integer employeeSex) {
		this.employeeSex = employeeSex;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Double getTotalChildren() {
		return totalChildren;
	}

	public void setTotalChildren(Double totalChildren) {
		this.totalChildren = totalChildren;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Date getDateStartWorking() {
		return dateStartWorking;
	}

	public void setDateStartWorking(Date dateStartWorking) {
		this.dateStartWorking = dateStartWorking;
	}

	public Date getDateStopWorking() {
		return dateStopWorking;
	}

	public void setDateStopWorking(Date dateStopWorking) {
		this.dateStopWorking = dateStopWorking;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Employee getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	
	
}
