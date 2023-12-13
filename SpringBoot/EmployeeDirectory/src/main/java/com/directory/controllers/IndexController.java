package com.directory.controllers;
import com.directory.entity.Employee;
import com.directory.entity.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
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
        List<Roles> rolesList = new ArrayList<>();
        rolesList.add(new Roles(1L,"ADMIN"));
        rolesList.add(new Roles(2L,"MANAGER"));
        rolesList.add(new Roles(3L,"EMPLOYEE"));
        model.addAttribute("Currentime", new Date());
        model.addAttribute("employee", new Employee());
        model.addAttribute("rolesList", rolesList);
        return "employeeForm";
    }
    @PostMapping("/processform")
    public String employeeForm(@ModelAttribute Employee employee,Model model ) {
        System.out.println("Employee..."+employee);
        model.addAttribute("employee",employee);
        return "processEmployeeForm";
    }
}
