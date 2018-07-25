package com.jyhuang.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * Lambda 基础语法：
 *
 * Java 8 中引入了一个新的操作符 "->"，该操作符称为 Lambda 操作符（箭头操作符）
 *
 * Lambda 操作符将 Lambda 表达式拆分成两个部分：
 *
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式所需执行的功能，即 Lambda 体
 *
 * 语法格式：
 *
 * 1. 无参数，无返回值
 * 2. 一个参数，无返回值（此时参数列表中的小括号可以省略）
 * 3. 两个及以上参数，有返回值（返回值需要用 return）
 * 4. Lambda 体中有多条语句，Lambda 体需要用大括号包围
 * 5. 若　Lambda 体中只有一条语句，return 和大括号都可以省略
 * 6. Lambda 表达式的参数列表的数据类型可以省略不写，因为 JVM 编译器通过上下文推断出，数据类型，即 “类型推断”
 *
 * 左右遇一括号省
 * 左侧推断类型省
 */
public class BasicSyntax {

    // 1. 无参数，无返回值
    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现的线程...");
            }
        };
        new Thread(r).start();

        System.out.println("------------------------------");

        Thread t = new Thread(() -> System.out.println("Lambda 实现的线程..."));
        t.start();
    }

    // 2. 一个参数，无返回值（此时参数列表中的小括号可以省略）
    @Test
    public void test2() {
        Consumer con = x -> System.out.println(x);
        con.accept(" 一个参数，无返回值...");
    }

    // 3. 两个及以上参数，有返回值（返回值需要用 return，同时需要 {}）
    // 4. Lambda 体中有多条语句，Lambda 体需要用大括号包围
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("Test 3,4");
            return x.compareTo(y);
        };

        List<Integer> list = Arrays.asList(1, 4, 3, 6, 8, 2);
        list.sort(comparator);

        list.forEach(System.out::println);
    }

    // 5. 若 Lambda 体中只有一条语句，return 和大括号都可以省略
    // 6. Lambda 表达式的参数列表的数据类型可以省略不写，“类型推断”
    @Test
    public void test4() {
        Comparator<Integer> comparator = (Integer x, Integer y) -> x.compareTo(y);
    }

}
