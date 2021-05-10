package leetcode.editor.cn;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 911 👎 0

public class _35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new _35SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            //递归
//            return inWhere(nums, 0, nums.length - 1, target);
            //循环遍历
            int left = 0, right = nums.length - 1, mid, result = nums.length;
            while (left < right) {
                mid = ((right - left) >> 1) + left;
                if (nums[mid] >= target) {
                    result = mid;
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return result;
        }

        public int inWhere(int[] nums, int left, int right, int target) {
            int mid = (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (right - left == 1) {
                if (nums[left] > target) {
                    return left;
                } else if (nums[right] < target) {
                    return right + 1;
                } else if (nums[left] < target
                        && nums[right] > target) {
                    return right;
                }
            } else if (nums[mid] > target) {
                return inWhere(nums, left, mid, target);
            } else if (nums[mid] < target) {
                return inWhere(nums, mid + 1, right, target);
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}