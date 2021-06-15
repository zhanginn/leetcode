//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 158 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("hello"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] c = s.toCharArray();
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');
            int l = 0, r = c.length - 1;
            while (l < r) {
                while (l < r && !set.contains(c[r])) {
                    r--;
                }
                while (l < r && !set.contains(c[l])) {
                    l++;
                }
                swap(c, l, r);
                l++;
                r--;
            }
            return String.valueOf(c);
        }

        public void swap(char[] s, int i, int j) {
            if (i == j) {
                return;
            }
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}