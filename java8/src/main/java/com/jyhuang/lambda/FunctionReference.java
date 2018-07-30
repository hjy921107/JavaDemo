package com.jyhuang.lambda;

/*
 * 一：方法引用：若 Lambda 体实现的功能已经有方法实现或者就是简单的调用一个方法
 *         我们可以使用 “方法引用”，它是 Lambda 表达式的另外一种表现形式
 *
 *  主要有三种语法格式：
 *
 * 1. 对象::实例方法名
 * 2. 类::静态方法名
 * 3. 类::实例方法名
 *
 * 注意：
 *
 * 1. Lambda 体中调用方法的参数列表和返回值类型，要与函数式接口中抽象方法的参数列表和返回类型保持一致
 * 2. 若 Lambda 参数列表中第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 类名::方法名
 *
 * 二：构造器引用
 *
 * ClassName::new
 *
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
 *
 * 三：数组引用
 *
 * Type::new
 */

import com.jyhuang.demo.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

public class FunctionReference {

    // 对象::实例方法名
    @Test
    public void test1() {

        PrintStream ps1 = System.out;
        Consumer<String> consumer1 = (x) -> ps1.println(x);

        PrintStream ps2 = System.out;
        Consumer<String> consumer2 = ps2::println;

        Consumer<String> consumer3 = System.out::println;

        consumer1.accept("hello world");
    }

    @Test
    public void test2() {
        Employee empl = new Employee("张三", 18, 5000d);
        Supplier<String> supplier1 = () -> empl.getName();
        System.out.println(supplier1.get());

        Supplier<Double> supplier2 = empl::getSalary;
        System.out.println(supplier2.get());
    }

    // 类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        comparator = Integer::compare;
    }

    // 类::实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        biPredicate = String::equals;
    }

    // 构造器引用
    @Test
    public void test5() {
        Supplier<Employee> supplier = () -> new Employee();
        supplier = Employee::new;
        Employee employee1 = supplier.get();
        System.out.println(employee1);

        Function<Integer, Employee> function = (x) -> new Employee(x);
        Employee employee2 = function.apply(20);
        System.out.println(employee2);

        BiFunction<String, Integer, Employee> biFunction = Employee::new;
        Employee employee3 = biFunction.apply("Joye", 27);
        System.out.println(employee3);
    }

    // 数组引用
    @Test
    public void test6() {
        Function<Integer, String[]> function = (x) -> new String[x];
        String[] strArr = function.apply(10);
        System.out.println(strArr.length);

        function = String[]::new;
        String[] strArr2 = function.apply(5);
        System.out.println(strArr2.length);
    }

}
