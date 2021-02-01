package com.eva.evaluationens.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eva.evaluationens.entities.Em;

public interface Emrepository extends JpaRepository<Em, String>{
	@Query("select em from  Em em  ,  Etudiant et  where et.Dep=em.Dep and et.semestre=em.semestre and et.matricule like :x")
	public List<Em> ListEm(@Param("x") Long mat);
	
	@Query("select em from  Em em  ,  Etudiant et  where em.Dep=null and et.semestre=em.semestre  and et.matricule like :x")
	public List<Em> ListEmtransversal(@Param("x") Long mat);
	@Query("select em from  Em em    where em.codeEm like :x")

	public Em emByIdEm(@Param("x") String codeEm);
}
