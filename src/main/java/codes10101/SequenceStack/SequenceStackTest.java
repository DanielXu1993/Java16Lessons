package codes10101.SequenceStack;

public class SequenceStackTest
{
    public static void main(String[] args)
    {
        SequenceStack<String> stack = new SequenceStack<String>();
        stack.push("aaaa");
        stack.push("bbbb");
        stack.push("cccc");
        stack.push("dddd");
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}
