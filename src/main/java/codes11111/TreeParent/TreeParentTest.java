package codes11111.TreeParent;

import java.util.List;

public class TreeParentTest {
    public static void main(String[] args) {
        TreeParent<String> tp = new TreeParent<String>("root");
        TreeParent.Node<String> root = tp.root();
        System.out.println(root);
        tp.addNode("aaaa", root);
        tp.addNode("bbbb", root);
        tp.addNode("cccc", root);
        tp.addNode("dddd", root);
        System.out.println(tp.deep());
        List<TreeParent.Node<String>> nodes = tp.children(root);
        System.out.println(nodes.get(0));
        tp.addNode("eeee", nodes.get(0));
        System.out.println(tp.deep());
    }
}
