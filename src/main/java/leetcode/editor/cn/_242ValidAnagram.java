//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 393 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class _242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new _242ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.equals(t)) {
                return true;
            }
            if (s.length() != t.length()) {
                return false;
            }
            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();
            int[] result = new int[26];
            for (int i = 0; i < s.length(); i++) {
                result[s1[i] - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                result[t1[i] - 'a']--;
                if (result[t1[i] - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}