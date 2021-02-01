package com.eva.evaluationens.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.eva.evaluationens.dao.QuestionRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categorie implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
	
	private String titrecatg;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "categid", cascade = CascadeType.ALL)
	private Collection<Question> question=  new LinkedHashSet<Question>();
	
	
	
	public Collection<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Collection<Question> question) {
		this.question = question;
	}
	
	

	
	public Categorie(Long id, String titrecatg) {
		super();
		this.id = id;
		this.titrecatg = titrecatg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitrecatg() {
		return titrecatg;
	}
	public void setTitrecatg(String titrecatg) {
		this.titrecatg = titrecatg;
	}
	public Categorie() {
		super();
	}
	@Override
	public String toString() {
		return "Categ [id=" + id + ", titrecatg=" + titrecatg + "]";
	}

}
