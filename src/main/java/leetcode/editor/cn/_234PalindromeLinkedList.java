//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 996 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class _234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new _234PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(new ListNode(1, new ListNode(0, new ListNode(1)))));
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
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
//            int length = 0;
//            ListNode cur = head;
//            while (cur != null) {
//                length++;
//                cur = cur.next;
//            }
//            int mid = length / 2;
//            cur = head;
//            int count = 0;
//            Stack<ListNode> stack = new Stack<>();
//            while (count < mid) {
//                stack.push(cur);
//                cur = cur.next;
//                count++;
//            }
//            if ((length & 1) == 1) {
//                cur = cur.next;
//            }
//            while (cur != null) {
//                if (cur.val != stack.pop().val) {
//                    return false;
//                }
//                cur = cur.next;
//            }
//            return stack.isEmpty();
            ListNode cur = head;
            Stack<ListNode> stack = new Stack<>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            while (head != null) {
                if (stack.pop().val != head.val) {
                    return false;
                }
                head = head.next;
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}