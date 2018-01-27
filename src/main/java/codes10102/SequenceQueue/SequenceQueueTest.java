package codes10102.SequenceQueue;

public class SequenceQueueTest {
    public static void main(String[] args) {
        SequenceQueue<String> queue = new SequenceQueue<String>();
        queue.add("aaaa");
        queue.add("bbbb");
        queue.add("cccc");
        queue.add("dddd");
        queue.add("eeee");
        queue.add("ffff");
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.length());
        System.out.println(queue.element());
    }
}
