package com.jyhuang.demo;

public class FilterEmployeeBySalary implements EmployeeFilter {

    private Double salary;

    public FilterEmployeeBySalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean test(Employee employee) {
        if (employee != null && employee.getSalary() != null) {
            return employee.getSalary() > salary;
        }

        return false;
    }
}
