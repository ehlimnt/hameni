package com.eva.evaluationens.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Semestre implements Serializable {
	@Id
private String codeSemestre;


	public Semestre() {
		super();
	}


	public Semestre(String codeSemestre) {
		super();
		this.codeSemestre = codeSemestre;
	}


	public String getCodeSemestre() {
		return codeSemestre;
	}


	public void setCodeSemestre(String codeSemestre) {
		this.codeSemestre = codeSemestre;
	}


	@Override
	public String toString() {
		return "Semestre [codeSemestre=" + codeSemestre + "]";
	}



}
