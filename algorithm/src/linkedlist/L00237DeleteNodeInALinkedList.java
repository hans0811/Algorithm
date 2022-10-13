package com.hans.linkedlist;

public class L00237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {

    }

}
