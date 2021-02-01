package com.eva.evaluationens.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eva.evaluationens.dao.DepartementRepository;
import com.eva.evaluationens.dao.Emrepository;
import com.eva.evaluationens.entities.Departement;
import com.eva.evaluationens.entities.Em;
@Controller
@RequestMapping(value="/Dpts")

	
public class DptController {
	

			@Autowired
		private DepartementRepository dptRepository;
			@RequestMapping(value="/Index")
			private String Index(Model model) {
				List<Departement> dpts =dptRepository.findAll();
				model.addAttribute("dpts", dpts);
				return "dpts";
			}
}
