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
@Table(name="nominal_tilang")
public class Nominal {
	
	@Id
	@Column(name="id_nominal")
	private int nominalId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "kode_jabatan", nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Occupation occupation;
	
	@Column(name="tilang_1")
	private Long tilang1;
	
	@Column(name="tilang_2")
	private Long tilang2;
	
	@Column(name="tilang_3")
	private Long tilang3;
	
	@Column(name="tilang_4")
	private Long tilang4;
	
	@Column(name="tilang_5")
	private Long tilang5;
	
	
	public Nominal() {
		super();
	}

	public int getNominalId() {
		return nominalId;
	}

	public void setNominalId(int nominalId) {
		this.nominalId = nominalId;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Long getTilang1() {
		return tilang1;
	}

	public void setTilang1(Long tilang1) {
		this.tilang1 = tilang1;
	}

	public Long getTilang2() {
		return tilang2;
	}

	public void setTilang2(Long tilang2) {
		this.tilang2 = tilang2;
	}

	public Long getTilang3() {
		return tilang3;
	}

	public void setTilang3(Long tilang3) {
		this.tilang3 = tilang3;
	}

	public Long getTilang4() {
		return tilang4;
	}

	public void setTilang4(Long tilang4) {
		this.tilang4 = tilang4;
	}

	public Long getTilang5() {
		return tilang5;
	}

	public void setTilang5(Long tilang5) {
		this.tilang5 = tilang5;
	}
	
}
