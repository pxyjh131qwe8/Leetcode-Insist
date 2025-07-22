package com.peng.linklist.leetcode206;

//206.反转链表

import com.peng.linklist.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre; //反转指针
            pre = cur; //pre向前移动
            cur = temp; //cur向前移动
        }
        return pre;
    }
}
