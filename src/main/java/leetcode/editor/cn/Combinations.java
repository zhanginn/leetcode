//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 607 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            List<Integer> sub = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            process(arr, 0, k, sub, ans);
            return ans;
        }

        public void process(int[] arr, int index, int k, List<Integer> sub, List<List<Integer>> ans) {
            if (index == arr.length) {
                if (k == sub.size()) {
                    ans.add(new ArrayList<>(sub));
                }
                return;
            }
            process(arr, index + 1, k, sub, ans);
            sub.add(arr[index]);
            process(arr, index + 1, k, sub, ans);
            sub.remove(Integer.valueOf(arr[index]));
        }
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}