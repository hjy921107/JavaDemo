package com.jyhuang.lambda;

/*
 * 方法引用：若 Lambda 体实现的功能已经有方法实现或者就是简单的调用一个方法
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
 */

import com.jyhuang.demo.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionReference {

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

}
