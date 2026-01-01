package com.ksj.dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
private final AddTwoNumbers solver = new AddTwoNumbers();

    // --- Helper Methods for Testing ---

    // Convert integer array to ListNode
    private ListNode toList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Convert ListNode to integer array (List<Integer> for easy comparison)
    private List<Integer> toArray(ListNode node) {
        List<Integer> result = new ArrayList<>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result;
    }

    // --- Test Cases ---

    @Test
    void testExample1() {
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]
        ListNode l1 = toList(new int[]{2, 4, 3});
        ListNode l2 = toList(new int[]{5, 6, 4});
        
        ListNode resultNode = solver.addTwoNumbers(l1, l2);
        List<Integer> result = toArray(resultNode);
        
        Assertions.assertEquals(List.of(7, 0, 8), result);
    }

    @Test
    void testExample2_Zero() {
        // Input: l1 = [0], l2 = [0]
        // Output: [0]
        ListNode l1 = toList(new int[]{0});
        ListNode l2 = toList(new int[]{0});
        
        ListNode resultNode = solver.addTwoNumbers(l1, l2);
        List<Integer> result = toArray(resultNode);
        
        Assertions.assertEquals(List.of(0), result);
    }

    @Test
    void testExample3_CarryOver() {
        // Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        // Output: [8,9,9,9,0,0,0,1]
        // This tests uneven lengths AND multiple carry-overs
        ListNode l1 = toList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = toList(new int[]{9, 9, 9, 9});
        
        ListNode resultNode = solver.addTwoNumbers(l1, l2);
        List<Integer> result = toArray(resultNode);
        
        Assertions.assertEquals(List.of(8, 9, 9, 9, 0, 0, 0, 1), result);
    }

    @Test
    void testUnevenLengths() {
        // Input: l1 = [5], l2 = [5, 5]
        // Output: [0, 6] (5 + 55 = 60 -> stored as 0, 6)
        ListNode l1 = toList(new int[]{5});
        ListNode l2 = toList(new int[]{5, 5});

        ListNode resultNode = solver.addTwoNumbers(l1, l2);
        List<Integer> result = toArray(resultNode);

        Assertions.assertEquals(List.of(0, 6), result);
    }
}
