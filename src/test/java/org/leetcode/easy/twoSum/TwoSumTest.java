package org.leetcode.easy.twoSum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void testBruteForce() {
        Solution1 sol = new Solution1();
        assertArrayEquals(new int[]{0,1}, sol.twoSum(new int[]{2,7,11,15}, 9));
        assertArrayEquals(new int[]{1,2}, sol.twoSum(new int[]{3,2,4}, 6));
        assertArrayEquals(new int[]{0,1}, sol.twoSum(new int[]{3,3}, 6));
    }

    /*@Test
    void testOptimized() {
        Solution2 sol = new Solution2();
        assertArrayEquals(new int[]{0,1}, sol.twoSum(new int[]{2,7,11,15}, 9));
        assertArrayEquals(new int[]{1,2}, sol.twoSum(new int[]{3,2,4}, 6));
        assertArrayEquals(new int[]{0,1}, sol.twoSum(new int[]{3,3}, 6));
    }

    @Test
    void testEdgeCases() {
        Solution2 sol = new Solution2();
        assertArrayEquals(new int[]{0,1}, sol.twoSum(new int[]{1,2}, 3));  // mínimo tamaño
        assertArrayEquals(new int[]{0,1}, sol.twoSum(new int[]{-1,-2,-3,-4,-5}, -8));
    }*/
}