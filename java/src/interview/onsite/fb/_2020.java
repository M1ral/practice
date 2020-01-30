package interview.onsite.fb;

import leetcode.tree.Tree;
import leetcode.tree.TreeNode;

import java.util.*;

public class _2020 {

    public static void main(String[] args) {
        // Interview: 1
        System.out.println("---------------- products ----------------");
        // printProductsRec(new int[]{5, 2, 3, 4});
        printProductsIter(new int[]{5, 2, 3, 4});

        // Interview: 2
        System.out.println("---------------- Phone number letter combinations ----------------");
        printPhoneNumberLetterCombinations("24");

        // Interview 3
        System.out.println("---------------- Sorted BSTs ----------------");
        printBTSsInSortedOrder(Tree.createBST(new int[]{2, 3, 4, 8, 9}), Tree.createBST(new int[]{1, 5, 6, 7, 10}));
    }

    private static void printProductsRec(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[arr.length];
        backtrack(arr, 0, 1, set, visited);
        set.forEach(System.out::println);
    }

    private static void backtrack(int[] arr, int end, int product, Set<Integer> set, boolean[] visited) {
        if (end >= arr.length)
            return;

        for (int i = end; i >= 0; i--) {
            if (visited[i]) continue;
            int current = arr[i];
            set.add(current);
            set.add(product);
            visited[i] = true;

            // choose
            product *= current;

            // explore
            backtrack(arr, end + 1, product, set, visited);

            // un-choose
            product /= current;
            visited[i] = false;
        }
    }

    private static void printProductsIter(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        int runningProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            runningProduct *= arr[i];
            int currentProduct = runningProduct;

            for (int j = 0; j <= i; j++) {
                set.add(currentProduct);
                currentProduct /= arr[j];
            }
        }

        set.forEach(System.out::println);
    }

    public static void printPhoneNumberLetterCombinations(String number) {
        if (null == number || number.isEmpty()) {
            return;
        }

        Map<Character, String> numMap = new HashMap<>();
        numMap.put('0', "");
        numMap.put('1', "");
        numMap.put('2', "ABC");
        numMap.put('3', "DEF");
        numMap.put('4', "GHI");
        numMap.put('5', "JKL");
        numMap.put('6', "MNO");
        numMap.put('7', "PQRS");
        numMap.put('8', "TUV");
        numMap.put('9', "WXYZ");
        Deque<String> q = new ArrayDeque<>();
        q.add("");

        while (!q.isEmpty() && q.peek().length() != number.length()) {
            String current = q.remove();
            for (char ch : numMap.get(number.charAt(current.length())).toCharArray()) {
                q.addLast(current + ch);
            }
        }
        q.stream().forEach(s -> System.out.println(s));
    }

    public static void printBTSsInSortedOrder(TreeNode p, TreeNode q) {
        if (null == p && null == q) return;
        if (null == p || null == q) Tree.printInorder(null == p ? q : p);

        Deque<TreeNode> pStack = new ArrayDeque<>();
        Deque<TreeNode> qStack = new ArrayDeque<>();

        while (null != p) {
            pStack.push(p);
            p = p.left;
        }

        while (null != q) {
            qStack.push(q);
            q = q.left;
        }

        while (!pStack.isEmpty() || !qStack.isEmpty()) {
            if (!pStack.isEmpty() && !qStack.isEmpty()) {
                if (pStack.peek().val < qStack.peek().val) {
                    System.out.println(pStack.peek().val);
                    addNextNodes(pStack.pop(), pStack);
                } else if (pStack.peek().val > qStack.peek().val) {
                    System.out.println(qStack.peek().val);
                    addNextNodes(qStack.pop(), qStack);
                } else {
                    System.out.println(qStack.pop().val);
                    addNextNodes(pStack.pop(), pStack);
                    addNextNodes(qStack.pop(), qStack);
                }
            } else if (!pStack.isEmpty()) {
                System.out.println(pStack.peek().val);
                addNextNodes(pStack.pop(), pStack);
            } else if (!qStack.isEmpty()) {
                System.out.println(qStack.peek().val);
                addNextNodes(qStack.pop(), qStack);
            }
        }
    }

    private static void addNextNodes(TreeNode root, Deque<TreeNode> stack) {
        if (null == root || null == stack)
            return;

        if (null != root.right) {
            root = root.right;
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
        }
    }
}
