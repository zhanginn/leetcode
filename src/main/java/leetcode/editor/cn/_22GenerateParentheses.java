package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1770 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new _22GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            process(new char[n << 1], 0, ans);
            return ans;
        }

        public void process(char[] path, int index, List<String> ans) {
            if (index == path.length) {
                if (isValid(path)) {
                    ans.add(String.valueOf(path));
                }
                return;
            }
            path[index] = '(';
            process(path, index + 1, ans);
            path[index] = ')';
            process(path, index + 1, ans);
        }

        public boolean isValid(char[] path) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < path.length; i++) {
                if (path[i] == '(') {
                    stack.push(path[i]);
                }
                if (path[i] == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}