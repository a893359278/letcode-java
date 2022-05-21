### 题目来源
[包含min函数的栈](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=23268&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

```
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。

此栈包含的方法有：
push(value):将value压入栈中
pop():弹出栈顶元素
top():获取栈顶元素
min():获取栈中最小元素

数据范围：操作数量满足 0 \le n \le 300 \0≤n≤300  ，输入的元素满足 |val| \le 10000 \∣val∣≤10000 
进阶：栈的各个操作的时间复杂度是 O(1)\O(1)  ，空间复杂度是 O(n)\O(n) 

示例:
输入:    ["PSH-1","PSH2","MIN","TOP","POP","PSH1","TOP","MIN"]
输出:    -1,2,1,-1
解析:
"PSH-1"表示将-1压入栈中，栈中元素为-1
"PSH2"表示将2压入栈中，栈中元素为2，-1
“MIN”表示获取此时栈中最小元素==>返回-1
"TOP"表示获取栈顶元素==>返回2
"POP"表示弹出栈顶元素，弹出2，栈中元素为-1
"PSH1"表示将1压入栈中，栈中元素为1，-1
"TOP"表示获取栈顶元素==>返回1
“MIN”表示获取此时栈中最小元素==>返回-1
```


### 题解

用辅助栈，存储每次 入栈时的最小值。这样在出栈的时候，只需要取辅助栈出栈后的栈顶元素，就可以拿到 此时栈中的最小值。

```java
import java.util.LinkedList;
public class Solution {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> minStack = new LinkedList<>();

        int min = Integer.MAX_VALUE;

        public void push(int node) {
            if (node < min) {
                minStack.push(node);
                min = node;
            } else {
                minStack.push(min);
            }

            stack.push(node);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            min = minStack.peek();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
}
```
