//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 302 👎 0

package leetcode.editor.cn;

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            char[] c = s.toCharArray();
            int[] arr = new int[58];
            for (char value : c) {
                arr[value - 'A']++;
            }
            int count = 1;
            int ans = 0;
            for (int j : arr) {
                if (j % 2 == 0) {
                    ans += j;
                } else {
                    if (j > 2) {
                        ans += j - 1;
                    }
                    count--;
                    if (count >= 0) {
                        ans += 1;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}