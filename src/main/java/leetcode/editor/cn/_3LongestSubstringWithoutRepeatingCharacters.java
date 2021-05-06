package leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5404 👎 0

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new _3LongestSubstringWithoutRepeatingCharacters().new Solution();
//        System.out.println(solution.lengthOfLongestSubstring(null));//0
//        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));//abc
//        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));//b
//        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));//wke
//        System.out.println(solution.lengthOfLongestSubstring("dvdf"));//vdf
//        System.out.println(solution.lengthOfLongestSubstring("anviaj"));//nviaj
        System.out.println(solution.lengthOfLongestSubstring("jbpnbwwd"));//jbpn
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.equals("")) {
                return 0;
            }
            //递归
            return findMaxStr(s).length();
            //指针
//            // 哈希集合，记录每个字符是否出现过
//            Set<Character> occ = new HashSet<>();
//            int n = s.length();
//            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
//            int rk = -1, ans = 0;
//            for (int i = 0; i < n; ++i) {
//                if (i != 0) {
//                    // 左指针向右移动一格，移除一个字符
//                    occ.remove(s.charAt(i - 1));
//                }
//                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
//                    // 不断地移动右指针
//                    occ.add(s.charAt(rk + 1));
//                    ++rk;
//                }
//                // 第 i 到 rk 个字符是一个极长的无重复字符子串
//                ans = Math.max(ans, rk - i + 1);
//            }
//            return ans;
        }

        //        private StringBuilder findMaxStr(String s) {
//            StringBuilder maxStr = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                if (maxStr.toString().contains(s.substring(i, i + 1))) {
//                    String subStr;
//                    if (maxStr.substring(maxStr.length() - 1).equals(s.substring(i, i + 1))) {
//                        subStr = findMaxStr(s.substring(i)).toString();
//                    } else {
//                        subStr = findMaxStr(s.substring(1)).toString();
//                    }
//
//                    if (maxStr.length() > subStr.length()) {
//                        return maxStr;
//                    } else {
//                        return new StringBuilder(subStr);
//                    }
//                }
//                maxStr.append(s, i, i + 1);
//            }
//            return maxStr;
//        }
        private String findMaxStr(String s) {
            String maxStr = "";
            String tempStr = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (tempStr.contains(s.substring(j, j + 1))) {
                        break;
                    }
                    tempStr += s.substring(j, j + 1);
                }
                if (tempStr.length() > maxStr.length()) {
                    maxStr = tempStr;
                }
                tempStr = "";
            }
            return maxStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}