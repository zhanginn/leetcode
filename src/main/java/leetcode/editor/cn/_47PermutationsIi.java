//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 705 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new _47PermutationsIi().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            process(nums, 0, ans);
            return ans;
        }

        public void process(int[] arr, int index, List<List<Integer>> ans) {
            if (index == arr.length) {
                List<Integer> cur = new ArrayList<>();
                for (int num : arr) {
                    cur.add(num);
                }
                if (!ans.contains(cur)) {
                    ans.add(cur);
                }
            }
            for (int i = index; i < arr.length; i++) {
                swap(arr, i, index);
                process(arr, index + 1, ans);
                swap(arr, i, index);
            }
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}