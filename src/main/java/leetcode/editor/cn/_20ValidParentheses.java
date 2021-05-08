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

public class _20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new _20ValidParentheses().new Solution();
//        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("){"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) return false;
            char a1 = '(', a2 = ')', b1 = '[', b2 = ']', c1 = '{', c2 = '}';
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char tempStr = s.charAt(i);
                if (tempStr == a1) deque.push(s.charAt(i));
                else if (tempStr == a2) {
                    if (deque.isEmpty() || deque.peek() != a1) {
                        return false;
                    }
                    deque.pop();
                } else if (tempStr == b1) deque.push(s.charAt(i));
                else if (tempStr == b2) {
                    if (deque.isEmpty() || deque.peek() != b1) {
                        return false;
                    }
                    deque.pop();
                } else if (tempStr == c1) deque.push(s.charAt(i));
                else if (tempStr == c2) {
                    if (deque.isEmpty() || deque.peek() != c1) {
                        return false;
                    }
                    deque.pop();
                }
            }
            return deque.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}