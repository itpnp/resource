package com.pnp.resource.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_master_kk")
public class KartuKerja {
	
	@Id
	@Column(name="NOMOR_KK")
	private String nomorKK;
	
	@Column(name="DELIVERY_TIME")
	private String deliveryTime;
	
	@Column(name="KODE_BAHAN")
	private String kodeBahan;
	
	@Column(name="JML_PESANAN")
	private Long jmlPesanan;
	
	@Column(name="DESAIN")
	private Long desain;
	
	@Column(name="TAHUN")
	private Long tahun;
	
	@Column(name="NOMOR_BAPOB")
	private String nomorBapob;
	
	@Column(name="TANGGAL_PROSES_MESIN")
	@Temporal(TemporalType.DATE)
	private Date tanggalProses;
	
	
	public KartuKerja(String nomorKK, String deliveryTime, String kodeBahan, Long jmlPesanan, Long desain, Long tahun,
			String nomorBapob, Date tanggalProses) {
		super();
		this.nomorKK = nomorKK;
		this.deliveryTime = deliveryTime;
		this.kodeBahan = kodeBahan;
		this.jmlPesanan = jmlPesanan;
		this.desain = desain;
		this.tahun = tahun;
		this.nomorBapob = nomorBapob;
		this.tanggalProses = tanggalProses;
	}
	
	public KartuKerja() {
		super();
	}

	public String getNomorKK() {
		return nomorKK;
	}

	public void setNomorKK(String nomorKK) {
		this.nomorKK = nomorKK;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getKodeBahan() {
		return kodeBahan;
	}

	public void setKodeBahan(String kodeBahan) {
		this.kodeBahan = kodeBahan;
	}

	public Long getJmlPesanan() {
		return jmlPesanan;
	}

	public void setJmlPesanan(Long jmlPesanan) {
		this.jmlPesanan = jmlPesanan;
	}

	public Long getDesain() {
		return desain;
	}

	public void setDesain(Long desain) {
		this.desain = desain;
	}

	public Long getTahun() {
		return tahun;
	}

	public void setTahun(Long tahun) {
		this.tahun = tahun;
	}

	public String getNomorBapob() {
		return nomorBapob;
	}

	public void setNomorBapob(String nomorBapob) {
		this.nomorBapob = nomorBapob;
	}

	public Date getTanggalProses() {
		return tanggalProses;
	}

	public void setTanggalProses(Date tanggalProses) {
		this.tanggalProses = tanggalProses;
	}

	
}
