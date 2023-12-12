package com.example.datasourceboot.service;

import com.example.datasourceboot.dao.EmployeeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    }
}
