package com.algorithm.fristweek.homework;

public abstract class ICircularDeque {

    protected int capacity;
    protected int[] arr;
    protected int front;
    protected int rear;

    /**
     * 将一个元素添加到双端队列头部。
     * @param value
     * @return 如果操作成功返回 true。
     */
    public abstract boolean insertFront(int value);

    /**
     * 将一个元素添加到双端队列尾部。
     * @param value
     * @return 如果操作成功返回 true
     */
    public abstract boolean insertLast(int value);

    /**
     * 从双端队列头部删除一个元素。
     * @return 如果操作成功返回 true。
     */
    public abstract boolean deleteFront() ;

    /**
     * 从双端队列尾部删除一个元素。
     * @return 如果操作成功返回 true。
     */
    public abstract boolean deleteLast() ;

    /**
     * 从双端队列头部获得一个元素。
     * @return 如果双端队列为空，返回 -1。
     */
    public abstract int getFront() ;

    /**
     * 获得双端队列的最后一个元素。
     * @return 如果双端队列为空，返回 -1。
     */
    public abstract int getRear() ;

    /**
     * 检查双端队列是否为空。
     * @return
     */
    public abstract boolean isEmpty() ;

    /**
     * 检查双端队列是否满了。
     * @return
     */
    public abstract boolean isFull() ;
}
