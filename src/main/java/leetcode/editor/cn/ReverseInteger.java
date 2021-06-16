//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2864 👎 0

package leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(-2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long xx = x;
            int flag = xx < 0 ? (-1) : 1;
            xx = Math.abs(xx);
            char[] c = String.valueOf(xx).toCharArray();
            char[] a = new char[c.length];
            long ans;
            for (int i = c.length - 1, j = 0; i >= 0; i--, j++) {
                a[j] = c[i];
            }
            ans = Long.parseLong(String.valueOf(a));
            if (ans > Integer.MAX_VALUE) {
                return 0;
            }
            return flag * (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}