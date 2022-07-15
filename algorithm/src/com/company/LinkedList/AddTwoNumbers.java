package com.company.LinkedList;

import com.sun.xml.internal.ws.util.StringUtils;

public class AddTwoNumbers {


    // failed
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String str1 = covert2String(l1, "");
        String str2 = covert2String(l2, "");

        int sum = Integer.parseInt(str1) + Integer.parseInt(str2);

        String stringRes =Integer.toString(sum);
        ListNode res = new ListNode();
        ListNode temp = new ListNode();
        for(int i = 0; i < stringRes.length(); i++){

            if( i == 0 ) {
                res = new ListNode( Integer.parseInt(String.valueOf(stringRes.charAt(i))) );
                temp = res;
            }else{
                ListNode createNew = new ListNode( Integer.parseInt(String.valueOf(stringRes.charAt(i))) );
                temp.next = createNew;
                temp = createNew;
            }
        }
        return res;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
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



    public static String covert2String(ListNode listNode, String str){
        if(listNode.next == null){
            return str + Integer.toString(listNode.val);
        }
        return covert2String(listNode.next, str + Integer.toString(listNode.val));
    }

    public static ListNode lastNode(ListNode node){
        if(node.next == null){
            return node;
        }
        return lastNode(node.next);
    }

    public static  ListNode add2Node(ListNode node1, ListNode node2, Integer carry, ListNode res){

        return null;

    }

    public static ListNode reverseRecursion(ListNode head) {

        if( head == null ){
            return null;
        }

        if( head.next == null){
            return head;
        }

        ListNode listNode = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return listNode;
    }

    public static ListNode reverseLoop(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while( head != null ) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return null;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

//        addTwoNumbers(l1, l4);
//        ListNode a = addTwoNumbers2(l1, l4);

        float a = 5.5f;
        float b = 2.1f;
        System.out.println(a%b);


        System.out.println(reverseRecursion(l1));
    }
}
