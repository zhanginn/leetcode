//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 745 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class _494TargetSum {
    public static void main(String[] args) {
        Solution solution = new _494TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            HashMap<String, Integer> dp = new HashMap<>();
            return process(nums, 0, target, dp);
        }

        public int process(int[] arr, int index, int rest, HashMap<String, Integer> dp) {
            if (index == arr.length) {
                return rest == 0 ? 1 : 0;
            }
            if (dp.containsKey(index + "|" + rest)) {
                return dp.get(index + "|" + rest);
            }
            dp.put((index + 1) + "|" + (rest - arr[index]), process(arr, index + 1, rest - arr[index], dp));
            int p1 = dp.get((index + 1) + "|" + (rest - arr[index]));
            dp.put((index + 1) + "|" + (rest + arr[index]), process(arr, index + 1, rest + arr[index], dp));
            int p2 = dp.get((index + 1) + "|" + (rest + arr[index]));
            return p1 + p2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}