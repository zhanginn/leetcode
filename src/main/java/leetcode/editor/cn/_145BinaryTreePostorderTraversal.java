//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 591 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _145BinaryTreePostorderTraversal().new Solution();
        System.out.println(solution);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        process(root, ans);
        return ans;
    }
    public void process(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            process(root.left, ans);
        }
        if (root.right != null) {
            process(root.right, ans);
        }
        ans.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}