package codes12122.Sort;

import java.util.Arrays;

// 折半插入排序的实现
public class BinaryInsertSort {
    public static void binaryInsertSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 从索引为1的元素开始往之前的子序列中插入后面的元素
        for (int i = 1; i < arrayLength; i++) {
            // 记录要插入的元素
            DataWrap tmp = data[i];
            // 在索引0~i的数组中查找要插入元素存放的位置
            int low = 0;
            int hight = i - 1;
            while (low <= hight) {
                int mid = (low + hight) / 2;
                if (tmp.compareTo(data[mid]) > 0) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
            //索引low处是从左往右第一个比tmp大的元素
            for (int j = i - 1; j >= low; j--) {
                // 将low到i-1处元素整体向右移动一位
                data[j + 1] = data[j];
            }
            data[low] = tmp;
            System.out.println(Arrays.toString(data));
        }
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
        binaryInsertSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
