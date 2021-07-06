//夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。 
//
// 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，
// 其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coin
//s 现金可以用于消费，他想要买尽可能多的雪糕。 
//
// 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。 
//
// 注意：Tony 可以按任意顺序购买雪糕。 
//
// 
//
// 示例 1： 
//
// 输入：costs = [1,3,2,4,1], coins = 7
//输出：4
//解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
// 
//
// 示例 2： 
//
// 输入：costs = [10,6,8,7,7,8], coins = 5
//输出：0
//解释：Tony 没有足够的钱买任何一支雪糕。
// 
//
// 示例 3： 
//
// 输入：costs = [1,6,3,1,2,5], coins = 20
//输出：6
//解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
// 
//
// 
//
// 提示： 
//
// 
// costs.length == n 
// 1 <= n <= 105 
// 1 <= costs[i] <= 105 
// 1 <= coins <= 108 
// 
// Related Topics 贪心 数组 排序 
// 👍 34 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        Solution solution = new MaximumIceCreamBars().new Solution();
        System.out.println(solution.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int[][] dp = new int[coins + 1][costs.length + 1];
            return process(costs, coins, 0, dp);
        }

        public int process(int[] costs, int leftCoins, int index, int[][] dp) {
            if (dp[leftCoins][index] != 0) {
                return dp[leftCoins][index];
            }
            if (index == costs.length) {
                dp[leftCoins][index] = 0;
                return dp[leftCoins][index];
            }
            if (costs[index] > leftCoins) {
                dp[leftCoins][index] = 0;
                return dp[leftCoins][index];
            }
            int p1 = 0, p2 = 0;
            if (leftCoins >= costs[index]) {
                p1 = process(costs, leftCoins - costs[index], index + 1, dp) + 1;
            }
            p2 = process(costs, leftCoins, index + 1, dp);
            dp[leftCoins][index] = Math.max(p1, p2);
            return dp[leftCoins][index];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}