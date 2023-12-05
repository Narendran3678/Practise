package com.springboot.SpringBootMvc.controllers;

import com.springboot.SpringBootMvc.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String currentTime(Model model) {
        model.addAttribute("currenttime",new Date());
        return "index";
    }
    @GetMapping("/employeeform")
    public String customerForm(Model model) {
        model.addAttribute("employee",new Employee());
        return "employeeform";
    }
    @PostMapping("/processform")
    public String customerProcessForm(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        System.out.println("Customer FormData -"+employee);
        if(bindingResult.hasErrors())
            return "employeeform";
        else
            return "employeeportal";
    }
}
