//给定一个无重复元素的数组 candidates 和一个目标数 target ，
// 找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1337 👎 0

package leetcode.editor.cn;

import java.util.*;

public class _39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new _39CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
                int sum = candidates[i];
                List<Integer> tempList = new ArrayList<>();
                tempList.add(candidates[i]);
                if (candidates[i] == target) {
                    if (!result.contains(tempList)) {
                        result.add(tempList);
                    }
                    break;
                }
                while (sum < target) {
                    for (int j = 0; j < candidates.length && candidates[j] <= target; j++) {
                        List<Integer> subList = new ArrayList<>();
                        if (sum == target) {
                            subList.add(candidates[j]);
                            if (!result.contains(subList)) {
                                result.add(subList);
                            }
                            break;
                        }
                        if (sum + candidates[j] == target) {
                            subList.addAll(tempList);
                            subList.add(candidates[j]);
                            Collections.sort(subList);
                            if (!result.contains(subList)) {
                                result.add(subList);
                            }
                            break;
                        }
                    }
                    sum += candidates[i];
                    tempList.add(candidates[i]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}