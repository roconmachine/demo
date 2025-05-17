package com.selise.demo.controller;

import com.selise.demo.converter.EmployeeConverter;
import com.selise.demo.enterfacee.EmployeesApi;
import com.selise.demo.model.Employee;
import com.selise.demo.model.StatusUpdate;
import com.selise.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController implements EmployeesApi{

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {

        Employee created = EmployeeConverter.toModel(
                employeeService.save(EmployeeConverter.toEntity(employee))
        );
        return ResponseEntity.status(201).body(created);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long id) {
        return employeeService.findById(id)
                .map(EmployeeConverter::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.findAll()
                .stream()
                .map(EmployeeConverter::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }
    @Override
    public ResponseEntity<Employee> setEmployeeStatus(Long id, StatusUpdate statusUpdate) {
        return employeeService.updateStatus(id, statusUpdate.getStatus())
                .map(EmployeeConverter::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long id, Employee employee) {
        return null;
    }

}
