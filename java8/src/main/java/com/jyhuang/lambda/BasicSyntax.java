package com.jyhuang.lambda;

import org.junit.Test;

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
 *
 */
public class BasicSyntax {

    // 1. 无参数，无返回值
    @Test
    public void test1() {
        Thread t = new Thread(() -> System.out.println("Lambda 实现的线程..."));
        t.start();
    }
}
