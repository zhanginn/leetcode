//给定一个按照升序排列的整数数组 nums，和一个目标值 target。
// 找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1017 👎 0

package leetcode.editor.cn;

public class _34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new _34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};
            if (nums.length > 0) {
                process(nums, 0, nums.length - 1, target, ans);
            }
            return ans;
        }

        public void process(int[] nums, int L, int R, int target, int[] ans) {
            if (nums[L] == target && (ans[0] == -1 || ans[0] > L)) {
                ans[0] = L;
            }
            if (nums[R] == target && ans[1] < R) {
                ans[1] = R;
            }
            if (L == R) {
                return;
            }
            int mid = L + ((R - L) >> 1);
            if (nums[mid] == target) {
                process(nums, L, mid, target, ans);
                process(nums, mid + 1, R, target, ans);
            } else if (nums[mid] > target) {
                process(nums, L, mid, target, ans);
            } else if (nums[mid] < target) {
                process(nums, mid + 1, R, target, ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}