package jdk_StackAllocTest;

public class StackAllocTest {
    public static void main(String[] args) {
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
        //for (int i = 0; i < 10; i++) {
            alloc();
        }
        // 查看执行时间
        long a2 = System.currentTimeMillis();
        System.out.println("log--StackAllocTest--cost " + (a2 - a1) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
        try {
            System.out.println("log--StackAllocTest--sleeping...");
            Thread.sleep(100000);
            System.out.println("log--StackAllocTest--sleeped...");
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User();
    }

    static class User {

    }
}
