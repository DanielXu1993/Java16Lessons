package codes0331.HashSetTest;

import java.util.HashSet;
import java.util.Set;

class Name {
    private String first;

    private String last;

    public Name(String first, String last) {
        super();
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("是否调用了equals方法");// 本例中没有调用
        if (this == obj)
            return true;
        if (obj.getClass() == Name.class) {
            Name n = (Name) obj;
            return n.first.equals(this.first) && n.last.equals(this.last);
        }
        return false;
    }
}

public class HashSetTest {
    public static void main(String[] args) {
        Set<Name> names = new HashSet<Name>();
        // Name 中没有重写hashCode方法
        // 创建的Name对象的hashCode不同
        // 直接插入哈希表，不会调用equals方法比较
        names.add(new Name("abc", "123"));
        names.add(new Name("abc", "123"));
        System.out.println(names.size());// 2
    }
}
