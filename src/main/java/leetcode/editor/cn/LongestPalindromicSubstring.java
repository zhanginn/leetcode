//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3722 👎 0

package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
//        "babad".substring(2,2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            String tmp = "", ans = "";
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                tmp = process(c, i);
                if (tmp.length() > ans.length()) {
                    ans = tmp;
                }
            }
            return ans;
        }

        public String process(char[] c, int index) {
            int i = index, j = index;
            while (j < c.length - 1 && c[i] == c[j + 1]) {
                j++;
            }
            while (i > 0 && j < c.length - 1) {
                if (c[i - 1] != c[j + 1]) {
                    break;
                }
                i--;
                j++;
            }
            return String.valueOf(c, i, j - i + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}