package com.selise.demo.service;

import com.selise.demo.entity.EmployeeEntity;
import com.selise.demo.repos.EmployeeRepository;
import io.micrometer.observation.ObservationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService extends BaseService<EmployeeEntity, EmployeeRepository>
{

    @Autowired
    private EmployeeRepository employeeRepository;
    public Optional<EmployeeEntity> updateStatus(Long id, String status) {
        Optional<EmployeeEntity> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            EmployeeEntity employee = employeeOpt.get();
            employee.setStatus(status);
            employeeRepository.save(employee);
            return Optional.of(employee);
        } else {
            return Optional.empty();
        }
    }
}
