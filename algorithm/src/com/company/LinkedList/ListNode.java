package com.company.LinkedList;

public class ListNode {

    public Integer  val;
    public ListNode next;
    public ListNode() {};
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "" + val + "" +next;
    }
}
