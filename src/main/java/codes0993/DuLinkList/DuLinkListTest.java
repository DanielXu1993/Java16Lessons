package codes0993.DuLinkList;

public class DuLinkListTest
{
    public static void main(String[] args)
    {
        DuLinkList<String> list = new DuLinkList<String>();
        list.insert("aaaa",0);
        list.add("bbbb");
        list.insert("cccc",0);
       // list.insert("dddd",1);
        System.out.println(list);

        list.delete(2);
        System.out.println(list);
        System.out.println(list.reverseToString());
        System.out.println(list.locate("cccc"));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        ///System.out.println(list.get(2));
        //System.out.println(list.get(3));
    }
}
