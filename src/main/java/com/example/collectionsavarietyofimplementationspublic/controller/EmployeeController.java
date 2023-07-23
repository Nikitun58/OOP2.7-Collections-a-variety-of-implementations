package com.example.collectionsavarietyofimplementationspublic.controller;

import com.example.collectionsavarietyofimplementationspublic.service.EmployeeService;
import com.example.collectionsavarietyofimplementationspublic.start.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName ){
        return employeeService.add(fistName,lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName ){
        return employeeService.remove(fistName,lastName);
    }
    @GetMapping("find")
    public Employee find(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName ){
        return employeeService.find(fistName,lastName);
    }
    @GetMapping("all")
    public List<Employee> all(){
        return employeeService.getall();

    }






}
