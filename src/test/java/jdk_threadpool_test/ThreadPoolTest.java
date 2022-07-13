package jdk_threadpool_test;

public class ThreadPoolTest {
    public static void main(String[] args) {
        int nCPU = Runtime.getRuntime().availableProcessors();
        System.out.println(nCPU);
    }
}
