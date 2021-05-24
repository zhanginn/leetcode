package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2381 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new _20ValidParentheses().new Solution();
//        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("){"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] str = s.toCharArray();
            for (int i = 0; i < str.length; i++) {
                switch (str[i]) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(str[i]);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') {
                            return false;
                        }
                        stack.pop();
                        break;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}