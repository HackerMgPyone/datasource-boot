package com.example.datasourceboot.dao;

import com.example.datasourceboot.ds.Employee;
import com.example.datasourceboot.service.EmployeeService;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
    public double avgSalaryModernWay(){
        return jdbcTemplate.queryForList("select salary from employee",
                Double.class)
                .stream()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
    }
    public double avgSalary(){
        return jdbcTemplate.queryForObject(
                "select avg(salary) from employee",Double.class
        );
    }

    public Employee highSalaryEmployee(){
        return jdbcTemplate.queryForObject("""
select * from employee order by salary desc limit 1
""",
                this::mapEmployee);
    }

    public void changeFirstName(int id,String firstName){
        jdbcTemplate.update("update employee set first_name = ? where id = ?",
                new Object[]{firstName,id});

    }

    public void deleteEmployee(int id){
        jdbcTemplate.update("delete from employee where id =?",
                new Object[]{id});
    }

    public void createEmployee(int id, String firstName, String lastName,
                               String email, String phoneNumber,
                               Date hiredDate,double salary){
        jdbcTemplate.update(
                """
insert into employee(id,first_name,last_name,email,phone_number,hired_date,salary)
values 
(?,?,?,?,?,?,?)
""",
                id,
                firstName,
                lastName,
                email,
                phoneNumber,
                hiredDate,
                salary
        );
    }

    public Employee findEmployeeById(int id){
        return jdbcTemplate.queryForObject("select * from employee where id = ?",
                this::mapEmployee,new Object[]{id});
    }



    public List<Employee> findAllEmployee(){
        return jdbcTemplate.query("select * from employee",
                this::mapEmployee);

    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet rs, int i){
        return new Employee(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getDate("hired_date"),
                rs.getDouble("salary")
        ) ;
    }
    public List<String> findAllEmails(){
        return jdbcTemplate.queryForList("select email from employee",
                String.class);
    }
}
