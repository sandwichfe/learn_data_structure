package com.lww.t02_环形队列_circleQueue;

/**
 * @author lww
 * @version 1.0
 * @description: 环形队列实现
 * @date 2022/1/26 18:05
 */
public class CircleArray {
    /**
     * 表示此队列的真实容量 可容纳多少个数据
     */
    private int maxSize;
    /**
     * 队列头  默认值为0
     */
    private int front;
    /**
     * 队列尾的后一个位置  此位置不存放数据，主要的意义就是为了区分 队列满和对接为空时的条件，不然不好判断   real值默认为0
     */
    private int real;
    /**
     * 用于存放对接的数据
     */
    private int[] arr;


    /**
     * 队列构造器
     *
     * @param arrMaxSize
     */
    public CircleArray(int arrMaxSize) {
        //  因为有一个real是占位置 但是不放数据的。如果要与使用者传进来的大小一致，这里就直接在他传进来的基础上加一
        maxSize = arrMaxSize + 0;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     * 原理上来说 +1就够了 但是它是环形的  所有需要+1后除以环的长度取余是否等于front来判断     来保证绝对值
     *
     * @return
     */
    public boolean isFull() {
        return (real + 1) % maxSize == front;
    }


    /**
     * 判断队列是否为空  当他们都在同一格时就是空了
     *
     * @return
     */
    public boolean isEmpty() {
        return real == front;
    }


    /**
     * 添加一个元素到队列
     *
     * @param n
     */
    public void addQueue(int n) {
        //如果队列已经满了
        if (isFull()) {
            System.out.println("队列已满！");
            return;
        }
        // 加入数据
        arr[real] = n;
        //real 往后移一位  这里要考虑调头的情况  因为很有可能他已经到了数组的最后一位了 但是最前面是空的，这时候就需要取模来跳过去。
        // 就像 时钟 将13点 等于1点的情况  取maxSize整除来取余数
        real = (real + 1) % maxSize;
    }

    /**
     * 取队列头的数据  首元素出列
     *
     * @return
     */
    public int getQueue() {
        // 如果是空的
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空!");
        }
        // 对应front的值就是 队列首的值
        int value = arr[front];
        // 值取出后 front的值后移   后移原理与real原理一样 所以这里要取模
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示当前队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("当前队列为空，暂时没有数据!");
        }
        // 从front位置开始遍历 有多少个值就遍历多少次 打印
        for (int i = front; i < front + size(); i++) {
            // 当前index的值：  要除去总周长也是同理....   可能调头了
            int index = i % maxSize;
            System.out.printf("arr[%d]=%d\n", index, arr[index]);
        }
    }

    /**
     * 求出当前队列有效数据的个数
     *
     * @return
     */
    public int size() {
        // 原理....  环形验证得出吧..  例如下
        // rear = 2
        // front = 1
        // maxsize = 3
        return (real + maxSize - front) % maxSize;
    }

    /**
     * 查看当前队列头元素
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空，暂时没有数据!");
        }
        return arr[front];
    }
}
