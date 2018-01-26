package codes0993.DuLinkList;

// 双向链表的实现
public class DuLinkList<T> {
    // 定义一个内部类Node，Node实例表示链表的一个节点
    private class Node {
        // 保存节点的数据
        private T data;

        // 指向上一个节点的引用
        private Node prev;

        // 指向下一个节点的引用
        private Node next;

        public Node() {
        }

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // 双向链表的头结点
    private Node header;

    // 双向链表的尾结点
    private Node tail;

    // 双向链表中节点的个数
    private int size;

    // 创建一个空链表
    public DuLinkList() {
        // header和tail都是null
        header = null;
        tail = null;
    }

    // 以指定元素创建双向链表，该链表只有一个元素
    public DuLinkList(T element) {
        header = new Node(element, null, null);
        // header和tail都指向唯一的节点
        tail = header;
        size++;
    }

    // 返回双向链表的长度
    public int length() {
        return size;
    }

    // 根据索引index获取指定位置的节点
    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        if (index <= size / 2) {
            // 从header节点往后搜索
            Node current = header;
            for (int i = 0; i <= size / 2; i++) {
                if (i == index) {
                    return current;
                }
                current = current.next;
            }
        } else {
            // 从tail节点往前搜索
            Node current = tail;
            for (int i = size - 1; i > size / 2; i--) {
                if (i == index) {
                    return current;
                }
                current = current.prev;
            }
        }
        return null;
    }

    // 获取双向链表中指定位置的元素
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    // 查找双向链表中第一次出现指定元素的索引
    public int locate(T element) {
        Node current = header;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(element)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    // 向双向链表的结尾插入新节点
    public void add(T element) {
        // 该链表是空的双向链表
        if (header == null) {
            header = new Node(element, null, null);
            // header和tail都指向新节点
            tail = header;
        } else {
            // 创建新的节点，新节点的prev指向原来的tail
            Node newNode = new Node(element, tail, null);
            // 之前的tail的next指向新节点
            tail.next = newNode;
            // 将新节点设置成tail节点
            tail = newNode;
        }
        size++;
    }

    // 从双向链表的前端插入新的节点
    public void addAtHeader(T element) {
        // 创建新的节点，并让新节点的next指向原本的header
        // 将新节点设置为header
        header = new Node(element, null, header);
        // 如果插入之前是空的双向链表
        if (tail == null) {
            // tail和header都指向新插入的节点
            tail = header;
        }
        size++;
    }

    // 向双向链表的指定位置插入新的元素
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        // 空链表
        if (header == null) {
            add(element);
        } else {
            // 在链表的表头插入元素
            if (index == 0) {
                addAtHeader(element);
            } else {
                // 获取插入位置之前的一个节点
                Node prev = getNodeByIndex(index - 1);
                // 获取插入位置之后的一个节点
                Node next = prev.next;
                // 创建新的节点，使它的prev指向prev节点，使它的next指向next节点
                Node newNode = new Node(element, prev, next);
                // 让上一个节点的next指向新的节点
                prev.next = newNode;
                // 使下一个节点的prev指向新的节点
                next.prev = newNode;
                size++;
            }
        }
    }

    // 删除双向链表中指定位置的元素
    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node del = null;
        // 删除的是头结点
        if (index == 0) {
            del = header;
            // 头结点的下一个节点为新的头结点
            header = header.next;
            // 新的头结点的prev节点为null
            header.prev = null;
        } else {
            // 获取要删除的节点的上一个节点
            Node prev = getNodeByIndex(index - 1);
            // 要删除的节点是上一个节点的下一个节点
            del = prev.next;
            // 将上一个节点的next指向要删除的节点的next
            prev.next = del.next;
            // 如果要删除的节点不是tail节点
            if (del.next != null) {
                // 将要删除的节点的下一个节点的prev
                // 指向要删除的节点的上一个节点
                del.next.prev = prev;
            }
            // 将要删除的节点的prev和next设置为null
            del.prev = null;
            del.next = null;
        }
        size--;
        return del.data;
    }

    // 删除双向链表中的最后一个元素
    public T remove() {
        return delete(size - 1);
    }

    // 判断双向链表是否为空
    public boolean empty() {
        return size == 0;
    }

    //  清空双向链表
    public void clear() {
        header = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next) {
                sb.append(current.data.toString() + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

    public String reverseToString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = tail; current != null; current = current.prev) {
                sb.append(current.data.toString() + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }
}
