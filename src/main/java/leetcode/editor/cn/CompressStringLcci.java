//字符串压缩。利用字符重复出现的次数，编写一种方法，
// 实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
//
// 示例1: 
//
// 
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
// 
//
// 示例2: 
//
// 
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 50000]范围内。 
// 
// Related Topics 字符串 
// 👍 88 👎 0

package leetcode.editor.cn;

public class CompressStringLcci {
    public static void main(String[] args) {
        Solution solution = new CompressStringLcci().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String compressString(String S) {
            if (S == null || S.equals("")) {
                return S;
            }
            int count = 1;
            String tmp = S.substring(0, 1);
            StringBuilder ans = new StringBuilder();
            char[] c = S.toCharArray();
            for (int i = 1; i < c.length; i++) {
                if (c[i] == c[i - 1]) {
                    count++;
                } else {
                    ans.append(tmp).append(count);
                    tmp = String.valueOf(c[i]);
                    count = 1;
                }
            }
            ans.append(tmp).append(count);
            return ans.length() >= S.length() ? S : ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}