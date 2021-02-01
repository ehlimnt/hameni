package com.eva.evaluationens.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable {
	@Id
	private String Codedpt;
	private String titreDpt;
	@OneToMany(mappedBy = "Dep")
	List<Em> em;

	public List<Em> getEm() {
		return em;
	}

	public String getCodedpt() {
		return Codedpt;
	}

	public void setCodedpt(String codedpt) {
		Codedpt = codedpt;
	}

	public String getTitreDpt() {
		return titreDpt;
	}

	public void setTitreDpt(String titreDpt) {
		this.titreDpt = titreDpt;
	}

	public Departement(String codedpt, String titreDpt) {
		super();
		Codedpt = codedpt;
		this.titreDpt = titreDpt;
	}

	public Departement() {
		super();
	}

	@Override
	public String toString() {
		return "Dpt [Codedpt=" + Codedpt + ", titreDpt=" + titreDpt + "]";
	}

}
