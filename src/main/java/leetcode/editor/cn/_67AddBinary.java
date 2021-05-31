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

import java.util.Arrays;

public class _67AddBinary {
    public static void main(String[] args) {
        Solution solution = new _67AddBinary().new Solution();
        System.out.println(solution.addBinary("0", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int length = Math.min(a.length(), b.length());
            String prefix = "";
            int diff = Math.abs(a.length() - b.length());
            char[] a1;
            char[] b1;
            if (a.length() > b.length()) {
                prefix = a.substring(0, diff);
                a1 = a.substring(diff).toCharArray();
                b1 = b.toCharArray();
            } else if (b.length() > a.length()) {
                prefix = b.substring(0, diff);
                a1 = a.toCharArray();
                b1 = b.substring(diff).toCharArray();
            } else {
                a1 = a.toCharArray();
                b1 = b.toCharArray();
            }
            String ans = "";
            int lastAdd = 0;
            char[] charAns = new char[length];
            for (int i = length - 1; i >= 0; i--) {
                if (lastAdd == 0) {
                    if (a1[i] == '1' && b1[i] == '1') {
                        lastAdd = 1;
                        charAns[i] = '0';
                    } else if (a1[i] == '0' && b1[i] == '0') {
                        lastAdd = 0;
                        charAns[i] = '0';
                    } else {
                        lastAdd = 0;
                        charAns[i] = '1';
                    }
                } else {
                    if (a1[i] == '1' && b1[i] == '1') {
                        charAns[i] = '1';
                    } else if (a1[i] == '1' && b1[i] == '0') {
                        charAns[i] = '0';
                    } else if (a1[i] == '0' && b1[i] == '1') {
                        charAns[i] = '0';
                    } else if (a1[i] == '0' && b1[i] == '0') {
                        lastAdd = 0;
                        charAns[i] = '1';
                    }
                }
            }
            ans = String.valueOf(charAns);
            if (prefix.length() > 0) {
                if (lastAdd != 0) {
                    char[] c = prefix.toCharArray();
                    for (int i = c.length - 1; i >= 0; i--) {
                        if (c[i] == '0') {
                            c[i] = '1';
                            prefix = String.valueOf(c);
                            break;
                        }
                        c[i] = '0';
                        if (i == 0) {
                            prefix = "1" + String.valueOf(c);
                        }
                    }
                }
                ans = prefix + ans;
            } else {
                if (lastAdd != 0) {
                    ans = "1" + ans;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}