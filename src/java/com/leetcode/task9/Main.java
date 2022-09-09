package com.leetcode.task9;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10501));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        String xString = "" + x;
        int size = xString.length();
        if (x < 0) {
            return false;
        } else {
            for (int i = 0; i < size/2; ++i) {
                if(xString.charAt(i) != xString.charAt(size - i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}