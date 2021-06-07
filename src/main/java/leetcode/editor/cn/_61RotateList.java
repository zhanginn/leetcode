//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 570 👎 0

package leetcode.editor.cn;

public class _61RotateList {
    public static void main(String[] args) {
        Solution solution = new _61RotateList().new Solution();
        System.out.println(solution.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head;
            ListNode tail = null;
            int length = 0;
            while (cur != null) {
                length++;
                cur = cur.next;
            }
            k = k % length;
            if (k == 0) {
                return head;
            }
            int front = length - k;
            cur = head;
            for (int i = 0; i < front; i++) {
                cur = cur.next;
            }
            tail = cur;
            for (int i = 0; i < k - 1; i++) {
                tail = tail.next;
            }
            tail.next = head;
            for (int i = 0; i < front; i++) {
                tail = tail.next;
            }
            tail.next = null;
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}