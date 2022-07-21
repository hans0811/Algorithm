package com.hans.linkedlist;

/**
 * @author hans
 */
public class L0019RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if( n < 0 ) return null;
        ListNode dummyHead = new ListNode(0);

        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        // Add dummy head (n+1)
        // The step between p and q is n + 1
        for( int i=0; i < n+1; i++){
            q = q.next;
        }

        while( q != null){
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;

        return dummyHead.next;

    }

    public static void main(String[] args) {

    }
}
