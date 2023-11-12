package com.test;

import com.app.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

        public static void main(String[] args) {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

            System.out.println("haha");
            EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

//            Employee employee = new Employee("zdk dz", 123);
//            employee.setId(4L);
//            Employee savedEmployee = new Employee();
//            try {
//                savedEmployee = employeeService.saveEmployee(employee);
//                if (savedEmployee != null) {
//                    System.out.println("Employee saved successfully: " + savedEmployee);
//                } else {
//                    System.out.println("No there is an error");
//                }
//            } catch (Exception e) {
//                System.out.println("Error: Unable to save employee. " + e.getMessage());
//            }

            Employee existEmployee = employeeService.findEmployeeById(1L);

            if(existEmployee != null) {
                existEmployee.setName("mohamed");
                existEmployee.setSalary(1337);
                System.out.println("Employee exist");

                Employee UpdateEmployee = employeeService.updateEmployee(existEmployee);

                if(UpdateEmployee != null)
                    System.out.println("Employee updated successfully: " + UpdateEmployee);
                else
                    System.out.println("Failed to update the employee.");
            }
            else
                System.out.println("Employee not exist");
        }
}