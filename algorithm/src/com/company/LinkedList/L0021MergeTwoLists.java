package com.company.LinkedList;

public class L0021MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if( list1.val < list2.val ){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public static ListNode merger2Help(ListNode list1, ListNode list2, ListNode res){
        if( list1 == null ){
            //res.next = list1;
            return list2;
        }else if( list2 == null){
            //res.next = list2;
            return list1;
        }

        if( list1.val < list2.val){
            res = list1;
            return res.next = merger2Help(list1.next, list2, res);

        }else{
            res = list2;
            return res.next = merger2Help(list1.next, list2, res);
        }

    }


    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);

        l1_1.next = l1_2;
        l1_2.next = l1_3;

        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode a = mergeTwoLists(l1_1, l2_1);

        a.toString();
    }
}
