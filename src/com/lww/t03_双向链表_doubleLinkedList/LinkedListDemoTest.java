package com.lww.t03_双向链表_doubleLinkedList;

/**
 * @author lww
 * @version 1.0
 * @description: 效果实现测试类
 * @date 2022/2/9 16:38
 */
public class LinkedListDemoTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode heroNode = new HeroNode(1, "AAA", "aaa");
        HeroNode heroNode1 = new HeroNode(2, "BBB", "bbb");
        HeroNode heroNode2 = new HeroNode(3, "CCC", "ccc");
        HeroNode heroNode3 = new HeroNode(4, "DDD", "ddd");
        doubleLinkedList.add(heroNode);
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);

        doubleLinkedList.list();
        System.out.println("修改--------------");
        doubleLinkedList.update(new HeroNode(1, "1", "22"));
        doubleLinkedList.list();

        System.out.println("删除....................");
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(3);
        doubleLinkedList.delete(4);
        doubleLinkedList.list();
    }
}
