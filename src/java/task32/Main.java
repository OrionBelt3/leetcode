package task32;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //String s = console.next();
        String str = "(()(((()";
        System.out.println(new Solution().longestValidParentheses(str));
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        if (s.equals("")) {
            return 0;
        }
        int i = getBegin(s, 0, s.length());
        int maxLength = 0;
        int currentLength = 0;
        int balance = 0;
        int psevdoBalance = 0;
        int pos = 0;

        for (; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            psevdoBalance++;

            if (balance == 0) {
                pos = i;
                psevdoBalance = 0;
            }

            if (balance == -1) {
                maxLength = Math.max(maxLength, currentLength);
                i = getBegin(s, i, s.length());
                currentLength = 0;
                balance = 0;
                continue;
            }

            currentLength++;
        }

        if (balance > 0) {
            currentLength = s.length() - pos - psevdoBalance - 1;
        }

        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    private int getBegin (String s, int current, int end) {
        while (s.charAt(current) != '(') {
            if (current == end - 1) {
                break;
            }
            ++current;

        }
        return current;
    }
}

