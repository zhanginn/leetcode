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

public class _22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new _22GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            String tempStr = "", one = "()";
            List<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tempStr += one;
            }
            result.add(tempStr);
            String[] strArray = new String[2 * n];
            for (int i = 0; i < tempStr.length(); i++) {
                strArray[i] = tempStr.substring(i, i + 1);
            }
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i].equals("(")) {
                    continue;
                }
                if (i + 1 < strArray.length) {
                    String temp = strArray[i];
                    strArray[i] = strArray[i + 1];
                    strArray[i + 1] = temp;
                    String subStr = "";
                    for (int j = 0; j < strArray.length; j++) {
                        subStr += strArray[j];
                    }
                    if (!result.contains(subStr)) {
                        result.add(subStr);
                    }

                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}