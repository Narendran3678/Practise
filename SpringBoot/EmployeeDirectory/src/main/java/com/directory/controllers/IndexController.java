package com.directory.controllers;
import com.directory.entity.Employee;
import com.directory.entity.Roles;
import com.directory.service.EmployeeService;
import com.directory.utils.SpringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Controller
public class IndexController {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/")
    public String indexMethod(Model model) {
        model.addAttribute("Currentime", new Date());
        return "index";
    }
    @RequestMapping("/employeeform")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("rolesList", SpringUtils.getRoles());
        return "employeeForm";
    }
    @PostMapping("/processform")
    public String employeeForm(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model ) {
        System.out.println("Employee..."+employee+" Error Status.."+bindingResult.hasErrors());
        if(bindingResult.hasErrors()) {
            model.addAttribute("formerrordetail",SpringUtils.checkFormError(bindingResult));
            model.addAttribute("employee",employee);
            model.addAttribute("rolesList", SpringUtils.getRoles());
            return "employeeForm";
        }
        else
            return "processEmployeeForm";
    }
}
