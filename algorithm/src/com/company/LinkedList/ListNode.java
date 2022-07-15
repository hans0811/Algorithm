package com.company.LinkedList;

public class ListNode {
    Integer  val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "" + val + "" +next;
    }
}
