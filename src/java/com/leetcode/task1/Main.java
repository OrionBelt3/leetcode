package com.leetcode.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the size array: ");
        int size = console.nextInt();
        int[] nums = new int[size];

        for (int i = 0; i < size; ++i) {
            nums[i] = console.nextInt();
        }
        System.out.print("Enter the target: ");
        int target = console.nextInt();
        int[] res = solution.twoSum(nums, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        int difference;
        boolean flag = false;
        for(int i = 0; i < nums.length; ++i) {
            if (flag) {
                break;
            }
            res[0] = i;
            difference = target - nums[i];

            for(int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == difference) {
                    res[1] = j;
                    flag = true;
                }
            }
        }
        return res;
    }
}
