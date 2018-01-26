package codes0334.ArrayListRemove;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String ele = iterator.next();
            System.out.println(ele);
            if (ele.equals("444")) {
                list.remove(ele);
            }
        }
    }
}
