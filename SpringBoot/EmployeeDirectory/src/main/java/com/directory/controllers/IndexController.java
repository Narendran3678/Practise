package com.directory.controllers;
import com.directory.entity.Employee;
import com.directory.entity.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexMethod(Model model) {
        model.addAttribute("Currentime", new Date());
        return "index";
    }
    @RequestMapping("/employeeform")
    public String employeeForm(Model model) {
        model.addAttribute("Currentime", new Date());
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }
    @PostMapping("/processform")
    public String employeeForm(@ModelAttribute Employee employee ) {
        System.out.println("Employee..."+employee);
       // System.out.println("Role..."+roles);
        return "employeeform";
    }
}
