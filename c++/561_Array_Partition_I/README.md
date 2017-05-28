# 问题分析

首先本问题描述的比较晦涩。
它的意思是提供2n个未排序的数（这些数的取值范围是-10000,10000之间）。
寻找一种将这些数两两组对成n个pair的方法，使得当从每个pair中选取较小的数，它们加和的结果最大。

这个问题的分析之后其实目标非常清楚。
为了使组对方式满足上述条件，其实就是让小的数尽量和它最邻近的数组对（以减少浪费）
将问题很容易的转化成了排序数据跳取的问题


# 解决方法

## 方法一
将整个数组使用STL的算法库进行排序，然后从中隔一个取出来加和的结果
这个方法的时间复杂度是O(NlogN)，因为使用原位排序，所以空间复杂度是O(1)


## Best
因为问题给定了数字的取值范围，所以可以使用一种讨巧的方法进行排序 - HashTable (20000个slot就可以)
使用HashTable记录每个数字出现的次数，然后从里面隔一个取出来加和
这个方法因为只需要线性将数据扫一遍时间复杂度是O(N)，而因为使用了固定大小的HashTable，所以空间复杂度是O(1)


# C++知识

`size_t`
在C++的文档中，`size_t`的定义是the unsigned integer type of the result of the `sizeof` operator。
也就是说`sizeof`的返回值并不是`int`类型，而是`size_t`类型，因此使用`size_t`有利于表明代码实际上
需要代表的是字节的大小或者数组索引。

文档中进而说，std::size_t is commonly used for array indexing and loop counting.
以后考虑所有的loop中都使用size_t作为i的类型吧。

参考文章：[为什么size_t重要？](http://jeremybai.github.io/blog/2014/09/10/size-t)


