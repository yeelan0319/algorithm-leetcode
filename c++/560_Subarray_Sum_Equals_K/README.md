# 解决方法

## Best

计算1~i的结果并将其保存到HashMap中，在每次计算完新的sum的时候，看看是否前面的sub序列出现过
加和结果为sum-k的值，若出现过则说明从那段开始到目前这个点之间的加和为k。

注意在循环开始前，应该将HashMap中，加和为0的情况先置为1。这是因为序列从0开始到i的结果是通过
这个1来表示的。

## 为什么使用橡皮筋的方法不行？

乍一看之下，使用两个pointer来指向序列的起点和终点是非常可行的做法，然而在本例中却是行不通的。
这是因为数组中存在负值，也就是说加和sum < k的时候，向前移动end或者start都有可能使得sum达到
k，因此无法判定究竟在这种情况应该是移动哪一个pointer。


# C++知识

使用Map

C++中的Map保存在map.h的头文件中，使用的方式和二维矩阵的访问方式很像。

```
#include <map>

Map<int, int> rec;

rec[i]++;
counter += rec[i];

```

