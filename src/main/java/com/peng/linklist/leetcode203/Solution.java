package com.peng.linklist.leetcode203;

import com.peng.linklist.ListNode;

//203.移除链表元素

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //设置虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
