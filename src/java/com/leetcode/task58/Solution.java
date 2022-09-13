package com.leetcode.task58;

class Solution {
    public int lengthOfLastWord(String s) {

        int l = 0;
        String [] words = s.split(" ");



        return words[words.length -1].length();

    }
}
