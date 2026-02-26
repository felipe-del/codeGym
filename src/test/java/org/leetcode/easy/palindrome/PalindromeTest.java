package org.leetcode.easy.palindrome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void testSolution1() {
        // Solution1: conversión a String
        Solution1 sol = new Solution1();
        assertTrue(sol.isPalindrome(121));
        assertFalse(sol.isPalindrome(-121));
        assertFalse(sol.isPalindrome(10));
        assertTrue(sol.isPalindrome(12321));
        assertTrue(sol.isPalindrome(0));
    }

    @Test
    void testSolution2() {
        // Solution2: sin conversión a String
        Solution2 sol = new Solution2();
        assertTrue(sol.isPalindrome(121));
        assertFalse(sol.isPalindrome(-121));
        assertFalse(sol.isPalindrome(10));
        assertTrue(sol.isPalindrome(12321));
        assertTrue(sol.isPalindrome(0));
    }

    @Test
    void testEdgeCases() {
        Solution2 sol = new Solution2();
        assertTrue(sol.isPalindrome(1));        // número de un solo dígito
        assertFalse(sol.isPalindrome(-1));      // número negativo
        assertFalse(sol.isPalindrome(100));     // múltiplo de 10 que no es 0
        assertTrue(sol.isPalindrome(11));       // dos dígitos palíndromo
    }
}