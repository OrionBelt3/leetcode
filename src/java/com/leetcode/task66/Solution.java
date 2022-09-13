package com.leetcode.task66;

class Solution {
    public int[] plusOne(int[] digits) {

        int last = digits[digits.length - 1] + 1;
        digits[digits.length - 1] = last % 10;

        if (last == 10) {
            boolean remains = true;
            int i = digits.length - 2;
            while (i > -1 && digits[i] == 9) {
                digits[i] = 0;
                --i;
            }

            if (i > -1) {
                digits[i] = digits[i] + 1;
            } else {
                int [] copy = new int[digits.length + 1];
                for (int k = digits.length - 1; k > -1; --k) {
                    copy[k + 1] = digits[k];

                }

                copy[0] = 1;

                digits = copy;
            }
        }

        return digits;
    }
}
