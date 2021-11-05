package com.example.employeemanagement.service;

import com.example.employeemanagement.exception.UserNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){ // klasa do dodania pracownika
        employee.setEmployeeCode(UUID.randomUUID().toString()); // dajemy mu id randomowe oraz je zwracam nizej
        return  employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){ // klasa wyswietlajaca wszystkich pracownikow
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

   public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User with id " + id + " has not been found"));
   }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }


}
