package com.bit1024;

import java.util.Stack;

/**
 * \* @Author: yesheng
 * \* Date: 2020/10/13 20:18
 * \* Description:用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * \
 */
public class TwoStackQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public TwoStackQueue(){
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value){
        in.add(value);
    }

    public int deleteHead(){
        //先判断out是否为空，如果不为空直接出栈，如果为空in转移到out，如果不为空直接出栈
        if(!out.isEmpty()){
            return out.pop();
        }
        while(!in.isEmpty()){
            out.add(in.pop());
        }
        if(out.isEmpty()){
            return -1;
        }
        return out.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.appendTail(1);
        twoStackQueue.appendTail(2);
        twoStackQueue.appendTail(3);
        twoStackQueue.appendTail(4);

        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
        System.out.println(twoStackQueue.deleteHead());
    }
}