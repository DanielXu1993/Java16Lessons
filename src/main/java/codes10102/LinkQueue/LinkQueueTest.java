package codes10102.LinkQueue;

public class LinkQueueTest {
    public static void main(String[] args) {
        LinkQueue<String> queue = new LinkQueue<String>();
        queue.add("aaaa");
        queue.add("bbbb");
        queue.add("cccc");
        queue.add("dddd");
        queue.add("eeee");
        queue.add("ffff");
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        queue.add("aaaa");
        System.out.println(queue);
    }
}
