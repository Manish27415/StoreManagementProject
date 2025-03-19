package com.example.demo.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity
{
    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @Column(name = "EMPLOYEE_DEPT")
    private String department;

    @Column(name = "EMPLOYEE_SALARY")
    private double employeeSal;

}
