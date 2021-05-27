//给你一个整数数组 nums ，除某个元素仅出现 一次 外，
// 其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 
// 👍 667 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class _137SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new _137SingleNumberIi().new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i += 2;
                } else {
                    return nums[i];
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}