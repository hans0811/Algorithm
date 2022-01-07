package com.company.LinkList;

import java.util.List;

/**
 * You are given an array of k linked-lists lists,
 * each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Input: lists = []
 * Output: []
 *
 * Input: lists = [[]]
 * Output: []
 *
 */
public class L0023MergekSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {

        mergeK(lists, 0, lists.length-1);

        return lists[0];
    }

    public static void mergeK(ListNode[] lists, int p, int r){

        if (p<r) {

            int q = (p+r)/2;
            mergeK(lists,p,q);
            mergeK(lists,q+1,r);
            lists[p] = mergeTwoLists(lists[p],lists[q+1]);
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if( list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {

    }


}
