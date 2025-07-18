package linkedlist;

// https://leetcode.com/problems/add-two-numbers/description/

public class AddTwoNumbers {

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args){
    ListNode l1 = new ListNode(9);
    ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9,
        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
            new ListNode(9, new ListNode(9))))))))));

    System.out.println(getSum(l1, l2));
  }

  public static ListNode getSum(ListNode l1, ListNode l2) {
    int carriage = 0;
    ListNode result = new ListNode(-1);
    ListNode cPos = result;
    ListNode l1Idx = l1;
    ListNode l2Idx = l2;
    while(l1Idx != null || l2Idx != null) {
      int l1Val = l1Idx != null ? l1Idx.val : 0;
      int l2Val = l2Idx != null ? l2Idx.val : 0;
      int sum = l1Val + l2Val + carriage;
      int digit = sum % 10;
      carriage = sum / 10;
      cPos.next = new ListNode(digit);
      cPos = cPos.next;

      if(l1Idx != null) {
        l1Idx = l1Idx.next;
      }

      if(l2Idx != null) {
        l2Idx = l2Idx.next;
      }
    }

    if (carriage > 0)  {
      cPos.next = new ListNode(carriage);
      cPos = cPos.next;
    }

    result = result.next;
    return result;
  }
} 