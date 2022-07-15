package com.company.LinkedList;

/**
 * @author hans
 */
public class L0082RemoveDuplicateFromSorted {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode cur = head;

        while(cur != null){

            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;

                if(pre.next == cur){
                    pre = cur;
                }else{
                    pre.next = cur.next;
                }
                cur = cur.next;
            }


        }
        return newHead.next;
    }
}
