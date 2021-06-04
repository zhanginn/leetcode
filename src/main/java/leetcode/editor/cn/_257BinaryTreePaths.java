//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 512 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new _257BinaryTreePaths().new Solution();
        System.out.println(solution.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
    }

    public static class TreeNode {
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
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            process(root, String.valueOf(root.val), ans);
            return ans;
        }

        public void process(TreeNode root, String path, List<String> ans) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                ans.add(path);
                return;
            }
            if (root.left != null) {
                String leftPath = path + "->" + root.left.val;
                process(root.left, leftPath, ans);
            }
            if (root.right != null) {
                String rightPath = path + "->" + root.right.val;
                process(root.right, rightPath, ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}