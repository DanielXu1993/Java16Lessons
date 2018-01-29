package codes11112.ArrayBinTree;

public class ArrayBinTreeTest {
    public static void main(String[] args) {
        ArrayBinTree<String> binTree = new ArrayBinTree<String>(4, "root");
        binTree.add(0, "第二层最后一个节点", false);
        binTree.add(2, "第三层最后一个节点", false);
        binTree.add(6, "第四层最后一个节点", false);
        System.out.println(binTree);
    }
}
