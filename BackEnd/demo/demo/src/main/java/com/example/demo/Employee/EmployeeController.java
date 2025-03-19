package com.example.demo.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeController
{

    private final EmployeeServices employeeServices;


    @GetMapping("/getAllDetails")
    public List<EmployeeDTO> getAllDetails()
    {
        return employeeServices.getALlDetails();
    }

    @PostMapping("/addNewEmployee")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee)
    {
        return employeeServices.newEmployee(employee);
    }

    @GetMapping("/getEmployeeById/{id}")
    public Optional<EmployeeDTO> getEmployeeById(@PathVariable String id)
    {
        return employeeServices.getEmployeeById(id);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public Optional<EmployeeEntity> getEmployeeByName(@PathVariable String name)
    {
        return employeeServices.getEmployeeByName(name);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public void deleteEmployee(@PathVariable String id)
    {
         employeeServices.deleteEmployeeById(id);
    }

    @PutMapping("/editEmployee")
    public Optional<EmployeeEntity> editEmployee(@RequestBody EmployeeEntity employee)
    {
        return employeeServices.editEmployeeDetails(employee);
    }

}
