package SpringRestTemplate.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import SpringRestTemplate.restTemplates.RestTemplateClient;

@Controller
public class IndexController {
	
	@Autowired
	RestTemplateClient restServices;
	
	@RequestMapping(value={"","/"})
	public String indexMethod(Model model) {
		model.addAttribute("Currentime",new Date());
		return "index.html";
	}
	//http://localhost:8082/rest/showEmployee
	@GetMapping("/showEmployee")
	public String getEmployeeRest(Model model) {
		model.addAttribute("Currentime",new Date());
		model.addAttribute("employeeList",restServices.showEmployeeEntity());
		return "employeelist.html";
	}

	//http://localhost:8082/rest/createStudent
	@GetMapping("/createStudent")
	public String createStudent(Model model) {
		model.addAttribute("Currentime",new Date());
		model.addAttribute("employeeList",restServices.addStudent());
		return "employeelist.html";
	}


}
