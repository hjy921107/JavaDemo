package com.jyhuang.demo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class application {

    List<Employee> list;

    @Before
    public void init() {
        list = Arrays.asList( //
                new Employee("张三", 18, 9999.9), //
                new Employee("李四", 20, 5555.5), //
                new Employee("王五", 19, 6666.6), //
                new Employee("赵六", 23, 3333.3));
    }

    @Test
    public void test1() {
        // 使用原来的匿名内部类
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // Lambda 表达式
        Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);

        // Lambda 方法引用
        Comparator<Integer> comparator3 = Integer::compare;
    }

    /*
     * 获取当前公司中符合下述条件的员工信息
     *  1. 员工年龄大于 20
     *  2. 薪资超过 6000
     *
     * test2/3 使用传统的方式，为每个条件创建过滤方法
     *   - FilterEmployeeByAge
     *   - filterEmployeeBySalary
     *
     * test4 策略模式(接口定义策略规范，一个实现类对应一个策略)
     *   + interface:EmployeeFilter
     *      - class:FilterEmployeeByAge
     *      - class:FilterEmployeeBySalary
     *
     * test5 匿名内部类
     *
     * test6 Lambda 表达式
     *
     * test7 Stream API
     */
    @Test
    public void test2() {
        List<Employee> result = filterEmployeeByAge(list);

        for (Employee empl : result) {
            System.out.println(empl);
        }
    }

    @Test
    public void test3() {
        List<Employee> result = filterEmployeeBySalary(list);

        for (Employee empl : result) {
            System.out.println(empl);
        }
    }

    @Test
    public void test4() {
        EmployeeFilter filter;

        //        filter = new FilterEmployeeByAge(20);
        filter = new FilterEmployeeBySalary(5000d);

        List<Employee> result = filterEmployee(list, filter);

        for (Employee emp : result) {
            System.out.println(emp);
        }
    }

    @Test
    public void test5() {
        List<Employee> result = filterEmployee(list, new EmployeeFilter() {
            @Override
            public boolean test(Employee employee) {
                if (employee != null && employee.getAge() != null) {
                    return employee.getAge() > 20;
                }
                return false;
            }
        });

        for (Employee emp : result) {
            System.out.println(emp);
        }
    }

    @Test
    public void test6() {
        List<Employee> result = filterEmployee(list, (emp) -> emp.getAge() > 20);

        result.forEach(System.out::println);
    }

    @Test
    public void test7() {
        list.stream().filter((emp) -> emp.getAge() > 20).forEach(System.out::println);

        System.out.println("------------------------------------------");

        list.stream().filter((emp) -> emp.getSalary() > 5000).map(Employee::getName).forEach(System.out::println);
    }

    private List<Employee> filterEmployeeByAge(List<Employee> employeeList) {

        List<Employee> result = null;

        if (employeeList != null && !employeeList.isEmpty()) {
            result = new ArrayList<>();

            for (Employee empl : employeeList) {
                if (empl.getAge() > 20) {
                    result.add(empl);
                }
            }
        }

        return result;
    }

    private List<Employee> filterEmployeeBySalary(List<Employee> employeeList) {

        List<Employee> result = null;

        if (employeeList != null && !employeeList.isEmpty()) {

            result = new ArrayList<>();

            for (Employee empl : employeeList) {
                if (empl.getSalary() > 5000) {
                    result.add(empl);
                }
            }
        }

        return result;
    }

    private List<Employee> filterEmployee(List<Employee> employeeList, EmployeeFilter filter) {
        List<Employee> result = new ArrayList<>();

        for (Employee emp : employeeList) {
            if (filter.test(emp)) {
                result.add(emp);
            }
        }

        return result;
    }

}
