//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 381 👎 0

package leetcode.editor.cn;

public class _415AddStrings {
    public static void main(String[] args) {
        Solution solution = new _415AddStrings().new Solution();
        System.out.println(solution.addStrings("123", "123"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            String l = num1.length() > num2.length() ? num1 : num2;
            String s = l.equals(num1) ? num2 : num1;
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < l.length() - s.length(); i++) {
                tmp.append("0");
            }
            s = tmp + s;
            char[] ll = l.toCharArray();
            char[] ss = s.toCharArray();
            int lastAdd = 0;
            for (int i = ll.length - 1; i >= 0; i--) {
                int add = ll[i] - '0' + ss[i] - '0' + lastAdd;
                ll[i] = (char) ((add % 10) + '0');
                if (add > 9) {
                    lastAdd = 1;
                } else {
                    lastAdd = 0;
                }
            }
            StringBuilder ans = new StringBuilder();
            for (char c : ll) {
                ans.append(c);
            }
            return lastAdd == 1 ? "1" + ans : ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}