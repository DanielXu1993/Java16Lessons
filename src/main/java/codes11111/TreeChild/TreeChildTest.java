package codes11111.TreeChild;

import java.util.List;

public class TreeChildTest {
    public static void main(String[] args) {
        TreeChild<String> tp = new TreeChild<String>("root");
        TreeChild.Node<String> root = tp.root();
        System.out.println(root);
        tp.addNode("bbbb", root);
        tp.addNode("cccc", root);
        tp.addNode("dddd", root);
        tp.addNode("eeee", root);
        System.out.println(tp.deep());
        List<TreeChild.Node<String>> children = tp.children(root);
        System.out.println(children.get(1));
        tp.addNode("ffff", children.get(1));
        System.out.println(children.get(1));
        System.out.println(tp.deep());
    }
}
