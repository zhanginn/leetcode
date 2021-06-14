//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1104 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class _41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new _41FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >0) {
                set.add(nums[i]);
            }
        }
        int j=0;
        for (int i = 1; i < nums.length+1; i++) {
            if (!set.contains(i)) {
                return i;
            }
            j=i;
        }
        return j+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}