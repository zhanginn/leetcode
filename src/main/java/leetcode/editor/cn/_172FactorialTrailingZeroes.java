//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 466 👎 0

package leetcode.editor.cn;

public class _172FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new _172FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            if (n == 0) {
                return 0;
            }
            int ans = 0;
            while (n / 5 > 0) {
                ans += n / 5;
                n /= 5;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}