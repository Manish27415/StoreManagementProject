package com.example.demo.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServices
{
    private final EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getALlDetails()
    {
         List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        return employeeEntityList.stream()
                                   .map(x-> EmployeeDTO.builder()
                                   .employeeId(x.getEmployeeId())
                                   .department(x.getDepartment())
                                   .employeeSal(x.getEmployeeSal())
                                   .name(x.getName()).build()).toList();
    }

    public EmployeeEntity newEmployee(@RequestBody EmployeeEntity employee)
    {
        return employeeRepository.save(employee);
    }

    public Optional<EmployeeDTO> getEmployeeById(String id)
    {

        return employeeRepository.findById(id)
                .map(employee -> EmployeeDTO.builder()
                        .employeeId(employee.getEmployeeId())
                        .department(employee.getDepartment())
                        .employeeSal(employee.getEmployeeSal())
                        .name(employee.getName())
                        .build());
    }

    public Optional<EmployeeEntity> getEmployeeByName(String name)
    {
        return employeeRepository.findByName(name);
    }

    public Optional<EmployeeEntity> editEmployeeDetails(EmployeeEntity employee)
    {
        return employeeRepository.findById(employee.getEmployeeId())
                .map(existingEmployee -> {
                    existingEmployee.setName(employee.getName());
                    existingEmployee.setDepartment(employee.getDepartment());
                    existingEmployee.setEmployeeSal(employee.getEmployeeSal());
                    return employeeRepository.save(existingEmployee);
                });
    }

    public void deleteEmployeeById(String id)
    {
        employeeRepository.deleteById(id);
    }
}
