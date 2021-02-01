package com.eva.evaluationens.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eva.evaluationens.dao.QuestionRepository;
import com.eva.evaluationens.dao.ReponseRepository;
import com.eva.evaluationens.entities.Question;
import com.eva.evaluationens.entities.Reponse;
@Controller
@RequestMapping(value="/Reponse")

public class ReponseController {
	
		@Autowired
	private ReponseRepository reponseRepository;
		@RequestMapping(value="/Index")
		private String Index(Model model) {
			List<Reponse> reps =reponseRepository.findAll();
			model.addAttribute("reponses", reps);
			return "reponses";
		}
	}
