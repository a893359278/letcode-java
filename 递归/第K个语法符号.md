### 题目
779 第K个语法符号

在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。

给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）

例子:
```
输入: N = 1, K = 1
输出: 0

输入: N = 2, K = 1
输出: 0

输入: N = 2, K = 2
输出: 1

输入: N = 4, K = 5
输出: 1

解释:
第一行: 0
第二行: 01
第三行: 0110
第四行: 01101001
```

**注意：**

1. N 的范围 [1, 30].
2. K 的范围 [1, 2^(N-1)].


### 解题思路
1. 递归公式：f(N, K) = f(N - 1, K % 2 == 0 ? K / 2 : k / 2 + 1);
2. 递归边界：N = 1，返回 0.
3. 考虑特殊值：无
```java
class Solution {
    public int kthGrammar(int N, int K) {
        return digui(N, K);
    }

    int digui(int n, int k) {
        if (n == 1) {
            return 0;
        }
        
        int tmp = digui(n - 1,  k % 2 == 0 ? k / 2 : k / 2 + 1);
     
        if (k % 2 == 0) {
            return tmp == 1? 0 : 1;
        } else {
            return tmp;
        }
        
    }
}
```
