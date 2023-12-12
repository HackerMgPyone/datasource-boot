package com.example.datasourceboot.service;

import com.example.datasourceboot.dao.EmployeeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;
    public void doAction(){
        System.out.println("FindAllEmails:");
        employeeDao.findAllEmails().forEach(System.out::println);
        System.out.println();
        System.out.println("ListAllEmployee:");
        employeeDao.findAllEmails().forEach(System.out::println);
        System.out.println();
        System.out.println("Find Employee ById:");
        System.out.println(employeeDao.findEmployeeById(1));
        System.out.println();
//        System.out.println("create new employee:");
//        employeeDao.createEmployee(4,"Charles","Kyaw","charles@gmail.com",
//                "333-444-555", Date.valueOf("2023-04-14"),2800);
        System.out.println();
        System.out.println("List All Employee:");
        employeeDao.findAllEmployee().forEach(System.out::println);
//        System.out.println("Delete Employee:");
//        employeeDao.deleteEmployee(1);
//        employeeDao.changeFirstName(2,"James");
        System.out.println();
        System.out.println("List All Employee:");
        employeeDao.findAllEmployee().forEach(System.out::println);
        System.out.println();
        System.out.println("High salary Employee:");
        System.out.println(employeeDao.highSalaryEmployee());
        System.out.println("AvgNativeWay");
        System.out.println("AVG:"+employeeDao.avgSalary());
        System.out.println("AvgModernWay:");
        System.out.println("AVGModern "+ employeeDao.avgSalaryModernWay());



    }
}
