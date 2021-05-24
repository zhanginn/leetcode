//给定一个数组 candidates 和一个目标数 target ，
// 找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 587 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new _40CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            process(candidates, target, 0, new ArrayList<>(), ans);
            return ans;
        }

        public int process(int[] arr, int target, int i, List<Integer> tempArr
                , List<List<Integer>> ans) {
            if (i == arr.length) {
                return 0;
            }
            int sum = process(arr, target, i + 1, tempArr, ans);
            if (sum == target) {
                ans.add(tempArr);
            }
            if (sum <= target) {
                if (sum + arr[i] == target) {
                    tempArr.add(arr[i]);
                    ans.add(tempArr);
                }
                if (sum + arr[i] < target) {
                    process(arr, target, i + 1, tempArr, ans);
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}