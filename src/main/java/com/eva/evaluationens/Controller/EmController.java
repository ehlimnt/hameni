package com.eva.evaluationens.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eva.evaluationens.dao.Emrepository;
import com.eva.evaluationens.dao.QuestionRepository;
import com.eva.evaluationens.entities.Em;
import com.eva.evaluationens.entities.Question;
@Controller
@RequestMapping(value="/Em")
public class EmController  {
	

		@Autowired
	private Emrepository emRepository;
		@RequestMapping(value="/Index")
		private String Index(Model model) {
			List<Em> ems =emRepository.findAll();
			model.addAttribute("ems", ems);
			return "ems";
		}
}
