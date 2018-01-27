package codes10102.LoopQueue;

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<String> queue = new LoopQueue<String>("aaaa", 3);
        queue.add("bbbb");
        queue.add("cccc");
        //queue.add("dddd");
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        System.out.println(queue.length());
        queue.add("dddd");
        System.out.println(queue.length());
    }
}
