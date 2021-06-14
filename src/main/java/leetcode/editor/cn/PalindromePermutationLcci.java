//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 52 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

public class PalindromePermutationLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            if (s == null || s.equals("")) {
                return true;
            }
            HashSet<Character> hashSet = new HashSet<>();
            char[] c = s.toCharArray();
            for (char value : c) {
                if (hashSet.contains(value)) {
                    hashSet.remove(value);
                } else {
                    hashSet.add(value);
                }
            }
            return hashSet.size() <= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}