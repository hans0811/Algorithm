package com.company.LinkList;

public class L0025ReverseNodesInkGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k ==1)return head;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        ListNode startP = head;
        ListNode endP = head;
        ListNode nextP = head;

        //get the a section of list with length k;
        for(int i=1; i <k; i++){
            endP = endP.next;
            if(endP == null) return head;
        }

        nextP = endP.next;
        endP.next = null;

        // reverse
        ListNode revP = reverse(startP);
        p.next = revP;

        // recursion rest listnode
        if(nextP!=null){
            while(p.next!=null){
                p = p.next;
            }
            p.next = reverseKGroup(nextP, k);
        }

        return newHead.next;
    }

    public static ListNode reverse(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);

        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;

        //reverse(a1);
        //System.out.println(reverse(a1));

        System.out.println(reverseKGroup(a1, 3));

    }
}
