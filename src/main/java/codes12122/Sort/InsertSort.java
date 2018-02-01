package codes12122.Sort;

import java.util.Arrays;

// 直接插入排序的实现
public class InsertSort {
    public static void insertSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 从索引为1的元素开始往之前的子序列中插入后面的元素
        for (int i = 1; i < arrayLength; i++) {
            // 记录要插入的元素
            DataWrap tmp = data[i];
            // 在插入索引为i的元素之前，索引0~i-1处的元素都是有序的
            // 如果data[i] >= data[i-1]，说明已经是有序的，data[i]的元素依然放在i上
            // data[i] < data[i-1]，需要在前面的序列中找到合适的位置插入
            if (data[i].compareTo(data[i - 1]) < 0) {

                int j = i - 1;
                for (; j >= 0 && data[j].compareTo(tmp) > 0; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = tmp;
            }
            System.out.println(Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(21, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(30, "*"),
                new DataWrap(16, ""),
                new DataWrap(9, ""),
        };
        System.out.println("排序之前：\n" + Arrays.toString(data));
        insertSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
