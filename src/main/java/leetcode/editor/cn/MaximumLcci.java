//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。 
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 数学 
// 👍 86 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumLcci {
    public static void main(String[] args) {
        Solution solution = new MaximumLcci().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximum(int a, int b) {
            int[] c = new int[]{a, b};
            Arrays.sort(c);
            return c[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}