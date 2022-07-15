package com.hans.linkedlist;

/**
 * @author hans
 */
public class L0024SwapNodesInnPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            // set p to node1
            p=node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        // 25, 147, 148
    }
}
