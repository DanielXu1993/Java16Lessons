package codes12122.Sort;

import java.util.Arrays;

// 快速排序的实现
public class QuickSort {
    // 交换数组中索引为i和j处元素的位置
    private static void swap(DataWrap[] data, int i, int j) {
        DataWrap tmp;
        tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private static void quickSort(DataWrap[] data, int start, int end) {
        // 需要排序
        if (start < end) {
            // 以第一个元素作为分界值
            DataWrap base = data[start];
            // j 从右边开始搜素，搜索小于分界值的元素的索引
            int j = end;
            // i 从左边开始搜素，搜索大于分界值的元素的索引
            int i = start;
            // 循环搜索，直到i>=j退出循环
            while (i < j) {
                // 从右边开始搜索，找第一个比分界值小的索引
                // 如果找不到，一直循环到i处
                while (i < j && data[j].compareTo(base) >= 0) {
                    j--;
                }
                // 从左边开始搜索，找第一个比分界值大的索引
                // 如果找不到，一直循环到j处
                while (i < j && data[i].compareTo(base) <= 0) {
                    i++;
                }
                if (i < j) {
                    // 交换i和j处元素的位置
                    swap(data, i, j);
                }
            }
            // 交换分界值与j处的元素的位置
            swap(data, start, j);
            // 递归左右子序列
            quickSort(data, start, i - 1);
            quickSort(data, i + 1, end);
        }
    }

    public static void quickSort(DataWrap[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(5, ""),
                new DataWrap(55, ""),
                new DataWrap(66, ""),
                new DataWrap(2, ""),
                new DataWrap(7, ""),
                new DataWrap(-2, ""),
                new DataWrap(9, ""),
                new DataWrap(0, ""),
                new DataWrap(-2, ""),
                new DataWrap(-4, ""),
                new DataWrap(4, ""),
                new DataWrap(79, ""),
                new DataWrap(0, ""),
                new DataWrap(-3, ""),
                new DataWrap(55, ""),
                new DataWrap(66, ""),
                new DataWrap(1, ""),
                new DataWrap(2, ""),
                new DataWrap(22, ""),
                new DataWrap(33, ""),
                new DataWrap(44, ""),
                new DataWrap(3, ""),
                new DataWrap(4, ""),
                new DataWrap(5, ""),
                new DataWrap(4, ""),
                new DataWrap(3, ""),
                new DataWrap(2, ""),
                new DataWrap(1, ""),
                new DataWrap(11, ""),
                new DataWrap(77, ""),
        };
        System.out.println("排序之前：\n" + Arrays.toString(data) + data.length);
        quickSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data) + data.length);
    }
}