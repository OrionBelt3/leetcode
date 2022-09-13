package com.leetcode.task26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int nonDuplicate = 0;

        for (int current = 1; current < nums.length; ++current) {
            if (nums[nonDuplicate] != nums[current]) {
                nums[nonDuplicate+1] = nums[current];
                ++nonDuplicate;
            }
        }

        return nonDuplicate + 1;
    }
}
