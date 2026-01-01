package com.ksj.dsa.linkedlist;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
* Add Two Numbers

* Link: https://leetcode.com/problems/add-two-numbers/
* Difficulty: Medium
* Tags: Linked List, Recursion

* The Approach
1. Use a `dummy` head to simplify result list construction.
2. Maintain a `carry` variable for sums > 9.
3. Iterate while either list has nodes or a `carry` remains.
4. Treat `null` nodes as `0` to handle lists of unequal length.

* Complexity Analysis
* Time Complexity: O(max(n, m))
* We iterate through the lists exactly once. The loop runs for the length of the longer list (plus 1 extra iteration if there is a carry at the end).
* Space Complexity: O(max(n, m))
* We create a new Linked List to store the result. The length of this list is at most max(n, m) + 1.
*/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Initialize a "Dummy" node.
        // This simplifies edge cases (like handling the head of the result list).
        // We will return dummy.next at the end.
        ListNode dummy = new ListNode(0);
        
        // 'current' pointer helps us build the new list node by node.
        ListNode current = dummy;
        
        // 'carry' stores the overflow from the previous addition (e.g., 5 + 7 = 12, carry is 1).
        int carry = 0;

        // 2. Loop until both lists are exhausted AND there is no remaining carry.
        while (l1 != null || l2 != null || carry != 0) {
            
            // Get values from the lists. If a list is null (shorter than the other), use 0.
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // 3. Calculate sum and new carry
            int sum = carry + x + y;
            carry = sum / 10;      // Integer division gets the tens place (e.g., 12 / 10 = 1)
            int digit = sum % 10;  // Modulo gets the ones place (e.g., 12 % 10 = 2)

            // 4. Create a new node with the calculated digit and attach it
            current.next = new ListNode(digit);
            
            // Move the current pointer forward
            current = current.next;

            // Move input pointers forward if they are not null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the list starting from the node AFTER the dummy
        return dummy.next;
    }
}
