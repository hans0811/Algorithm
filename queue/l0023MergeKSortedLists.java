package com.hans.queue;

import com.hans.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * @author hans
 */
public class l0023MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null){
            return new ListNode();
        }

        ListNode res = new ListNode();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (n1, n2)  -> n1-n2
        );

        for(int i=0; i < lists.length; i++){

            while(lists[i] != null){
                pq.offer( lists[i].val );
                lists[i] = lists[i].next;
            }
        }

        if(pq.size() == 0) return null;

        res.val = pq.poll();
        if(pq.size() == 0) return res;

        ListNode dummy = new ListNode(pq.poll());
        res.next = dummy;

        while(!pq.isEmpty()){
            ListNode n = new ListNode(pq.poll());
            dummy.next = n;
            dummy = dummy.next;
        }

        return res;

    }
}
