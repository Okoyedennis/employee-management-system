package com.example.emsbackend.controller;

import com.example.emsbackend.model.Employee;
import com.example.emsbackend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
        @Autowired
        private EmployeeRepository employeeRepository;

        @GetMapping("/employees")
        public List<Employee> getAllEmployee() {
             return employeeRepository.findAll();
        }

        @PostMapping("/employee")
        public Employee saveEmployeeDetails(@RequestBody Employee employee){
              return employeeRepository.save(employee);
        }

        @GetMapping("/employee/{id}")
        public Employee getSingleEmployee(@PathVariable Long id){
           return employeeRepository.findById(id).get();
        }

        @PutMapping("/employee")
        public Employee updateEmployeeDetails(@RequestBody Employee employee){
            return  employeeRepository.save(employee);
        }

        @DeleteMapping("/employee/{id}")
        public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id){
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
