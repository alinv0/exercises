package linkedlist;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }
}

public class DeleteMiddle {
  static class Solution {
    public ListNode deleteMiddle(ListNode head) {
      if (head == null || head.next == null) {
        return null;
      }

      ListNode slow = head;
      ListNode fast = head;
      ListNode prev = null;

      while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
      }

      if (prev != null) {
        prev.next = slow.next;
      }

      return head;
    }
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .deleteMiddle(
                new ListNode(
                    1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
  }
}
