package codes12122.Sort;

import java.util.Arrays;

// 归并排序的实现
public class MergeSort {

    /**
     * 将两个数组进行归并，归并之前是有序数组，归并之后依然有序
     *
     * @param data   数组对象
     * @param left   左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1 是右数组第一个元素的索引
     * @param right  右数组的最后一个元素的索引
     */
    private static void merge(DataWrap[] data, int left, int center, int right) {
        DataWrap[] tmpArr = new DataWrap[data.length];
        // 右数组第一个元素的索引
        int mid = center + 1;
        // tmpArr中开始插入元素的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从左、右数组中取处小的元素放入中间数组
            // 从哪个数组中去完值哪个数组的索引就往后移一位
            if (data[left].compareTo(data[mid]) <= 0) {
                tmpArr[third] = data[left];
                third++;
                left++;
            } else {
                tmpArr[third] = data[mid];
                third++;
                mid++;
            }
        }
        // 左数组放完了右数组没放完
        while (mid <= right) {
            tmpArr[third] = data[mid];
            third++;
            mid++;
        }
        // 右数组放完了左数组没放完
        while (left <= center) {
            tmpArr[third] = data[left];
            third++;
            left++;
        }
        // 将中间数组的值放入data数组中
        // right  - left
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp];
            tmp++;
        }
    }

    /**
     * 将索引在left到right处的数组元素进行归并排序
     *
     * @param data  待排序的数组
     * @param left  待排序数组的第一个元素的索引
     * @param right 待排序数组的最后一个元素的索引
     */
    private static void sort(DataWrap[] data, int left, int right) {
        if (left < right) {
            // 从中间拆分数组
            int center = (left + right) / 2;
            // 对左数组进行排序
            sort(data, left, center);
            // 对右数组进行排序
            sort(data, center + 1, right);
            // 合并
            merge(data, left, center, right);
        }
    }

    public static void mergeSort(DataWrap[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(21, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
                new DataWrap(9, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
                new DataWrap(9, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
        };
        System.out.println("排序之前：\n" + Arrays.toString(data));
        mergeSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
