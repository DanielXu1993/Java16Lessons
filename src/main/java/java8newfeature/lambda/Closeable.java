package lambda;

@FunctionalInterface
interface Closeable {
    void close();
}

class CloseDoor {
    public void doClose(Closeable c) {
        c.close();
    }

    public static void main(String[] args) {
        CloseDoor closeDoor = new CloseDoor();

        // 使用匿名内部类实现
        closeDoor.doClose(new Closeable() {
            @Override
            public void close() {
                System.out.println("使用匿名内部类实现");
            }
        });

        // 使用Lambda表达式实现
        closeDoor.doClose(() -> System.out.println("使用Lambda表达式实现"));
    }
}
