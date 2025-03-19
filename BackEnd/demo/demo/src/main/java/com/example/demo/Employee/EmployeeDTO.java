package com.example.demo.Employee;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO
{
    private String employeeId;

    private String name;

    private String department;

    private double employeeSal;
}
