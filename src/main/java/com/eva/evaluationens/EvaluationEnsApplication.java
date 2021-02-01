package com.eva.evaluationens;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.format.annotation.DateTimeFormat;

import com.eva.evaluationens.dao.CategorieRepository;
import com.eva.evaluationens.dao.DepartementRepository;
import com.eva.evaluationens.dao.Emrepository;
import com.eva.evaluationens.dao.EtudiantRepository;
import com.eva.evaluationens.dao.QuestionRepository;
import com.eva.evaluationens.dao.ReponseRepository;
import com.eva.evaluationens.dao.SemestreRepository;
import com.eva.evaluationens.entities.Categorie;
import com.eva.evaluationens.entities.Departement;
import com.eva.evaluationens.entities.Em;
import com.eva.evaluationens.entities.Etudiant;
import com.eva.evaluationens.entities.Question;
import com.eva.evaluationens.entities.Reponse;
import com.eva.evaluationens.entities.Semestre;

@SpringBootApplication
public class EvaluationEnsApplication implements CommandLineRunner {
	
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private CategorieRepository categRepository;
	@Autowired
	private Emrepository emrepository;
	@Autowired
	private DepartementRepository dptRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ReponseRepository reponseRepository;
	@Autowired
	private SemestreRepository semestreRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(EvaluationEnsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*

		Categorie c1 = new Categorie((long) 1, "L'organisation du cours");
		Categorie c2 = new Categorie((long) 2, "Le contenu du cours");
		Categorie c3 = new Categorie((long) 3, "Les supports de cours");
		categRepository.save(c1);
		categRepository.save(c2);
		categRepository.save(c3);
		Question q1=new Question((long) 1, "Les objectifs du cours ont été expliqués?", c1);
		questionRepository.save(new Question((long) 1, "Les objectifs du cours ont été expliqués?", c1));
		questionRepository.save(new Question((long) 2, "Le déroulement du cours a été clairement présenté?", c1));
		questionRepository.save(new Question((long) 3, "Le cours était équilibré entre le nombre d'heures CM TD et TP?", c3));
		questionRepository.save(new Question((long) 4, "Le déroulement du cours a été clairement présenté?", c3));
		questionRepository.save(new Question((long) 5, "Le", c2));
		questionRepository.save(new Question((long) 6, "Le .......", categRepository.FindcaById((long)1)));

		questionRepository.findAll().forEach(q -> {
			System.out.println(q.toString());
		});
		System.out.println("###################");
		Categorie c= categRepository.FindcaById((long)1);
		Collection<Question> li = c.getQuestion();
		System.out.println(li);
		
		/*
		/*
		 * for (Question question : li) { System.out.println(question); }
		 */
		System.out.println("###################");
		
	
		/*
		
		categRepository.findAll().forEach(ca -> {
			System.out.println(ca.toString());
		});

		System.out.println("**************************************");
		System.out.println(c1.getQuestion());
		semestreRepository.save(new Semestre("S1"));
		semestreRepository.save(new Semestre("S2"));
		semestreRepository.save(new Semestre("S3"));
		semestreRepository.save(new Semestre("S4"));
		semestreRepository.save(new Semestre("S5"));
		semestreRepository.findAll().forEach(s -> {
			System.out.println(s.toString());
		});


		
		Departement d1 = new Departement("IRT", "Informatique Resaux Telecom");
		Departement d2 = new Departement("MPG", "Mine Petrole Gaz");
		Departement d3 = new Departement("GM", "Genie Mecanique");
		Departement d4 = new Departement("GE", "Genie Electrique");
		Departement d5 = new Departement("GC", "Genie Civile");

		dptRepository.save(d1);
		dptRepository.save(d2);
		dptRepository.save(d3);
		dptRepository.save(d4);
		dptRepository.save(d5);

		dptRepository.findAll().forEach(d -> {
			System.out.println(d.toString());
		});
		Semestre s3=new Semestre("S6");
		Em em1=new Em("IRT331", "JAVA/JEE", null, d1, s3);
		emrepository.save(new Em("IRT331", "JAVA/JEE", null, d1, new Semestre("S3")));
		emrepository.save(new Em("MPG331", "geologie", null, d2, new Semestre("S3")));
		emrepository.save(new Em("IRT332", "Intelligence artificielle", null, d1, new Semestre("S3")));
		emrepository.save(new Em("ST321", "Sociologie", null, null, new Semestre("S3")));
				emrepository.save(new Em("TC222", "Informatique", null, null, new Semestre("S1")));

System.out.println(em1.getRep());
		emrepository.findAll().forEach(em -> {
			System.out.println(em.toString());

		});

		Etudiant et1 = new Etudiant((long) 19066, "mbarek", "aicha", "19066@esp.mr", d2, new Semestre("S3"));
		Etudiant et2 = new Etudiant((long) 2001, "aly", "hana", "2002@esp.mr", null, new Semestre("S1"));
		etudiantRepository.save(et2);

		etudiantRepository
				.save(new Etudiant((long) 19085, "Elyaghouby", "aminetou", "19085@esp.mr", d1, new Semestre("S3")));
		etudiantRepository.save(new Etudiant((long) 19066, "mbarek", "aicha", "19066@esp.mr", d1, new Semestre("S3")));
		etudiantRepository
				.save(new Etudiant((long) 19008, "cheykhneda", "fatimetou", "19008@esp.mr", d1, new Semestre("S3")));
		etudiantRepository.findAll().forEach(e -> {
			System.out.println(e.toString());
		});
	//	System.out.println(d1.getEm());
		emrepository.save(new Em("TC323", "anglai ", null, null, new Semestre("S3")));
		System.out.println(emrepository.ListEm((long) 19085));

		//System.out.println(emrepository.ListEmtransversal((long) 19066));
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		
		
		reponseRepository.save(new Reponse((long)1, q1, et1, em1, "oui",  df.parse("11/01/2089 02:44:45")));
	reponseRepository.findAll().forEach(r -> {
				 System.out.println(r.toString()); });
	*/
	}
	

}
