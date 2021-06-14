//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 464 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class _97InterleavingString {
    public static void main(String[] args) {
        Solution solution = new _97InterleavingString().new Solution();
        System.out.println(solution.isInterleave("a", "b", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.equals("")) return s2.equals(s3);
            if (s2.equals("")) return s1.equals(s3);
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            char[] c3 = s3.toCharArray();
            process(c1, c2, c3, 0, 0, 0);
            return flag;
        }

        public boolean flag = false;

        public void process(char[] s1, char[] s2, char[] s3, int i1, int i2, int i3) {
            if ((s1 == null || s1.length == 0)
                    && (s2 == null || s2.length == 0)
                    && (s3 == null || s3.length == 0)) {
                flag = true;
                return;
            }
            if ((s1 == null || s1.length == 0)
                    && (s2 == null || s2.length == 0)) {
                return;
            }
            if (i3 == s3.length) {
                flag = i1 == s1.length && i2 == s2.length;
                return;
            }
            if ((i1 == s1.length && s3[i3] != s2[i2])
                    || (i2 == s2.length && s3[i3] != s1[i1])) {
                return;
            }
            if (s3[i3] != s1[i1] && s3[i3] != s2[i2]) {
                return;
            }
            if (s3[i3] == s1[i1]) {
                process(s1, s2, s3, i1 + 1, i2, i3 + 1);
            }
            if (s3[i3] == s2[i2]) {
                process(s1, s2, s3, i1, i2 + 1, i3 + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}