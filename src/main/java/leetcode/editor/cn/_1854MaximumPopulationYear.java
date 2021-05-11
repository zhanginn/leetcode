//给你一个二维整数数组 logs ，
// 其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
//
// 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内
//。注意，人不应当计入他们死亡当年的人口中。 
//
// 返回 人口最多 且 最早 的年份。 
//
// 
//
// 示例 1： 
//
// 输入：logs = [[1993,1999],[2000,2010]]
//输出：1993
//解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
// 
//
// 示例 2： 
//
// 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
//输出：1960
//解释： 
//人口最多为 2 ，分别出现在 1960 和 1970 。
//其中最早年份是 1960 。 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 100 
// 1950 <= birthi < deathi <= 2050 
// 
// Related Topics 数组 
// 👍 5 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;

public class _1854MaximumPopulationYear {
    public static void main(String[] args) {
        Solution solution = new _1854MaximumPopulationYear().new Solution();
        System.out.println(
                solution.maximumPopulation(
                        new int[][]{{1960, 1971}, {1970, 1981}, {1950, 1961}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumPopulation(int[][] logs) {
            int minYear = logs[0][0];
            int maxYear = logs[0][1];
            for (int[] subArray : logs) {
                Arrays.sort(subArray);
                if (minYear > subArray[0]) {
                    minYear = subArray[0];
                }
                if (maxYear < subArray[1]) {
                    maxYear = subArray[1];
                }
            }
            int resultYear = minYear;
            int resultCount = 0;
            for (int i = minYear; i < maxYear; i++) {
                int count = 0;
                for (int[] subArray : logs) {
                    if (subArray[0] <= i
                            && subArray[1] > i) {
                        count++;
                    }
                }
                if (count > resultCount) {
                    resultCount = count;
                    resultYear = i;
                }
            }
            return resultYear;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}