package com.hans.linkedlist;

/**
 * @author hans
 */
public class L0092ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {


        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node = pre;

        for(int i=1; i < left; i++){
            node = node.next;
        }

        ListNode cur = node.next;
        for(int i=left; i<right; i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = node.next;
            node.next = temp;
        }

        return pre.next;
    }
}

//    ListNode prehead = new ListNode(0);
//        prehead.next = head;
//                ListNode node = prehead;
//                //将node移至需要反转的前一个节点
//                for(int i=1; i<left; i++) {
//        node = node.next;
//        }
//        //cur为需要反转的第一个节点，在接下来的遍历中所指向的节点保持不变
//        ListNode cur = node.next;
//        for(int i=left; i<right; i++) {
//        ListNode temp = cur.next;   //当前需要反转的节点
//        cur.next = temp.next;
//        temp.next = node.next;
//        node.next = temp;
//        }
//        return prehead.next;