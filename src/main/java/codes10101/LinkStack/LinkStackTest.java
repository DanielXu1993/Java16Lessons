package codes10101.LinkStack;

public class LinkStackTest {
    public static void main(String[] args) {
        LinkStack<String> stack = new LinkStack<String>("aaaa");
        stack.push("bbbb");
        stack.push("cccc");
        stack.push("dddd");
        stack.push("eeee");
        stack.push("ffff");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);
    }
}
