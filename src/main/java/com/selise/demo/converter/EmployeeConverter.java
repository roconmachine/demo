package com.selise.demo.converter;

import com.selise.demo.entity.EmployeeEntity;
import com.selise.demo.model.Employee;

public class EmployeeConverter {

    public static EmployeeEntity toEntity(Employee employee){
        if (employee == null) {
            return null;
        }

        EmployeeEntity entity = new EmployeeEntity();
        entity.setFirstName(employee.getFirstName());
        entity.setLastName(employee.getLastName());
        entity.setEmail(employee.getEmail());
        entity.setPhone(employee.getPhone());
        entity.setDateOfJoining(employee.getDateOfJoining());
        entity.setPosition(employee.getPosition());
        entity.setLocation(employee.getLocation());
        entity.setStatus(employee.getStatus());

        return entity;
    }

    public static  Employee toModel(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmail(employeeEntity.getEmail());
        employee.setPhone(employeeEntity.getPhone());
        employee.setDateOfJoining(employeeEntity.getDateOfJoining());
        employee.setPosition(employeeEntity.getPosition());
        employee.setLocation(employeeEntity.getLocation());
        employee.setStatus(employeeEntity.getStatus());

        return employee;
    }
}
