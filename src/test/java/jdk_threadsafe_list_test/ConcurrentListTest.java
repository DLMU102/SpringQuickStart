package jdk_threadsafe_list_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentListTest {
    public void main(String[] args) {
//        testVectorByRead();
//        testSynchronizedListByRead();
//        testCopyOnWriteArrayListByRead();
//        testVectorByWrite();
//        testSynchronizedListByWrite();
//        testCopyOnWriteArrayListByWrite();
        testRsh();


    }

    public static void testVectorByRead(){
        Vector<Integer> vector = new Vector<>();
        vector.add(0);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            vector.get(0);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("vector: "+(time2-time1));
    }

    public static void testSynchronizedListByRead(){
        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        list.add(0);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.get(0);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("synchronizedList: "+(time2-time1));
    }

    public static void testCopyOnWriteArrayListByRead(){
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(0);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.get(0);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("copyOnWriteArrayList: "+(time2-time1));
    }

    public static void testVectorByWrite(){
        Vector vector = new Vector();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            vector.add(i);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("vector: "+(time2-time1));
    }

    public static void testSynchronizedListByWrite(){
        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("synchronizedList: "+(time2-time1));
    }

    public static void testCopyOnWriteArrayListByWrite(){
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("copyOnWriteArrayList: "+(time2-time1));
    }

    /**
     * 测试 有/无符号右移
     */
    public static void testRsh(){
        int a = -100;
        //测试无符号右移
        System.out.println(a >>> 4);
        //测试有符号右移
        //操作	            二进制	                               对应十进制
        //原码	            10000000 00000000 00000000 01100100	   -100
        //转换为补码	        11111111 11111111 11111111 10011100	   -100
        //右移4位，高位补1	    11111111 11111111 11111111 11111001
        //保留符号位，按位取反	10000000 00000000 00000000 00000110
        //加1后转为源码	    10000000 00000000 00000000 00000111	    -7
        System.out.println(a >> 4);

    }

    class A{
        final int a = 0;
    }

}
