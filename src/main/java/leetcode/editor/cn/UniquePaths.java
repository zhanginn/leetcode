//一个机器人位于一个 m x n 网格的左上角
// （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 1020 👎 0

package leetcode.editor.cn;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            return process(m, n, dp);
        }

        public int process(int m, int n, int[][] dp) {
            if (dp[m][n] != 0) {
                return dp[m][n];
            }
            if (m == 1 && n == 1) {
                dp[m][n]++;
                return dp[m][n];
            }
            int p1 = 0, p2 = 0;
            if (m > 1) {
                dp[m - 1][n] = process(m - 1, n, dp);
                p1 = dp[m - 1][n];
            }
            if (n > 1) {
                dp[m][n - 1] = process(m, n - 1, dp);
                p2 = dp[m][n - 1];
            }
            return p1 + p2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}