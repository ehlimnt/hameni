package com.eva.evaluationens.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eva.evaluationens.dao.CategorieRepository;
import com.eva.evaluationens.dao.DepartementRepository;
import com.eva.evaluationens.dao.Emrepository;
import com.eva.evaluationens.dao.EtudiantRepository;
import com.eva.evaluationens.dao.QuestionRepository;
import com.eva.evaluationens.dao.ReponseRepository;
import com.eva.evaluationens.dao.SemestreRepository;
import com.eva.evaluationens.dto.ReponsesCreationDto;
import com.eva.evaluationens.entities.Categorie;
import com.eva.evaluationens.entities.Departement;
import com.eva.evaluationens.entities.Em;
import com.eva.evaluationens.entities.Etudiant;
import com.eva.evaluationens.entities.Question;
import com.eva.evaluationens.entities.Reponse;
import com.eva.evaluationens.entities.Semestre;

@RequestMapping(value = "/")
@Controller
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private SemestreRepository semestreRepository;
	@Autowired
	private Emrepository emrepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ReponseRepository reponseRepository;
	@RequestMapping(value = "/ApplicationEva")
	private String Home() {
		return "home";
	}
	@RequestMapping(value = "/Etudiant/Index")
	private String Index(Model model) {
		List<Etudiant> etd = etudiantRepository.findAll();
		model.addAttribute("etudiants", etd);
		return "etudiants";
	}

	@GetMapping("/Etudiant/ajouterReponse")
	public String ajoutReponse() {
		return "AjoutReponse";
	}

	@RequestMapping(value = "/Etudiant/form", method = RequestMethod.GET)
	public String formEtudiant(Model model) {
		model.addAttribute("etudiant", new Etudiant());
		List<Departement> depts = departementRepository.findAll();
		model.addAttribute("deps", depts);
		List<Semestre> semes = semestreRepository.findAll();
		model.addAttribute("semestre", semes);
		return "FormEtudiant";
	}

	@RequestMapping(value = "/Etudiant/formulaireq/{codeem}/{id}", method = RequestMethod.GET)
	public String formulaireq(Model model, @PathVariable(name = "id") Long keyword, @PathVariable(name = "codeem") String codeem) {
		/*
		 ReponsesCreationDto ReponsesForm = new ReponsesCreationDto();

	    for (int i = 1; i <= 6; i++) {
	    	ReponsesForm.addReponse(new Reponse());
	    }

	    model.addAttribute("form", ReponsesForm);*/
	   ArrayList<Reponse> listRep =new ArrayList<Reponse>();
		List<Categorie> listCateg = categorieRepository.findAll();
		
		Iterator iterator = listCateg.iterator();
	
		model.addAttribute("categ", listCateg);		
		Reponse reps1= new Reponse();
		Em em=emrepository.emByIdEm(codeem);
		Etudiant et=etudiantRepository.FindById(keyword);
		reps1.setMatriculEt(et);
		
		reps1.setCodeEm(em);
		reps1.setDate(new Date());
		model.addAttribute("Em",em);
		model.addAttribute("reps1", reps1);
		model.addAttribute("matricule", keyword);
		return "Formquestion";

	}


	@RequestMapping(value = "/Etudiant/SaveReponse", method = RequestMethod.POST)
	public String saveREp(@ModelAttribute Reponse reps1, Model model) {
		reponseRepository.save(reps1);
		List<Reponse> reps =reponseRepository.findAll();
		model.addAttribute("reponses", reps);
		return "redirect:/Reponse/Index";
	}

	@RequestMapping(value = "/Etudiant/SaveEtudiant", method = RequestMethod.POST)
	public String savet(Etudiant et, Model model) {
		etudiantRepository.save(et);
		return "redirect:/Etudiant/Index";
	}

	@GetMapping("/Etudiant/search")
	public String search(Model model, @Param("keyword") Long keyword) {

		List<Etudiant> listeEtudiant = etudiantRepository.chercheEtudiantsbymat(keyword);
		if (listeEtudiant.size() == 0) {

			model.addAttribute("error", "Etudiant inexistant");

			return "redirect:ajouterReponse";
		}
		List<Em> listem = emrepository.ListEm(keyword);
		List<Em> listemtra = emrepository.ListEmtransversal(keyword);

		model.addAttribute("etudiant", listeEtudiant.get(0));
		model.addAttribute("listeEM", listem);
		model.addAttribute("listeEMtra", listemtra);

		model.addAttribute("matricule", keyword);

		return "listeDepEtudiant";
	}

}
