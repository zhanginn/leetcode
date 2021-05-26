//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1669 👎 0

package leetcode.editor.cn;

public class _70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new _70ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int[] cash = new int[n + 1];
            return process(n, cash);
        }

        public int process(int rest, int[] cash) {
            if (rest == 0) {
                return 1;
            }
            if (rest < 0) {
                return 0;
            }
            if (rest == 1 || rest == 2) {
                return rest;
            }
            if (cash[rest] != 0) {
                return cash[rest];
            }
            cash[rest - 1] = process(rest - 1, cash);
            cash[rest - 2] = process(rest - 2, cash);
            return cash[rest - 1] + cash[rest - 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}