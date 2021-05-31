package leetcode.editor.cn;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
// 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
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
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[0] > target) {
                return 0;
            } else if (nums[nums.length - 1] < target) {
                return nums.length;
            }
            return process(nums, target, 0, nums.length - 1);
        }

        public int process(int[] arr, int target, int L, int R) {
            if (L == R) {
                return L;
            }
            int mid = L + ((R - L) >> 1);
            int ans = 0;
            if (arr[mid] >= target) {
                ans = process(arr, target, L, mid);
            } else if (arr[mid] < target) {
                ans = process(arr, target, mid + 1, R);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}