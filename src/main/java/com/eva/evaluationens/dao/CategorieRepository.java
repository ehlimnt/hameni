package com.eva.evaluationens.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eva.evaluationens.entities.Categorie;
@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	@Query("select e from Categorie e where e.id like :x")
	public Categorie FindcaById(@Param("x") Long id );
}
