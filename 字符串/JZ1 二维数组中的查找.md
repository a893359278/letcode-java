题目来源：[牛科网](https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=23256&ru=/ta/sql-quick-study&qru=/ta/sql-quick-study/question-ranking)
### 题目

在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
```
[
[1,2,8,9],
[2,4,9,12],
[4,7,10,13],
[6,8,11,15]
]
```
给定 target = 7，返回 true。

给定 target = 3，返回 false。

0 <= array.length <= 500
0 <= array[0].length <= 500

你能给出时间复杂度为 O(n+m) 的解法吗？（n,m为矩阵的长和宽）

```
示例1
输入：
7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
复制
返回值：
true
复制
说明：
存在7，返回true  
示例2
输入：
3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
复制
返回值：
false
复制
说明：
不存在3，返回false  
```

### 题解

```java
public class Solution {
    public boolean Find(int target, int [][] array) {
            if (array.length == 0) {
                return false;
            }
            if (array[0].length == 0) {
                return false;
            }
            int x = 0;
            int y = array[0].length - 1;

            do {
                if (array[x][y] > target) {
                    y = y - 1;
                } else if (array[x][y] < target) {
                    x = x + 1;
                } else {
                    return true;
                }

            } while (x < array.length && y >= 0);

            return false;
    }
}
```
