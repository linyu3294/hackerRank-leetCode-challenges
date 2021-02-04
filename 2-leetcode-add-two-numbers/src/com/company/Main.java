package com.company;

import java.util.HashMap;

class ListNode {
int val;
ListNode next;

ListNode () {
}

ListNode (int val) {
   this.val = val;
}

ListNode (int val, ListNode next) {
   this.val = val;
   this.next = next;
}
}

public class Main {

public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
   ListNode tail =  new ListNode(0);
   ListNode dummy =  tail;

   int sum =0;
   while (l1 != null || l2 != null || sum>0 ){
      ListNode newNode = new ListNode();
      sum = (l1 == null ? 0: l1.val) + (l2 == null ? 0: l2.val) +sum;
      newNode.val = sum % 10;
      sum = (sum - newNode.val) / 10;
      if (l1 != null) l1= l1.next;
      if (l2 != null) l2= l2.next;
      tail.next = newNode;
      tail = newNode;
   }
   return dummy.next;
}

public static void recursivePrintNodes (ListNode l1) {
   if (l1 == null) return;
   else {
      System.out.println(l1.val);
      recursivePrintNodes(l1.next);
   }
}


public static void main (String[] args) {
   // write your code here
   ListNode t7 = new ListNode(9);
   ListNode t6 = new ListNode(9, t7);
   ListNode t5 = new ListNode(9, t6);
   ListNode t4 = new ListNode(9, t5);
   ListNode t3 = new ListNode(9, t4);
   ListNode t2 = new ListNode(9, t3);
   ListNode t1 = new ListNode(9, t2);

   ListNode r4 = new ListNode(9);
   ListNode r3 = new ListNode(9, r4);
   ListNode r2 = new ListNode(9, r3);
   ListNode r1 = new ListNode(9, r2);

   ListNode result = addTwoNumbers(t1, r1);
   recursivePrintNodes(result);

}


}
