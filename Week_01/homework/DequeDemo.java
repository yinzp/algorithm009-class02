package com.algorithm.fristweek.homework;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {
        myDequeDemo2();
    }

    private static void myDequeDemo1() {
        Deque<String> mDeque = new LinkedList();

        for (int i = 1; i <  3; i++) {
            mDeque.push("mDeque_" + i);
        }
        System.out.println("mDeque push: " + mDeque) ;

        mDeque.addFirst("mDeque_" + 9); //Inserts the specified element at the front of this deque 没有容量限制
        System.out.println("mDeque addFirst: " + mDeque) ;

        mDeque.offer("mDeque_" + 8);//有容量限制的时候使用安全？
        System.out.println("mDeque offer" + mDeque) ;

        String str = mDeque.peek();//Retrieves, but does not remove, the head of the queue
        System.out.println("peek str:" + str) ;
        System.out.println("mDeque:" + mDeque) ;


        str = mDeque.pop();//removes and returns the first element of this deque.
        System.out.println("pop str:" + str) ;
        System.out.println("mDeque:" + mDeque) ;
    }

    private static void myDequeDemo2(){
        int i = 1;
        Deque<String> mDeque = new LinkedList<>();

        //offer 队尾加入元素(队列有容量限制时用，无则用add)
        System.out.println("step_"+(i++)+": offer");
        mDeque.offer("A");
        mDeque.offer("B");
        mDeque.offer("C");
        System.out.println(mDeque);//[A, B, C]

        //offerFirst 从队首加入D (队列有容量限制时用，无则用addFirst)
        System.out.println("step_"+(i++)+": offerFirst");
        mDeque.offerFirst("D");
        System.out.println(mDeque);//[D, A, B, C]

        //offerLast 从对尾加入E (队列有容量限制时用，无则用addLast)
        System.out.println("step_"+(i++)+": offerLast");
        mDeque.offerLast("E");
        System.out.println(mDeque);//[D, A, B, C, E]

        // poll 出队操作 获取并删除当前队列的队首元素
        System.out.println("step_"+(i++)+": poll");
        String str = mDeque.poll();
        System.out.println(str);//D
        System.out.println(mDeque);//打印[A, B, C, E]

        //peek 从队首取出元素，不会删除
        System.out.println("step_"+(i++)+": peek");
        str = mDeque.peek();
        System.out.println(str);//A
        System.out.println(mDeque);//打印[A, B, C, E]

        // pollFirst 获取第一位并删除当前队列的队首元素
        System.out.println("step_"+(i++)+": pollFirst");
        str = mDeque.pollFirst();
        System.out.println(str);//A
        System.out.println(mDeque);//打印[B, C, E]

        // pollLast 获取最后一位并删除当前队列的队首元素
        System.out.println("step_"+(i++)+": pollLast");
        str = mDeque.pollLast();
        System.out.println(str);//打印E
        System.out.println(mDeque);//打印[B, C]

        //add 队尾加入元素
        System.out.println("step_"+(i++)+": add");
        mDeque.add("F");
        mDeque.add("G");
        mDeque.add("H");
        mDeque.add("I");
        System.out.println(mDeque);//打印[B, C, F, G, H, I]

        //removeFirst 获取并移除队列第一个元素,pollFirst()也是，
        //区别在于队列为空时,removeFirst会抛出NoSuchElementException异常，后者返回null
        System.out.println("step_"+(i++)+": removeFirst");
        mDeque.removeFirst();
        System.out.println(mDeque);//打印[C, F, G, H, I]

        //removeLast 获取并移除队列第一个元素,此方法与pollLast
        //区别在于队列为空时,removeLast会抛出NoSuchElementException异常，后者返回null
        System.out.println("step_"+(i++)+": removeLast");
        mDeque.removeLast();
        System.out.println(mDeque);//打印[C, F, G, H]

        //获取队列第一个元素.此方法与 peekFirst
        //区别在于：如果此双端队列为空，它将抛出NoSuchElementException，后者返回null
        System.out.println("step_"+(i++)+": getFirst");
        str = mDeque.getFirst();
        System.out.println(str);//C
        System.out.println(mDeque);//打印[C, F, G, H]

        //获取队列最后一个元素.此方法与 peekLast
        //区别在于：如果此双端队列为空，它将抛出NoSuchElementException，后者返回null
        System.out.println("step_"+(i++)+": getLast");
        str = mDeque.getLast();
        System.out.println(str);//H
        System.out.println(mDeque);//打印[C, F, G, H]

        //循环获取元素并在队列移除元素
        System.out.println("step_"+(i++)+": pop");
        str = mDeque.pop();
        System.out.println(str);//C
        System.out.println(mDeque);//打印[F, G, H]

    }
}
