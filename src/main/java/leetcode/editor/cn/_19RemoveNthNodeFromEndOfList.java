//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1368 👎 0

package leetcode.editor.cn;

public class _19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new _19RemoveNthNodeFromEndOfList().new Solution();
        int[] a = new int[]{1};
        ListNode l1 = new ListNode();
        ListNode l1Head = l1;
        for (int i = 0; i < a.length; i++) {
            l1.val = a[i];
            if (i + 1 < a.length) {
                l1.next = new ListNode();
                l1 = l1.next;
            }
        }
        int b = 1;
        System.out.println(solution.removeNthFromEnd(l1Head, b));
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head;
            ListNode temp = head;
            for (int i = 0; head != null; i++) {
                temp = head;
                for (int j = 0; j <= n; j++) {
                    temp = temp.next;
                    if (j == n && temp == null) {
                        head.next = head.next.next;
                        return node;
                    }
                    if (j == n - 1 && temp == null) {
                        node = head.next;
                        return node;
                    }
                }
                head = head.next;
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}