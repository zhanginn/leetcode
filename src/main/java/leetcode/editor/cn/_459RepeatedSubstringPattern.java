//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成
// 。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 498 👎 0

package leetcode.editor.cn;

public class _459RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new _459RepeatedSubstringPattern().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            for (int i = 1; i < s.length() / 2 + 1; i++) {
                if (s.replace(s.substring(0, i), "").equals("")) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}