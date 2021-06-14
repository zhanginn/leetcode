//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
// 答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1349 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new _17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.equals("")) {
                return new ArrayList<>();
            }
            char[] c = digits.toCharArray();
            List<String> ans = new ArrayList<>();
            char[] path = new char[digits.length()];
            process(c, 0, path, ans);
            return ans;
        }

        public char[][] phone = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        public void process(char[] str, int index, char[] path, List<String> ans) {
            if (index == str.length) {
                StringBuilder tmpStr = new StringBuilder();
                for (char tmp : path) {
                    tmpStr.append(tmp);
                }
                ans.add(tmpStr.toString());
                return;
            }
            for (char tmp : phone[str[index] - '2']) {
                path[index] = tmp;
                process(str, index + 1, path, ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}