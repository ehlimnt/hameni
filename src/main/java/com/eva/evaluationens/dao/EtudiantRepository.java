package com.eva.evaluationens.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eva.evaluationens.entities.Departement;
import com.eva.evaluationens.entities.Em;
import com.eva.evaluationens.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant ,Long>{
	@Query("select e from Etudiant e where e.email like :x")
	public List<Etudiant> chercheEtudiants(@Param("x") String eml );
	@Query("select e from Etudiant e where e.matricule like :x")
	public List<Etudiant> chercheEtudiantsbymat(@Param("x") Long mat );
	@Query("select e from Etudiant e where e.matricule like :x")
	public Etudiant FindById(@Param("x") Long mat );
}
