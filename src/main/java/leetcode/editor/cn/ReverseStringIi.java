//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起
// 的每隔 2k 个字符的前 k 个字符进行反转。
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 双指针 字符串 
// 👍 130 👎 0

package leetcode.editor.cn;

public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcdefg", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            if (s == null || s.length() < 2) {
                return s;
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i += k * 2) {
                ans.append(swap(s.substring(i, Math.min(i + k, s.length()))));
                if (ans.length() == s.length()) {
                    break;
                }
                ans.append(s, i + k, Math.min(i + k * 2, s.length()));
            }
            return ans.toString();
        }

        public String swap(String s) {
            char[] c = s.toCharArray();
            StringBuilder sBuilder = new StringBuilder();
            for (int i = c.length - 1; i >= 0; i--) {
                sBuilder.append(c[i]);
            }
            return sBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}