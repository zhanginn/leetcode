//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，
// 可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 384 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class _125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new _125ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("a."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.equals("") || s.length() == 1) {
                return true;
            }
            s = s.toLowerCase();
            char[] c = s.toCharArray();
            StringBuilder ans = new StringBuilder();
            for (char value : c) {
                if ((value >= '0' && value <= '9')
                        || value >= 'a' && value <= 'z') {
                    ans.append(value);
                }
            }
            if (ans.toString().equals("") || ans.length() == 1) {
                return true;
            }
            c = ans.toString().toCharArray();
            int start;
            if (c.length % 2 == 0) {
                start = c.length / 2;
            } else {
                start = c.length / 2 + 1;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = start; i < c.length; i++) {
                stack.push(c[i]);
            }
            for (int i = 0; i < start; i++) {
                if (c[i] != stack.pop()) {
                    return false;
                }
                if (stack.isEmpty()) {
                    return true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}