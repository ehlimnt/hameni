package com.eva.evaluationens.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eva.evaluationens.entities.Question;
@CrossOrigin("*")
@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question, Long>{



	@RestResource(path ="/byquestion")
	public List<Question> findByQuestionContains(@Param("x") String q);
	
	@Query("select q from Question q where q.question like:x")
	public List<Question> findByQuestionContains(@Param("x") String q,Pageable pageable );
	@Query("select q from Question q ,Categorie c where q.categid=c  and c.id like:x")
	public List<Question> listquestionparCategorie(@Param("x") Long x );
	@Query("select q from Question q  where q.id=id")
	public List<Question> findByIdCategory(@Param("id") Long id);

}
