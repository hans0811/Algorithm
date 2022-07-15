package com.company.LinkedList;

import javax.xml.soap.Node;

public class L0024SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;
        while(curr.next != null && curr.next.next != null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return temp.next;
    }


    public static void deleteEven(ListNode listNode){

        if(listNode == null) return ;

        ListNode node = listNode.next;

        if(node ==null) return;

        listNode.next = node.next;

        deleteEven(listNode.next);
    }

    public static ListNode deleteOdd(ListNode listNode){

        if(listNode == null ) return null;

        if(listNode.next == null) {
            return listNode;
        }

        ListNode currNode = listNode.next;

        //if(currNode.next == null) return listNode;
        listNode = currNode;

        listNode.next = deleteOdd(listNode.next);

        return listNode;
    }

    public static ListNode deleteOddWhile(ListNode listNode){

        if(listNode == null) return null;

        listNode = listNode.next;

        ListNode even = listNode;
        ListNode odd  = listNode.next;
        while( even != null && odd != null){

            even.next = odd.next;
            odd = null;
            even = even.next;

            if(even != null){
                odd = even.next;
            }
        }
        return listNode;
    }

    public static void deleteOdd2(ListNode listNode){

        if(listNode == null) return ;

        ListNode node = listNode.next.next;

        if(node ==null) return;

        listNode = node.next;

        deleteOdd2(listNode.next);
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

        ListNode node = swapPairs(a1);

        System.out.println(node);
    }

}
