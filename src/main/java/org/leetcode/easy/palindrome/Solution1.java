package org.leetcode.easy.palindrome;

public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = Integer.toString(x);
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
