package com.jyhuang.stream;

import org.junit.Test;

public class StreamCreate {

    /*
     * 1. 通过 Collection 系列集合提供的 stream() 或 parallelStream() 方法
     *      - default Stream<E> stream() : 返回一个顺序流
     *      - default Stream<E> parallelStream() : 返回一个并行流
     * 2. 通过 Arrays 中的静态方法 stream() 获取数组流
     *      - static <T> Stream<T> stream(T[] array): 返回一个流
     *      + 重载形式：
     *          - public static IntStream stream(int[] array)
     *          - public static LongStream stream(long[] array)
     *          - public static DoubleStream stream(double[] array)
     * 3. 通过 Stream 类中的静态方法 of()，通过显示值创建一个流。它可以接收任意数量的参数
     *      - public static<T> Stream<T> of(T… values) : 返回一个流
     * 4. 创建无限流：使用静态方法 Stream.iterate() 和 Stream.generate()
     *      - 迭代：public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
     *      - 生成：public static<T> Stream<T> generate(Supplier<T> s)
     */

    @Test
    public void test1() {

    }
}
