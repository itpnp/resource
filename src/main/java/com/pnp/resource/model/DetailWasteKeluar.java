package com.pnp.resource.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_detail_keluar_waste")
public class DetailWasteKeluar {
	
	@Id
	@Column(name="KODE_RIM")
	private String kodeRim;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_mutasi_keluar")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private WasteKeluar wasteKeluar;
	
	@Column(name="STATUS")
	private String status;

	public String getKodeRim() {
		return kodeRim;
	}

	public void setKodeRim(String kodeRim) {
		this.kodeRim = kodeRim;
	}

	public WasteKeluar getWasteKeluar() {
		return wasteKeluar;
	}

	public void setWasteKeluar(WasteKeluar wasteKeluar) {
		this.wasteKeluar = wasteKeluar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
