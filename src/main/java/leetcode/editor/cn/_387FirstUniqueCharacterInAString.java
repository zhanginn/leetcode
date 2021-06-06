//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。
// 如果不存在，则返回 -1。
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 399 👎 0

package leetcode.editor.cn;

public class _387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new _387FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("aabb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            char[] c = s.toCharArray();
            int ans = -1;
            int[] dp = new int[26];
            flag:
            for (int i = 0; i < c.length; i++) {
                if (dp[c[i] - 'a'] != 0) {
                    continue;
                }
                for (int j = i + 1; j < c.length; j++) {
                    if (c[i] == c[j]) {
                        dp[c[i] - 'a']++;
                        continue flag;
                    }
                }
                return i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}