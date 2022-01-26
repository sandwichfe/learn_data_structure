package com.lww.t02_环形队列_circleQueue;

import java.util.Scanner;

/**
 * @author lww
 * @version 1.0
 * @description: 环形队列
 * @date 2022/1/26 17:18
 */
public class CircleArrayQueue {

    /**
     * 用数组来实现环形队列 从而保证数据的可重复用  其实这里面的很多算法就像时钟一样， 圆的时钟然后转呀转呀转
     */
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("--------------start--------------");
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("---------------end--------------");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int ret = queue.getQueue();
                        System.out.println("取出了：" + ret);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int ret = queue.headQueue();
                        System.out.println("当前队列头的值为：" + ret);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
            }
        }
        System.out.println("bye！");
    }


}
