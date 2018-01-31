package codes12122.SelectSort;

import java.util.Arrays;
// 冒泡排序的实现
public class BubbleSort {
    public static void bubbleSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 冒泡排序至多需要循环 arrayLength - 1次
        for (int i = 0; i < arrayLength - 1; i++) {
            // 标记是否发生交换
            boolean flag = false;
            // 每次交换后最大的值总在最后
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                // 如果data[j] > data[j+1]，发生交换
                if (data[j].compareTo(data[j + 1]) > 0) {
                    DataWrap tmp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = tmp;
                    // 发生交换，改变标记
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(data));
            // 未发生交换，提前结束排序
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(9, ""),
                new DataWrap(16, ""),
                new DataWrap(21, ""),
                new DataWrap(23, ""),
                new DataWrap(30, ""),
                new DataWrap(49, ""),
                new DataWrap(21, "*"),
                new DataWrap(30, "*")
        };
        System.out.println("排序之前：\n" + Arrays.toString(data));
        bubbleSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
