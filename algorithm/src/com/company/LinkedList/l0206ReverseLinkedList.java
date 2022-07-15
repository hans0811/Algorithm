package com.company.LinkedList;

/**
 * @author hans
 */
public class l0206ReverseLinkedList {


    public static ListNode createLinkedList(int[] arr, int n){

        if(n==0) return null;

        ListNode head = new ListNode(arr[0]);

        ListNode cur = head;

        for(int i=1; i < n; i++){

            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }
    static void  printLikedList(ListNode head){

        ListNode cur = head;

        while(cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }

        System.out.println("NULL");
    }

    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while( cur != null) {

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {


        int[] a = {1,2,3,4,5};

        ListNode node = createLinkedList(a, 5);

        printLikedList(reverseList(node));

    }
}
