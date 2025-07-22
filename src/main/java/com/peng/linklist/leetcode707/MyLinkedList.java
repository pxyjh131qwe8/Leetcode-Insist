package com.peng.linklist.leetcode707;


//707.设计链表

class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
    }

    private int size;
    //这里记录虚拟头节点
    private ListNode head;

    //初始化链表
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }

        //链表的查询需要遍历
        //因为head是虚拟头节点，所以要查找的index事实上应该查到index+1
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        //将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        //更新长度
        size++;
    }

    public void addAtTail(int val) {
        //将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        //更新长度
        size++;
    }

    public void addAtIndex(int index, int val) {
        //将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
        //如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
        //如果 index 比长度更大，该节点将 不会插入 到链表中。
        if (index < 0 || index > size) {
            return;
        }

        ListNode newNode = new ListNode(val);
        ListNode pre = head;  //要插入节点的前驱

        if (index == size) {
            addAtTail(val);
            return;
        }

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        //如果下标有效，则删除链表中下标为 index 的节点。
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
