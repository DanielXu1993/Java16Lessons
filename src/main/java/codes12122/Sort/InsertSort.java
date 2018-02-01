package codes12122.Sort;

import java.util.Arrays;

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
                // 倒序遍历索引0~i-1处的元素，从后面找第一个比tmp小的元素的索引
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (data[j].compareTo(tmp) > 0) {
                        // 将比tmp大的元素全部往后移一位
                        // 此时原先i处的元素被覆盖掉，而从右往左最后一个大于tmp的元素出现两次
                        data[j + 1] = data[j];
                    } else {
                        // 退出循环，此时的j是从右往左第一个小于tmp的元素索引
                        break;
                    }
                }
                // 将tmp放在j后面一位，并覆盖其中一个出现两次的元素的元素
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
        insertSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
