//若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。 
//
// 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。 
//
// 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f 
//
// 
//
// 示例： 
//
// 
//输入：节点 5 （位于单向链表 4->5->1->9 中）
//输出：不返回任何数据，从链表中删除传入的节点 5，使链表变为 4->1->9
// 
//
// 
// Related Topics 链表 
// 👍 111 👎 0

package leetcode.editor.cn;

public class DeleteMiddleNodeLcci {
    public static void main(String[] args) {
        Solution solution = new DeleteMiddleNodeLcci().new Solution();
        solution.deleteNode(new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9)))));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
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
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {
//            if (node == null || node.next == null) {
//                node = null;
//            }
//            ListNode s1 = node;
//            ListNode s2 = node.next;
//            ListNode pre = null;
//            while (s2.next != null && s2.next.next != null) {
//                pre = s1;
//                s1 = s1.next;
//                s2 = s2.next.next;
//            }
//            pre.next = pre.next.next;
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}