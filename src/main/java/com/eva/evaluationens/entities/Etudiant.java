package com.eva.evaluationens.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Etudiant  implements Serializable {
	@Id
	private Long matricule;
	private  String nom;
	private String prenom;
	private String email;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Codedpt")
	private Departement Dep;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name="codeSemestre" )
	private Semestre semestre;
	public Etudiant(Long matricule, String nom, String prenom, String email, Departement dep, Semestre semestre) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		Dep = dep;
		this.semestre = semestre;
	}
	public Etudiant() {
		super();
	}
	public Long getMatricule() {
		return matricule;
	}
	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "Etudiant [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", Dep=" + Dep + ", semestre=" + semestre.getCodeSemestre() + "]";
	}
	
	
	

}
