package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author linhuankai
 * @date 2021/3/16 0:40
 * 题目：最大频率栈。
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 * FreqStack 有两个函数：push(int x)，将整数 x 推入栈中。pop()，
 * 它移除并返回栈中出现最频繁的元素。如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * ◼ 示例： push [5,7,5,7,4,5] pop() -> 返回 5，因为 5 是出现频率最高的。栈变成 [5,7,5,7,4]。
 * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈 顶。栈变成 [5,7,5,4]。
 * pop() -> 返回 5 。栈变成 [5,7,4]。 pop() -> 返回 4 。栈变成 [5,7]。
 */
public class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxFreq) {
            maxFreq = f;
        }
        group.computeIfAbsent(f, z -> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
