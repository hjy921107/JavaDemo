# JavaDemo

记录 Java 的学习经历

## Java 8

### 简介

- 2014年3月发布 
+ 主要新特性
    + 速度更快 
        + 修改底层数据结构
            - 如 HashMap（数组-链表-红黑树），HashSet，ConcurrentHashMap（CAS算法）
        + 修改垃圾回收机制
            - 取消堆中的永久区（PremGen）-> 回收条件苛刻
            - 使用元空间（MetaSpace）-> 直接使用物理内存 -> 加载类文件
    + 代码更少（增加了新的语法Lambda表达式）
    + 强大的Stream API
    + 便于并行
    + 增加了Optional容器类，最大化减少空指针异常
 
 
 ### Lambda 表达式
 
 Lambda 是一个匿名函数，可以把 Lambda 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。
 可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使 Java 的语言表达能力得到了提升。

