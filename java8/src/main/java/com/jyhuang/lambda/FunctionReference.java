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

import org.junit.Test;

public class FunctionReference {

    @Test
    public void test1() {

    }

}
