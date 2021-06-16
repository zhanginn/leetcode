//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串
// ，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，
// 组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 154 👎 0

package leetcode.editor.cn;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        System.out.println(solution.canConstruct("aa", "aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (magazine == null) {
                return false;
            }
            if (ransomNote == null) {
                return true;
            }
            if (magazine.length() < ransomNote.length()) {
                return false;
            }
            char[] m = magazine.toCharArray();
            char[] r = ransomNote.toCharArray();
            int[] arr = new int[26];
            for (char c : m) {
                arr[c - 'a']++;
            }
            for (char c : r) {
                if (--arr[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}