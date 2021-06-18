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
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r || arr == null || arr.length < 2) return;
        int i = l, j = r, p = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= p) j--;
            while (i < j && arr[i] <= p) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        quickSort(arr, l, j - 1);
        quickSort(arr, j + 1, r);
    }
}
