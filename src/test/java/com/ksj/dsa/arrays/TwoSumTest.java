package com.ksj.dsa.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class TwoSumTest {

    private final TwoSum solver = new TwoSum();

    // 1. Define the Test Data Source
    // This method supplies the Input Array, Target, and Expected Result for every test run
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // Format: Arguments.of(Input Array, Target, Expected Array)
            
            // Example 1
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            
            // Example 2
            Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            
            // Example 3
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
            
            // Example 4: Edge Case: Negative numbers
            Arguments.of(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4}), // -3 + -5 = -8
            
            // Example 5:Edge Case: Zeros
            Arguments.of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3})
        );
    }

    // 2. The Actual Test Method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testTwoSum(int[] nums, int target, int[] expected) {
        // Act
        int[] actual = solver.twoSum(nums, target);

        // Sort arrays before comparing to ensure order doesn't fail the test
        // (Since the problem says "return in any order", but assertions need deterministic order)
        Arrays.sort(actual);
        Arrays.sort(expected);

        // Assert
        Assertions.assertArrayEquals(expected, actual, 
            "Failed for input: " + Arrays.toString(nums) + " with target: " + target);
    }
}
