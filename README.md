# algorithm-leetcode

以下3道数组的题目，通用的解题思路是**检查每一个元素是否需要，若需要就挪到最前面可用的位置上**
所以需要两个指针：

－ 指向现在最前面的可用位置的指针
－ 指向现在正在检查是否为需要元素的指针

最后一次提交已经将3道题统一为这个思路。
首先根据题目要求，判断数组长度是否达到最小需要检验的长度；然后检查每一个需要检查的元素，如果需要就放到pivot的位置上
26题：需要的元素是没有出现过的元素，也就是pivot前面一个位置不一样的元素
27题：需要的元素是与val不一样的元素
80题：需要的元素是没有出现过2次的元素，也就是若和pivot前面一个元素一样，就要看看再前面一个元素是不是还是一样的。

###26. [Remove Dup in Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)（376 ms）
```数组``` ```两个指针```

删除一个已经排序好的数组中的重复元素。返回新数组的长度。

**要求**

1. 不可以创建新的数组，而是要在原位操作
2. 对于新的数组，只要求截止至新的长度是没有重复元素的状态即可，超出的部分可以不管

**分析**

1. 由于数组已经排序好，所以所有的重复元素是相邻的，因此只需要跑一遍就可以了。
2. 由于不需要照顾新长度以外的内容，所以只需要移动元素，而不需要删除元素就可以了。

**错误**

1. 一开始对题目的理解有问题，以为只需要返回新长度就可以了，所以只追踪了长度，并没有对数组进行任何的变动。但是提交后发现，它要求必须构建出已经移除了重复元素的数组
2. 应该将数组长度为0的情况作为特殊情况讨论，否则会出现超时的错误。
3. 注意修改while循环if条件做runner自增后，需要相应改动runner的初始化部分


###27. [Remove Element](https://leetcode.com/problems/remove-element/)（296 ms）
```数组``` ```两个指针```

删除一个数组中的指定元素。返回新数组的长度。

**要求**

1. 不可以创建新的数组，而是要在原位操作
2. 对于新的数组，只要求截止至新的长度是没有重复元素的状态即可，超出的部分可以不管

**分析**

1. 其实和26的思路相似，都是本质上将需要的元素移动到下一个位置上，并不需要实际删除元素
2. 与26题不同之处在于比较的对象是val而不是pivot位置的元素，所以pivot可以放心的指向下一个需要替换的元素就可以了。
3. 作为优化来讲，应该是可以再减少移动元素的次数，也就是从后方挪来新的元素
	
	- 尝试使用这个方法来优化之后发现逻辑非常复杂，主要是因为最后一个寻找的时候需要知道究竟是找到了还是没有。可能因为逻辑复杂了，运行时间并没有变快

**错误**

1. 注意pivot现在代表的意思是下一个需要被替换的元素，因此最后返回的内容不再是pivot+1而是pivot就可以了


###80. [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)（328 ms）
```数组``` ```两个指针```

删除一个已经排序好的数组中的重复元素，但是允许同一个数字出现2次。返回新数组的长度。

**要求**

1. 不可以创建新的数组，而是要在原位操作
2. 对于新的数组，只要求截止至新的长度是没有重复元素的状态即可，超出的部分可以不管
3. 同样的数字可以出现2次



###88. [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) (292ms)
```数组``` ```两个指针```

将两个已经排好序的，长度分别为m,n的数组num1, num2合并为num1。其中num1的长度大于m+n。

**要求**

1. 将num2合并到num1中，不要担心num1的长度会超出的问题


**分析**

1. 虽然看起来最暴力的方法是从前面开始向里面插入，但是会涉及到对于num1的长度并不是很确定的状况，向后移动多少会是一个问题。
2. 所以索性还是放弃插入的方法，从后面开始放进去就好了

**错误**

1. 如果两者都有元素的时候需要比较，但是当有一个“用完”了之后，记得要把另一个剩余的全部元素直接循环放到最终结果中。



###75. [Sort Colors](https://leetcode.com/problems/sort-colors/) (248ms)
```数组``` ```两个指针```

排序一个由red(0), white(1), blue(2)组成的数组。不可以使用内置的排序函数

**分析**

1. 其实就是跑两遍，第一遍把所有的0换到前面来，第二遍把所有的1换到前面来。由于只循环两次，所以是O(n)。这里是个特例，还用不到quicksort一类的就可以


### 128. [Longest Consecutive Sequence ](https://leetcode.com/problems/longest-consecutive-sequence/)
```数组``` 

给定一个未经过排序的数组，寻找其中最长的连续数字序列。

**要求**
1. 复杂度是O(n)

**分析**
1. 由于要求复杂度是O(n)，所以不可能进行排序。
2. 根据网上的提示使用Hashmap进行处理，这样的好处是可以使用O(n)对数组进行遍历后，就可以尝试使用某值x, x+1, x-1的方式来判断它上下是否出现过。从而寻找最长长度序列。

**错误**
1. 注意++和--的执行顺序。


###55. [Jump Game](https://leetcode.com/problems/jump-game/)(464ms > 404ms)
```数组``` ```贪婪算法``` ```区间覆盖```

给定一组非负的整数数组，每一个数组中的元素代表可以从该位置前进的最大步数。若从最小的index出发，返回是否可以到达最大的index。

**分析**
1. 其实这个问题相当于给定一组已经按照起点升序排好的区间段，问是否他们覆盖了整个区间。

**错误**
1. 注意在遍历数组的时候，不仅需要考虑i是否小于最远可以到达距离，还要注意数组越界的问题


###45. [Jump Game II](https://leetcode.com/problems/jump-game-ii/)
```数组``` ```贪婪算法``` ```最小区间覆盖```

给定一组非负的整数数组，每一个数组中的元素代表可以从该位置前进的最大步数。若从最小的index出发，求最少多少步可以到达最大的index。

**分析**

1. 本题应该是假设终点可以到达
2. 相当于给定一组已经起点按照升序排好的区间段，问从中如何选出最小的区间覆盖解。
3. 永远从当前可用集中选出右端点最大的值，并且将其加入到采用的跳法上。

###121. [best time to buy and sell stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
```数组``` ```DP```

给定一个数组是一只股票的收盘价，问在只允许一次交易（买卖一次）的情况下，最大的收益是多少？

**分析**

1. 最直接的办法当然是使用两层循环，假设i是买入日期，j>i是卖出日期，选择最大值。这样的算法复杂度是n^2
但是经过测试这样的方法会超出本题要求的时间限制，因此也说明了这为什么是一道DP的问题。
2. 其实本题的要求就是寻找这个数组中差值最大的两个数字，大的数字必须出现在小的数字之后。
3. 根据上面这个要求，我们需要知道到目前为止最小的数字是谁，然后动态的计算当前值和这个数之间的差异，因为这些数才有可能是最大值的备选。

**错误**

1. 保留最小值的时候，一定不要初始化变量为0，而是要初始化为数组的第一个数字或者最大数。
2. 还是要留心空数组，空数组！

###122. [best time to buy and sell stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
```数组``` ```贪婪算法```

给定一个数组是一只股票的收盘价，问在允许任意多次交易（但是不可以买空卖空）的情况下，最大的收益是多少？


###123. [best time to buy and sell stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
```数组``` ```DP```

给定一个数组是一只股票的收盘价，问在只允许2次交易的情况下，最大的收益是多少？


