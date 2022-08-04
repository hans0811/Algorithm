package amazonLeetcode;

import algorithm.linkedlist.ListNode;

public interface A012_23MergekSortedLists_hard {


    public static void mergeK(ListNode[] lists, int p, int r){

        if(p<r){

            int q = (p+r)/2;
            mergeK(lists, p, q);
            mergeK(lists, q+1, r);
            lists[p] = mergeTwoLists(lists[p], lists[q+1]);
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

}
