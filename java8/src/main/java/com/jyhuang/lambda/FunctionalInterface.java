package com.jyhuang.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Lambda 表达式需要“函数式接口”的支持
 * 为了方便，Java 8 内置了常用的四大函数式接口
 *
 * 消费型：Consumer<T>
 *          void accept(T t);
 * 供给型：Supplier<T>
 *          T get();
 * 函数型：Function<T, R>
 *          R apply(T t);
 * 断言型：Predicate<T>
 *          boolean test(T t);
 */
public class FunctionalInterface {

    @Test
    public void test1() {
        consumer(1000d, (x) -> System.out.println("消费：" + x + " 元"));
    }

    private void consumer(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        // 生成 10 个 100 以内不重复的正整数
        Set<Integer> result = supplier(10, () -> new Random().nextInt(100) + 1);
        result.forEach(System.out::println);
    }

    private Set<Integer> supplier(int num, Supplier<Integer> supplier) {
        Set<Integer> set = new HashSet<>();

        while (set.size() <= num) {
            set.add(supplier.get());
        }

        return set;
    }

    @Test
    public void test3() {
        // 将传入的字符串转换成大写
        String result = function("java", (x) -> x.toUpperCase());
        System.out.println(result);
    }

    private String function(String srcStr, Function<String, String> function) {
        return function.apply(srcStr);
    }

    @Test
    public void test4() {
        // 过滤输出长度大于 5 的字符串
        List<String> result = test(Arrays.asList("abc", "java", "hello world"), (x) -> x.length() > 5);

        result.forEach(System.out::println);
    }

    private List<String> test(List<String> list, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();

        for (String str : list) {
            if (predicate.test(str)) {
                result.add(str);
            }
        }

        return result;
    }

    /*
     * Java 8 除了提供上述常见的函数式接口，还提供相关的增强接口
     *
     * 函数式接口                参数类型        返回类型        备注
     *
     * BiFunction(T, U, R)      T, U            R           比 Function 能多处理一个参数
     *                                                          R apply(T t, U u);
     * UnaryOperator<T>         T               T           对 t1 进行一元运算，并返回 T 类型的值
     *     (Function 的子接口)                                   T apply(T t)
     *
     * BinaryOperator<T>                                    对 t1 和 t2 进行二元运算，并返回 T 类型的值
     *     (BiFunction 的子接口) T, T            T               T apply(T t1, T t2);
     *
     * BiConsumer<T, U>         T, U            void        对 t 和 u 进行消费操作
     *                                                          void accept(T t, U u)
     *
     * ToIntFunction<T>         T               int         分别计算得到 int, long, double 值的函数
     * ToLongFunction<T>                        long
     * ToDoubleFunction<T>                      double
     *
     * IntFunction<R>           int             R           处理 int, long, double 型入参，返回 R 类型的函数
     * LongFunction<R>          long
     * DoubleFunction<R>        double
     */
}
