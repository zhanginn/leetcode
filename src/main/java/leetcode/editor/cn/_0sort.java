package leetcode.editor.cn;

import java.util.Arrays;

public class _0sort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 1, 6, 4};
//        process(arr, 0);
//        process1(arr, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //选择
    public static void process(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] < min) {
                pos = i;
                min = arr[i];
            }
        }
        int tmp = arr[index];
        arr[index] = min;
        arr[pos] = tmp;
        process(arr, index + 1);
    }

    //冒泡
    public static void process1(int[] arr, int e) {
        if (e == 0) {
            return;
        }
        for (int i = 0; i < e + 1; i++) {
            if (i + 1 <= e && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        process1(arr, e - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int p, i, j;
        if (low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while (i < j) {
            //右边当发现小于p的值时停止循环
            while (arr[j] >= p && i < j) {
                j--;
            }
            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）
            //左边当发现大于p的值时停止循环
            while (arr[i] <= p && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        quickSort(arr, low, j - 1);  //对左边快排
        quickSort(arr, j + 1, high); //对右边快排

    }
}
