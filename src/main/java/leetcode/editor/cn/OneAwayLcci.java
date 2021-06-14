//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
// 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 75 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        System.out.println(solution.oneEditAway("islander", "slander"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (Math.abs(first.length() - second.length()) > 1) {
                return false;
            }
            if (first.equals("") || second.equals("") || first.length() == 1 || second.length() == 1
                    || first.replace(second, "").length() <= 1 || second.replace(first, "").length() <= 1) {
                return true;
            }
            if (first.length() > second.length()) {
                second += " ";
            } else if (first.length() < second.length()) {
                first += " ";
            }
            char[] c1 = first.toCharArray();
            char[] c2 = second.toCharArray();
            int count = 0, i2 = 0;
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i2]) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                    if (i2 + 1 < c1.length && c1[i] == c2[i2 + 1]) {
                        i2++;
                        continue;
                    }
                    if (i + 1 < c1.length && i2 + 1 < c1.length && c1[i + 1] == c2[i2 + 1]) {
                        i2++;
                        continue;
                    }
                    if (i + 1 < c1.length && c1[i + 1] == c2[i2]) {
                        continue;
                    }
                }
                i2++;
            }
            if (count == 1 && c1[c1.length - 1] != c2[i2]) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}