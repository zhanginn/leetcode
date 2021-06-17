//给定一个整数，将其转化为7进制，并以字符串形式输出。 
//
// 示例 1: 
//
// 
//输入: 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: -7
//输出: "-10"
// 
//
// 注意: 输入范围是 [-1e7, 1e7] 。 
// 👍 87 👎 0

package leetcode.editor.cn;

public class Base7 {
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
        System.out.println(solution.convertToBase7(-7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return String.valueOf(num);
            }
            String flag = num < 0 ? "-" : "";
            num = num < 0 ? num * (-1) : num;
            StringBuilder ans = new StringBuilder();
            while (num != 0) {
                ans.append(num % 7);
                num /= 7;
            }
            return flag + ans.reverse();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}