//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
// 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 277 👎 0

package leetcode.editor.cn;

import java.util.*;

public class _219ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new _219ContainsDuplicateIi().new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < i + 1 + k && j < nums.length; j++) {
//                    if (nums[i] == nums[j]) {
//                        return true;
//                    }
//                }
//            }
//            return false;
            LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
            for (int i = 0; i < k + 1; i++) {
                linkedHashSet.add(nums[i]);
            }
            if (linkedHashSet.size() <= k) {
                return true;
            }
            for (int i = k + 1; i < nums.length; i++) {
                linkedHashSet.remove(nums[i - k - 1]);
                linkedHashSet.add(nums[i]);
                if (linkedHashSet.size() <= k) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}