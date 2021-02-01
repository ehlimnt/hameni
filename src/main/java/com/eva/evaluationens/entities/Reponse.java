package com.eva.evaluationens.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Reponse implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "qId")
	
	private Question idQuestion;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matricule")
	private Etudiant matriculEt;
	@ManyToOne(targetEntity = Em.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "codeEm")
	private Em codeEm;
	private String rep;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date date;
	
	
	public Reponse() {
		super();
	}


	

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", idQuestion=" + idQuestion + ", matriculEt=" + matriculEt + ", codeEm=" + codeEm
				+ ", rep=" + rep + ", date=" + date + "]";
	}




	public Reponse(Long id, Question idQuestion, Etudiant matriculEt, Em codeEm, String rep, Date date) {
		super();
		this.id = id;
		this.idQuestion = idQuestion;
		this.matriculEt = matriculEt;
		this.codeEm = codeEm;
		this.rep = rep;
		this.date = date;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Question getIdQuestion() {
		return idQuestion;
	}


	public void setIdQuestion(Question idQuestion) {
		this.idQuestion = idQuestion;
	}


	public Etudiant getMatriculEt() {
		return matriculEt;
	}


	public void setMatriculEt(Etudiant matriculEt) {
		this.matriculEt = matriculEt;
	}


	public Em getCodeEm() {
		return codeEm;
	}


	public void setCodeEm(Em codeEm) {
		this.codeEm = codeEm;
	}


	public String getRep() {
		return rep;
	}


	public void setRep(String rep) {
		this.rep = rep;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


}