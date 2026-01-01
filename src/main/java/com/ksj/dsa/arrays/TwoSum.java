package com.ksj.dsa.arrays;

import java.util.Map;

/**
* Two Sum

* Link: https://leetcode.com/problems/two-sum/
* Difficulty: Easy
* Tags: Array, Hash Table

* The Approach
* Instead of using a brute force approach with nested loops (which would be O(n^2)), I used a One-pass Hash Table approach.
1. As we iterate through the array, we check if the `target - current_value` (the complement) exists in our map.
2. If it exists, we have found our pair.
3. If not, we add the current value and its index to the map and continue.

* Complexity Analysis
* Time Complexity: O(n)
* We traverse the list containing n elements exactly once. Each lookup in the table costs only O(1) on average.
* Space Complexity: O(n)
* The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 */


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the numbers we have seen and their indices.
        // Key: The number from the array (nums[i])
        // Value: The index of that number (i)
        Map<Integer, Integer> numMap = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the complement (the number we need to reach the target)
            // is already in our map.
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            // If not found, add the current number and its index to the map
            // so future numbers can look for it.
            numMap.put(nums[i], i);
        }
        // Return empty array if no solution is found (though problem guarantees one solution)
        return new int[] {}; // Return empty array if no solution is found
    }
}