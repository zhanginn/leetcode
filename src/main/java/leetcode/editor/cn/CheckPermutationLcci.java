//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，
// 能否变成另一个字符串。
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 36 👎 0

package leetcode.editor.cn;

public class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int[] arr = new int[26];
            for (char c : c1) {
                arr[c - 'a']++;
            }
            for (char c : c2) {
                if (--arr[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}