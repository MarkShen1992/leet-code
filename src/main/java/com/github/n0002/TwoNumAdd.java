package com.github.n0002;

/**
 * @author MarkShen
 * @since 20201027
 *        <p>
 *        请你将两个数相加，并以相同形式返回一个表示和的链表。 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *        来源：力扣（LeetCode）链接：https://leetcode-cn.com/problems/add-two-numbers
 *        <p>
 *        输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
 */
public class TwoNumAdd {

    public static void main(String[] args) {
        // construct data.
        Node node03 = new Node(3);
        Node node02 = new Node(4, node03);
        Node node01 = new Node(2, node02);

        Node node06 = new Node(4);
        Node node05 = new Node(6, node06);
        Node node04 = new Node(5, node05);

        // Node result = addTwoNumbers(node01, node04);
        // boolean flag = true;
        // while (flag) {
        // if (result.node == null) {
        // flag = false;
        // }
        // System.out.print(result.val);
        // }

        System.out.println(getNum(node01));

    }

    private static int getNum(Node node) {
        if (node == null) {
            return -1;
        }
        // 终止循环标识
        boolean flag = true;
        // 判断链表的第几个节点
        int i = 0;
        // 将返回的结果
        int result = 0;
        while (flag) {
            if (node.next == null) {
                flag = false;
            }
            result += node.val * Math.pow(10, i);
            node = node.next;
            i++;
        }
        return result;
    }

    private static Node addTwoNumbers(Node node01, Node node02) {
        int sum = getNum(node01) + getNum(node02);
        return generateNode(sum);
    }

    // TODO
    private static Node generateNode(int sum) {
        String sumStr = String.valueOf(sum);
        if (sumStr == null || sumStr.length() == 0) {
            return null;
        }
    }
}

class Node {

    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}