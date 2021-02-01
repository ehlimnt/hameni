package com.eva.evaluationens.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eva.evaluationens.dao.QuestionRepository;
import com.eva.evaluationens.entities.Question;
@Controller
@RequestMapping(value="/Question")
public class QuestionController {
	@Autowired
private QuestionRepository questionRepository;
	@RequestMapping(value="/Index")
	private String Index(Model model) {
		List<Question> qsts =questionRepository.findAll();
		model.addAttribute("questions", qsts);
		return "questions";
	}
}
 