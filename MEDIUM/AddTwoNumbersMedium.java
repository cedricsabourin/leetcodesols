package MEDIUM;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbersMedium {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 342
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 465

        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9))); // 999
        ListNode l4 = new ListNode(8, new ListNode(8, new ListNode(8, new ListNode(8)))); // 8888


        System.out.println("Test Case 342 + 465 => " + addTwoNumbers(l1, l2) + " (807)");
        System.out.println("Test Case 999 + 8888 => " + addTwoNumbers(l3, l4) + " (9887)");
        System.out.println("Test Case 342 + 999 => " + addTwoNumbers(l1, l3) + " (1341)");
        System.out.println("Test Case 465 + 8888 => " + addTwoNumbers(l2, l4) + " (9353)");
    }
    

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode zero = new ListNode(0); // dummy node
        ListNode current = zero;

        
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            // the sum of the current node will be the carry + both values
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // if we have 16, the val will be 6 and carry is 1
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

        }

        return zero.next;
    }
}