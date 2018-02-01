package codes12122.Sort;

import java.util.Arrays;

// Shell排序的实现
public class ShellSort {
    public static void shellSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        int h = 1;
        // 按h*3+1得到最大增量
        while (h <= arrayLength / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("======h的值：" + h + "======");
            for (int i = h; i < arrayLength; i++) {
                DataWrap tmp = data[i];
                // i处的索引值比前面间隔h的值都大，无需插入
                if (data[i].compareTo(data[i - h]) < 0) {
                    int j = i - h;
                    // 整体向后移动h格
                    for (; j >= 0; j = j - h) {
                        if (data[j].compareTo(tmp) > 0) {
                            data[j + h] = data[j];
                        } else {
                            break;
                        }
                    }
                    data[j + h] = tmp;
                }
                System.out.println(Arrays.toString(data));
            }
            h = (h - 1) / 3;
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
        shellSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
