//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，
// 第 k 行就必须正好有 k 枚硬币。
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找 
// 👍 108 👎 0

package leetcode.editor.cn;

public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
        System.out.println(solution.arrangeCoins(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            if (n == 0) {
                return 0;
            }
            int i = 1;
            while (true) {
                if (n >= i) {
                    n -= i;
                } else {
                    break;
                }
                i++;
            }
            return i - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}