//给定一个包含非负整数的 m x n 网格 grid ，
// 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 905 👎 0

package leetcode.editor.cn;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int minPathSum(int[][] grid) {
//            int[][] dp = new int[grid.length + 1][grid[0].length + 1];
//            return process(grid, 0, 0);
//        }
//
//        public int process(int[][] arr, int i, int j) {
//            int p1 = Integer.MAX_VALUE, p2 = Integer.MAX_VALUE;
//            if (i + 1 < arr.length) {
//                p1 = arr[i][j] + process(arr, i + 1, j);
//            }
//            if (j + 1 < arr[0].length) {
//                p2 = arr[i][j] + process(arr, i, j + 1);
//            }
//            if (p1 == Integer.MAX_VALUE && p2 == Integer.MAX_VALUE) {
//                return arr[i][j];
//            }
//            return Math.min(p1, p2);
//        }

        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length + 1][grid[0].length + 1];
            return process(grid, 0, 0, dp);
        }

        public int process(int[][] arr, int i, int j, int[][] dp) {
            if (dp[i][j] != 0) return dp[i][j];
            int p1 = Integer.MAX_VALUE, p2 = Integer.MAX_VALUE;
            if (i + 1 < arr.length) {
                p1 = arr[i][j] + process(arr, i + 1, j, dp);
            }
            if (j + 1 < arr[0].length) {
                p2 = arr[i][j] + process(arr, i, j + 1, dp);
            }
            if (p1 == Integer.MAX_VALUE && p2 == Integer.MAX_VALUE) {
                dp[i][j] = arr[i][j];
                return dp[i][j];
            }
            dp[i][j] = Math.min(p1, p2);
            return dp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}