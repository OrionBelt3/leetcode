package com.leetcode.task20;

import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("(({[(])}))"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (int i = 0; i < s.length(); ++i) {
            if (!(stack.empty()) && (stack.peek() == map.get(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }
}