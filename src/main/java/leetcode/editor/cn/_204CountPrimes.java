//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 695 👎 0

package leetcode.editor.cn;

public class _204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new _204CountPrimes().new Solution();
        System.out.println(solution.countPrimes(100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            if (n < 3) {
                return 0;
            }
            //false代表素数，true代表非素数
            boolean[] flags = new boolean[n];
            //0不是素数
            flags[0] = true;
            //1不是素数
            flags[1] = true;
            int num = n - 2;
            int sqrt = (int) Math.sqrt(n);
            for (int i = 2; i <= (int) Math.sqrt(n); i++) {
                //当i为素数时，i的所有倍数都不是素数
                if (!flags[i]) {
                    for (int j = 2 * i; j < n; j += i) {
                        if (!flags[j]) {
                            flags[j] = true;
                            num--;
                        }
                    }
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}