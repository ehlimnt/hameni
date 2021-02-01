package com.eva.evaluationens.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Em implements Serializable {
	@Id
	private String codeEm;
	private String titreEM;
	private String pole;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codedpt")
	private Departement Dep;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name="cedeSemestre" )
	private Semestre semestre;
	@OneToMany(targetEntity = Reponse.class,mappedBy = "codeEm")
	private List<Reponse> rep=new ArrayList<Reponse>();
	
	public List<Reponse> getRep() {
		return rep;
	}

	public Em() {
		super();
	}

	public Em(String codeEm, String titreEM, String pole, Departement dep, Semestre semestre) {
		super();
		this.codeEm = codeEm;
		this.titreEM = titreEM;
		this.pole = pole;
		Dep = dep;
		this.semestre = semestre;
	}

	public String getCodeEm() {
		return codeEm;
	}

	public void setCodeEm(String codeEm) {
		this.codeEm = codeEm;
	}

	public String getTitreEM() {
		return titreEM;
	}

	public void setTitreEM(String titreEM) {
		this.titreEM = titreEM;
	}

	public String getPole() {
		return pole;
	}

	public void setPole(String pole) {
		this.pole = pole;
	}

	public Departement getDep() {
		return Dep;
	}

	public void setDep(Departement dep) {
		Dep = dep;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Em [codeEm=" + codeEm + ", titreEM=" + titreEM + ", pole=" + pole + ", Dep=" + Dep + ", semestre="
				+ semestre.getCodeSemestre() + "]";
	}
	
	
}
