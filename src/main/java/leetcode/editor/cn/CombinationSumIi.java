//给定一个数组 candidates 和一个目标数 target
// ，找出 candidates 中所有可以使数字和为 target 的组合。
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
// 👍 609 👎 0

package leetcode.editor.cn;

import java.util.*;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int sum = 0;
            for (int candidate : candidates) {
                sum += candidate;
            }
            if (sum < target) {
                return new ArrayList<>();
            }
            Set<List<Integer>> set = new HashSet<>();
            List<Integer> sub = new ArrayList<>();
            process(candidates, 0, target, sub, set);
            return new ArrayList<>(set);
        }

        public void process(int[] arr, int index, int rest, List<Integer> sub, Set<List<Integer>> set) {
            if (index == arr.length) {
                int[] tmp = new int[sub.size()];
                for (int i = 0; i < sub.size(); i++) {
                    tmp[i] = sub.get(i);
                }
                Arrays.sort(tmp);
                List<Integer> sub1 = new ArrayList<>();
                for (int j : tmp) {
                    sub1.add(j);
                }
                if (rest == 0) {
                    set.add(sub1);
                }
                return;
            }
            if (arr[index] > rest) {
                process(arr, index + 1, rest, sub, set);
            } else {
                process(arr, index + 1, rest, sub, set);
                sub.add(arr[index]);
                process(arr, index + 1, rest - arr[index], sub, set);
                sub.remove(Integer.valueOf(arr[index]));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}