package com.example.collectionsavarietyofimplementationspublic.service;

import com.example.collectionsavarietyofimplementationspublic.exception.EmployeeAlreadyAddedException;
import com.example.collectionsavarietyofimplementationspublic.exception.EmployeeNotFoundException;
import com.example.collectionsavarietyofimplementationspublic.exception.EmployeeStorageIsFullException;
import com.example.collectionsavarietyofimplementationspublic.start.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String,Employee> employees = new HashMap();
    private static final int MAXSIZE = 5;

    public Employee add(String fistName,String lastName) {
        if (employees.size() >= MAXSIZE) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employeeAdd = new Employee(fistName, lastName);
        if (employees.containsKey(createKey(fistName,lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(fistName, lastName), employeeAdd);
        return employeeAdd;
    } // добавим сотрудника

    public Employee remove(String firstName,String lastName) {
        if (!employees.containsKey(createKey(firstName,lastName))) {
            throw new EmployeeNotFoundException();
        };
        return employees.remove(createKey(firstName,lastName));
    } // Удалим сотрудника

    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName,lastName))){
            throw new EmployeeNotFoundException();
        }
        return employees.get(createKey(firstName, lastName));
    }
    public List<Employee> getall(){
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));

    }
    private String createKey(String firstName, String lastName){
        return (firstName + lastName).toLowerCase();

    }
}