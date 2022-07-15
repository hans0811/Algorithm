package com.company.LinkedList;

/**
 * @author hans
 */
public class L0237DeleteNode {

    public void deleteNode(ListNode node) {

        if(node == null) return;

        if(node.next == null){
            node = null;
            return;
        }
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
    }
}
