package com.eva.evaluationens.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eva.evaluationens.dao.CategorieRepository;
import com.eva.evaluationens.entities.Categorie;
import com.eva.evaluationens.entities.Question;
@RequestMapping(value="/Catego")
@RestController
public class CategorieController {
	@Autowired
	private CategorieRepository categRepository;
	@RequestMapping(value="/Index")
	private String Index(Model model) {
		List<Categorie> qsts =categRepository.findAll();
		model.addAttribute("categ", qsts);
		return "categories";
	}
}
