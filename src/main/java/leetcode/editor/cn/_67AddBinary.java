//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 607 👎 0

package leetcode.editor.cn;

public class _67AddBinary {
    public static void main(String[] args) {
        Solution solution = new _67AddBinary().new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
//        System.out.println(solution.dec2Bin("36"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int sumDec = Integer.parseInt(bin2Dec(a)) + Integer.parseInt(bin2Dec(b));
            return dec2Bin(String.valueOf(sumDec));
        }

        public String bin2Dec(String a) {
            int result = 0;
            for (int i = a.length(); i > 0; i--) {
                result += Integer.parseInt(a.substring(i - 1, i)) * Math.pow(2, i);
            }
            return String.valueOf(result);
        }

        public String dec2Bin(String a) {
            String result = "";
            int tempInt = Integer.parseInt(a);
            while (tempInt > 0) {
                if (tempInt % 2 == 0) {
                    result = "0" + result;
                } else {
                    result = "1" + result;
                }
                tempInt /= 2;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}