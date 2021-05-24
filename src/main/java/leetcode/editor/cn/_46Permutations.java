//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1339 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _46Permutations {
    public static void main(String[] args) {
        Solution solution = new _46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            process(nums, 0, ans);
            return ans;
        }

        public void process(int[] arr, int i, List<List<Integer>> ans) {
            if (i == arr.length) {
                List<Integer> cur = new ArrayList<>();
                for (int num : arr) {
                    cur.add(num);
                }
                ans.add(cur);
            }
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                process(arr, i + 1, ans);
                swap(arr, i, j);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}