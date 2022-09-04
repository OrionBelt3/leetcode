package com.leetcode.task2;

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

        result = solution.addTwoNumbers(root1, root2);

        System.out.println("Result:");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root;
        ListNode current;
        ListNode newNode;
        int remains;

        root = new ListNode();
        root.val = (l1.val + l2.val)%10;
        remains = (l1.val + l2.val)/10;

        current = root;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            newNode = new ListNode();
            newNode.val = (l1.val + l2.val + remains)%10;
            remains = (l1.val + l2.val + remains)/10;
            current.next = newNode;
            current = current.next;
        }

        while (l1.next != null) {
            l1 = l1.next;
            newNode = new ListNode();
            newNode.val = (l1.val + remains)%10;
            remains = (l1.val + remains)/10;
            current.next = newNode;
            current = current.next;
        }

        while (l2.next != null) {
            l2 = l2.next;
            newNode = new ListNode();
            newNode.val = (l2.val + remains)%10;
            remains = (l2.val + remains)/10;
            current.next = newNode;
            current = current.next;

        }

        if (remains != 0) {
            newNode = new ListNode();
            newNode.val = remains;
            current.next = newNode;
        }

        return root;
    }

    private ListNode reverse(ListNode root) {
        ListNode newRoot = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = newRoot;
            newRoot = root;
            root = next;
        }
        return newRoot;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
