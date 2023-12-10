package com.springboot.SpringBootMvc.controllers;

import com.springboot.SpringBootMvc.utils.SpringUtil;
import com.springboot.SpringBootMvc.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class IndexController {
    @Autowired
    SpringUtil springUtil;

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
    public String customerProcessForm(@Valid @ModelAttribute Employee employee,BindingResult bindingResult, Model model) {
        System.out.println("Customer FormData -"+employee+", HasError ["+bindingResult.hasErrors()+"]");
        if(bindingResult.hasErrors()) {
            model.addAttribute("formerrordetail",springUtil.checkFormError(bindingResult));
            return "employeeform";
        }
        else
            return "employeeportal";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,editor);
    }
}
