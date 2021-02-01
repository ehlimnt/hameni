package com.eva.evaluationens.dto;

import java.util.List;

import com.eva.evaluationens.entities.Reponse;

public class ReponsesCreationDto {
private List<Reponse> reponses;

public List<Reponse> getReponses() {
	return reponses;
}

public void setReponses(List<Reponse> reponses) {
	this.reponses = reponses;
}

public ReponsesCreationDto(List<Reponse> reponses) {
	super();
	this.reponses = reponses;
}

public ReponsesCreationDto() {
	super();
}
public void addReponse(Reponse rep) {
	this.reponses.add(rep);
}
}
