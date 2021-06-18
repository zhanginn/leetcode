//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 
// 👍 907 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        int[][] ans = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(ans);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public void rotate(int[][] matrix) {
//            int x = matrix.length;
//            int[][] tmp = Arrays.copyOf(matrix, x);
//            for (int i = 0; i < matrix[0].length; i++) {
//                tmp[i] = Arrays.copyOf(matrix[i], x);
//            }
//            for (int i = x - 1, ai = 0; i >= 0; i--, ai++) {
//                for (int j = 0, aj = 0; j < tmp[0].length; j++, aj++) {
//                    matrix[aj][ai] = tmp[i][j];
//                }
//            }
//        }
//        public void rotate(int[][] matrix) {
//            // matrix.len == matrix[0].len
//            int tR = 0;
//            int tC = 0;
//            int dR = matrix.length - 1;
//            int dC = matrix[0].length - 1;
//            while (tR < dR) {
//                rotateEdge(matrix, tR++, tC++, dR--, dC--);
//            }
//        }
//
//        public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
//            int times = dC - tC;
//            int tmp = 0;
//            for (int i = 0; i != times; i++) {
//                tmp = m[tR][tC + i];
//                m[tR][tC + i] = m[dR - i][tC];
//                m[dR - i][tC] = m[dR][dC - i];
//                m[dR][dC - i] = m[tR + i][dC];
//                m[tR + i][dC] = tmp;
//            }
//        }

        public void rotate(int[][] matrix) {
            int len = matrix.length;
            r(matrix, 0, len - 1, len -1);
        }
        public void r(int[][] matrix, int start, int end, int num) {
            if(start < end){
                for(int i = 0; i < num; i++){
                    int tmp = matrix[start][start + i];
                    matrix[start][start + i] = matrix[end- i][start];
                    matrix[end - i][start] = matrix[end][end - i];
                    matrix[end][end - i] = matrix[start + i][end];
                    matrix[start + i][end] = tmp;
                }
                r(matrix, start + 1, end - 1, num - 2);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}