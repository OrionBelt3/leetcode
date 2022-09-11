package com.leetcode.task21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner console = new Scanner(System.in);

        ListNode root1 = new ListNode();
        ListNode root2 = new ListNode();
        ListNode result;
        ListNode current;
        ListNode newNode;

        System.out.print("1 list size:");
        int size1 = console.nextInt();
        System.out.println("1 list:");
        root1.val = console.nextInt();
        current = root1;

        for (int i = 1; i < size1; ++i) {
            newNode = new ListNode();
            newNode.val = console.nextInt();
            current.next = newNode;
            current = newNode;
        }
        System.out.print("2 list size:");
        int size2 = console.nextInt();
        System.out.println("2 list:");
        root2.val = console.nextInt();
        current = root2;

        for (int i = 1; i < size2; ++i) {
            newNode = new ListNode();
            newNode.val = console.nextInt();
            current.next = newNode;
            current = newNode;
        }

        result = new Solution().mergeTwoLists(root1, root2);

        System.out.println("Result:");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode rootResult;
        ListNode current;
        boolean adapter;

        rootResult = new ListNode();

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            rootResult.val = list2.val;
            list2 = list2.next;
        } else if (list2 == null) {
            rootResult.val = list1.val;
            list1 = list1.next;
        } else {
            adapter = list1.val <= list2.val;

            if (adapter) {
                rootResult.val = list1.val;
                list1 = list1.next;
            } else {
                rootResult.val = list2.val;
                list2 = list2.next;
            }
        }


        current = rootResult;

        while (list1 != null && list2 != null) {
            current.next = new ListNode();
            current = current.next;

            adapter = list1.val <= list2.val;

            if (adapter) {
                current.val = list1.val;
                list1 = list1.next;
            } else {
                current.val = list2.val;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            current.next = new ListNode();
            current = current.next;
            current.val = list1.val;
            list1 = list1.next;
        }

        while (list2 != null) {
            current.next = new ListNode();
            current = current.next;
            current.val = list2.val;
            list2 = list2.next;
        }

        return rootResult;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}