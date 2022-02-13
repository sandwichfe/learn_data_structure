package com.lww.t03_双向链表_doubleLinkedList;

/**
 * @author lww
 * @version 1.0
 * @description: 双向链表
 * @date 2022/2/9 16:27
 */

public class DoubleLinkedList {
    // 存放链表节点
    /**
     * 初始化头节点
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 返回头结点
     *
     * @return head node
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * 遍历（显示）链表
     */
    public void list() {
        // 如果链表为空
        if (head.next == null) {
            System.out.println("当前链表为空");
            return;
        }
        // 用一个temp节点来辅助向后遍历
        HeroNode temp = head.next;
        while (true) {
            //循环一直后移 如果此时temp为空 就说明已经循环到末尾了 此时的temp为最后一个节点的next 已经没有值 直接return 结束
            if (temp == null) {
                break;
            }
            // 打印
            System.out.println(temp);
            //后移 节点向后遍历
            temp = temp.next;
        }
    }

    /**
     * 添加
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 辅助节点 遍历
        HeroNode temp = head;
        // 遍历到节点的最后位置
        while (true) {
            // 如果为空 就说明已经到最后一个节点了 循环结束
            if (temp.next == null) {
                break;
            }
            // 否则就后移
            temp = temp.next;
        }
        // 将新增的节点添加到最后面
        heroNode.pre = temp;
        temp.next = heroNode;
    }

    /**
     * 修改
     */
    public void update(HeroNode heroNode) {
        // 如果当前链表为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 根据编号找到需要修改的节点
        // 从第一个有效的数据开始遍历
        HeroNode temp = head.next;
        // 标志是否 找到目标节点
        boolean flag = false;
        while (true) {
            // 已经遍历完节点了
            if (temp == null) {
                break;
            }
            // 找到了需要被更新的节点
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            // 不然节点就往下继续走
            temp = temp.next;
        }
        if (flag) {
            // 进行修改
            temp.nickName = heroNode.nickName;
            temp.name = heroNode.name;
        } else {
            System.out.println("未找到该节点");
        }

    }


    /**
     * 删除目标节点
     *
     * @param no
     */
    public void delete(int no) {
        // 如果当前链表为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            //已经遍历完了
            if (temp == null) {
                break;
            }
            // 找到了需要被删除的节点
            if (temp.no == no) {
                flag = true;
                break;
            }
            // 上述情况都不满足 往下继续遍历节点
            temp = temp.next;
        }

        // 存在被删除的目标节点
        if (flag) {
            //进行删除操作
            temp.pre.next = temp.next;
            //如果刚好是删除最后一个节点时 需要判断一下  否则会空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("不存在此节点");
        }

    }

}


/**
 * HeroNode 节点
 */
class HeroNode {
    /**
     * 编号
     */
    public int no;
    /**
     * 姓名
     */
    public String name;
    /**
     * 昵称
     */
    public String nickName;
    /**
     * 指向上一个节点  默认为空
     */
    public HeroNode pre;
    /**
     * 指向下一个节点 默认为空
     */
    public HeroNode next;


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }
}
