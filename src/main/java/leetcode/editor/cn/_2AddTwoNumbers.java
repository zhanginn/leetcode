//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6187 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

public class _2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new _2AddTwoNumbers().new Solution();
        int[] a = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] b = new int[]{9, 9, 9, 9};
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        for (int i = 0; i < a.length; i++) {
            l1.val = a[i];
            if (i + 1 < a.length) {
                l1.next = new ListNode();
            }
            l1 = l1.next;
        }
        for (int i = 0; i < b.length; i++) {
            l2.val = b[i];
            if (i + 1 < b.length) {
                l2.next = new ListNode();
            }
            l2 = l2.next;
        }
        System.out.println(solution.addTwoNumbers(l1Head, l2Head));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     */

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int lastAdd = 0, nextAdd = 0;
            ListNode l3 = new ListNode();
            ListNode head = l3;
            int a1 = 0, a2 = 0;
            while (l1 != null || l2 != null) {
                a1 = l1 != null ? l1.val : 0;
                a2 = l2 != null ? l2.val : 0;
                lastAdd = nextAdd;
                nextAdd = (a1 + a2 + nextAdd) / 10;
                if (lastAdd == 0) {
                    l3.val = (a1 + a2) % 10;
                } else {
                    l3.val = (a1 + a2 + lastAdd) % 10;
                }
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
                if (l1 != null || l2 != null) {
                    l3.next = new ListNode();
                    l3 = l3.next;
                }
            }
            if (nextAdd == 1) {
                l3.next = new ListNode(1);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}