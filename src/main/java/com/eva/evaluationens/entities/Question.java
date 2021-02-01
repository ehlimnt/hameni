package com.eva.evaluationens.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question implements Serializable{
	@Id
	private Long qId;
	private String question;
	
	@ManyToOne(targetEntity = Categorie.class)
	@JoinColumn(name = "id")
	
	private Categorie categid;
	
	public Question() {
		super();
	}

	public Question(Long qId, String question, Categorie categid) {
		super();
		this.qId = qId;
		this.question = question;
		this.categid = categid;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Categorie getCategid() {
		return categid;
	}

	public void setCategid(Categorie categid) {
		this.categid = categid;
	}

	@Override
	public String toString() {
		return "Question [qId=" + qId + ", question=" + question + ", categid=" + categid.getTitrecatg() + "]";
	}
	
	
	
	
	
	
}
