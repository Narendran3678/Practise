package com.directory.controllers;

import com.directory.entity.Employee;
import com.directory.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageControllers {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/showEmployees")
    public String showEmployees(Model model) {
        model.addAttribute("pageNum","1");
        model.addAttribute("sortFieldName","firstName");
        model.addAttribute("sortDirection","Desc");
        model.addAttribute("employeeList", employeeService.findAllByOrderByFirstName());
        return "showEmployeePage";
    }
    @GetMapping("/showEmployeePage/{pageNum}")
    public String showEmployeePage(@PathVariable("pageNum")int pageNum, @RequestParam String sortField, @RequestParam String sortDir, Model model) {
        System.out.println("Sort Field...."+sortField);
        System.out.println("Sort Direction...."+sortDir);
        System.out.println("Sort Direction...."+pageNum);
        Page<Employee> page = employeeService.findAllByPage(pageNum,sortField,sortDir);
        List<Employee> employeeList =  page.getContent();
        System.out.println("Total Page...."+page.getTotalPages());
        System.out.println("Total Elements...."+page.getTotalElements());
        model.addAttribute("sortFieldName",sortField);
        model.addAttribute("sortDirection",sortDir.equalsIgnoreCase("ASC") ? "Desc":"Asc");
        model.addAttribute("CurrentpageNum",pageNum);
        model.addAttribute("totalpage",page.getTotalPages());
        model.addAttribute("pagetotalelements",page.getTotalElements());
        model.addAttribute("employeeList", employeeList);
        return "showEmployeePage";
    }
}
