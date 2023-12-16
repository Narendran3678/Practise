package com.directory.controllers;
import com.directory.entity.Employee;
import com.directory.service.EmployeeService;
import com.directory.utils.SpringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = {"", "/" } )
    public String indexMethod(Model model) {
        model.addAttribute("Currentime", new Date());
        return "index";
    }
    @RequestMapping("/employeeform")
    public String employeeForm(Model model) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("rolesList", SpringUtils.getRoles());
        return "employeeForm";
    }
    @GetMapping("/showEmployee")
    public String showEmployee(Model model) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("employeeList", employeeService.findAll());
        return "showEmployee";
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
        else {
            return "processEmployeeForm";
        }
    }
    @GetMapping("/updateemployee/{employeeId}")
    public String updateEmployee(@PathVariable Long employeeId,Model model) {
        System.out.println("EmployeeId="+employeeId);
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("Currentime", new Date());
        model.addAttribute("rolesList", SpringUtils.getRoles());
        model.addAttribute("employee",employee);
        return "updateEmployeeForm";
    }
    @GetMapping("/deleteemployee/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId,Model model) {
        System.out.println("EmployeeId="+employeeId);
        boolean status = employeeService.delete(employeeId);
        return showEmployee(model);
    }
    @PostMapping("/processupdateform")
    public String processUpdateform(@Valid @ModelAttribute Employee employee, BindingResult bindingResult,Model model) {
        System.out.println("Employee="+employee);
        if(bindingResult.hasErrors()) {
            model.addAttribute("formerrordetail",SpringUtils.checkFormError(bindingResult));
            model.addAttribute("employee",employee);
            model.addAttribute("rolesList", SpringUtils.getRoles());
            return "updateEmployeeForm";
        }

        return showEmployee(model);
    }
}
