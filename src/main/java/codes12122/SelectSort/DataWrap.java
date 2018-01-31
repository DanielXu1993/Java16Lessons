package codes12122.SelectSort;

// 定义一个数据包装类，一个类的实例表示一个要排序的数据元素
public class DataWrap implements Comparable<DataWrap> {
    int data;// 数据值
    String flag;//如果有相同的数据，flag=* 以作标记

    public DataWrap(int data, String flag) {
        this.data = data;
        this.flag = flag;
    }

    @Override
    public int compareTo(DataWrap o) {
        return this.data > o.data ? 1 : (this.data == o.data ? 0 : -1);
    }

    @Override
    public String toString() {
        return data + flag;
    }
}
