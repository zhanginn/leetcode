package leetcode.editor.cn;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 840 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18FourSum {
    public static void main(String[] args) {
        Solution solution = new _18FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int length = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    for (int k = j + 1; k < length; k++) {
                        for (int l = k + 1; l < length; l++) {
                            int sum = nums[i] + nums[j] + nums[k] + nums[l];
                            if (sum > target) {
                                break;
                            }
                            if (sum == target) {
                                List<Integer> subList = new ArrayList<>();
                                subList.add(nums[i]);
                                subList.add(nums[j]);
                                subList.add(nums[k]);
                                subList.add(nums[l]);
                                if (!result.contains(subList)) {
                                    result.add(subList);
                                }
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}