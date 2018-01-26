package codes0992.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList<String>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.insert("dddd", 1);
        System.out.println(list);

        list.delete(2);
        System.out.println(list);

        System.out.println("cccc在顺序表中的位置:" + list.locate("cccc"));
    }
}
