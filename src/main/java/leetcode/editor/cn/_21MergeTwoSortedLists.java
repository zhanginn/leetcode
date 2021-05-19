//将两个升序链表合并为一个新的 升序 链表并返回。
// 新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1710 👎 0

package leetcode.editor.cn;

public class _21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new _21MergeTwoSortedLists().new Solution();
        System.out.println(solution);
    }

    public class ListNode {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            ListNode l3 = new ListNode();
            ListNode l3Head = l3;
            Integer n1 = null, n2 = null;
            while (l1 != null || l2 != null) {
                n1 = l1 != null ? l1.val : null;
                n2 = l2 != null ? l2.val : null;
                if (n1 == null) {
                    l3.val = n2;
                    l2 = l2.next;
                } else if (n2 == null) {
                    l3.val = n1;
                    l1 = l1.next;
                } else {
                    l3.val = Math.min(n1, n2);
                    if (n1 <= n2) {
                        l1 = l1.next;
                    } else {
                        l2 = l2.next;
                    }
                }
                if (l1 != null || l2 != null) {
                    l3.next = new ListNode();
                    l3 = l3.next;
                }
            }
            return l3Head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}