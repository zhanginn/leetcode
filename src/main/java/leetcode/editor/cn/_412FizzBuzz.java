//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 96 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _412FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new _412FizzBuzz().new Solution();
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                String tmp = "";
                if (i % 3 == 0) {
                    tmp = "Fizz";
                }
                if (i % 5 == 0) {
                    tmp += "Buzz";
                }
                if (i % 3 != 0 && i % 5 != 0) {
                    tmp = String.valueOf(i);
                }
                ans.add(tmp);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}