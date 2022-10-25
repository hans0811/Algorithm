package com.hans.amazon.amazonLeetcode;

import com.hans.linkedlist.ListNode;

public class A017_AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode res = temp;

        int carry=0;

        while( l1 != null || l2 != null ){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;

            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }

            if ( carry != 0 ){
                temp.next = new ListNode(carry);
            }
        }
        return res.next;
    }
}
