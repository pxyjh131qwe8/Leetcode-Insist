package com.peng.linklist.leetcode24;

import com.peng.linklist.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        //设置虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        ListNode firstNode;
        ListNode secondNode;
        ListNode temp;

        while (curr.next != null && curr.next.next != null) {
            firstNode = curr.next;
            secondNode = curr.next.next;
            temp = curr.next.next.next;
            //第一步
            curr.next = secondNode;
            //第二步
            secondNode.next = firstNode;
            //第三步
            firstNode.next = temp;
            //curr移动
            curr = firstNode;
        }
        return dummy.next;

    }
}
