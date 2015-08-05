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