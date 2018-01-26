package codes0993.LinkList;

public class LinkListTest
{
    public static void main(String[] args)
    {
        LinkList<String> list = new LinkList<String>();
        list.insert("aaa", 0);
        list.add("bbbb");
        list.add("cccc");
        list.insert("dddd", 1);

        System.out.println(list);
        list.delete(2);
        System.out.println(list);
        System.out.println("cccc在链表中的位置： " + list.locate("cccc"));
        System.out.println("链表中索引为2的元素: " + list.get(2));
    }
}
