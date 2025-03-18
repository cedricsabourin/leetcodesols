package EASY;

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
public class MergeSortedLists {

    
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // dummy node and the list we will be modifying
        ListNode dummy = new ListNode();
        ListNode toBeReturned = dummy;

        // while both the lists have elements, we compare their values and add them to the list to be returned in the correct order
        while ((list1 != null) && (list2 != null)) {
            if (list1.val < list2.val) {
                toBeReturned.next = list1;
                list1 = list1.next;
            } else {
                toBeReturned.next = list2;
                list2 = list2.next;
            }

            toBeReturned = toBeReturned.next;
        }

        // if there are remaining elements in either lists, we add them at the end of the list
        if (list1 != null) {
            toBeReturned.next = list1;
        } else {
            toBeReturned.next = list2;
        }


        // dummy.next is the head of the list to be returned
        return dummy.next;
        

    }

    public static void main(String[] args) {

        // Test Case 1: Merging two sorted lists
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        System.out.println("Test Case 1: " + mergeTwoLists(list1, list2));

    
        // Test Case 2: One list is empty
        list1 = null;
        list2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("Test Case 2: " + mergeTwoLists(list1, list2));

    
            // Test Case 3: Both lists are empty
        list1 = null;
        list2 = null;
        System.out.println("Test Case 3: " + mergeTwoLists(list1, list2));
    
            // Test Case 4: Lists with one element each
        list1 = new ListNode(1);
        list2 = new ListNode(2);
        System.out.println("Test Case 4: " + mergeTwoLists(list1, list2));

    
        // Test Case 5: Lists with duplicate values
        list1 = new ListNode(1, new ListNode(3, new ListNode(3)));
        list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Test Case 5: " + mergeTwoLists(list1, list2));
    }
    
}
    


