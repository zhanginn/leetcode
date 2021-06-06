//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 87 👎 0

package leetcode.editor.cn;

public class _434NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new _434NumberOfSegmentsInAString().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            if (s == null || s.equals("") || s.trim().equals("")) {
                return 0;
            }
            char[] c = s.trim().toCharArray();
            int count = 0;
            for (char value : c) {
                if (value == ' ') {
                    count++;
                }
            }
            return count + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}