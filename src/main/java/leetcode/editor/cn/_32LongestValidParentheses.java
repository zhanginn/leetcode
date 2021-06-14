//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）
// 括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1330 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class _32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new _32LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Character> stack = new Stack<>();
            char[] c = s.toCharArray();
            int tmp = 0, max = 0;
            for (char value : c) {
                if (value == '(') {
                    stack.push(value);
                    tmp = 0;
                } else {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        tmp += 2;
                        max = Math.max(max, tmp);
                    } else {
                        stack.push(value);
                        tmp = 0;
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}