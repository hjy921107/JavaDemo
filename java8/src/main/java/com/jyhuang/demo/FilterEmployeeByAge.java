package com.jyhuang.demo;

public class FilterEmployeeByAge implements EmployeeFilter {

    private int age;

    public FilterEmployeeByAge(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Employee employee) {
        if (employee != null && employee.getAge() != null) {
            return employee.getAge() > age;
        }

        return false;
    }
}
