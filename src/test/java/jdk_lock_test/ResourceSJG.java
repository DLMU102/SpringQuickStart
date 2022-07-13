package jdk_lock_test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ResourceSJG {

    private int product = 0;

    /**
     * 生产
     */
    public synchronized void getProduct(){
        if(product >= 10) {
            System.out.println(Thread.currentThread().getName() + ": 产品已满额！");
            //当商品已满额的时候，进货线程挂起
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //进货
        System.out.println(Thread.currentThread().getName()+": "+(++product));
        //唤醒其他线程
        this.notifyAll();
    }

    /**
     * 销售
     */
    public synchronized void sale(){
        if(product <= 0){
            System.out.println(Thread.currentThread().getName() + ": 产品缺货！");
            try {
                //*** 重要
                //*** wait()休眠之后，若下次被唤醒应当再执行一次先验条件，从而保证逻辑一致性，即将wait()附近的if判断改为while判断
                //***
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //售货
        System.out.println(Thread.currentThread().getName()+": "+(--product));
        this.notify();
    }

    public static void main(String[] args) {
        ResourceSJG resourceSJG = new ResourceSJG();
        Thread producerA =  new Thread(() -> {
            for(int i = 0; i < 20; i++){
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){
                    e.printStackTrace();
                }
                resourceSJG.getProduct();
            }
        }, "生产者A");

        Thread producerB =  new Thread(() -> {
            for(int i = 0; i < 20; i++){
                resourceSJG.getProduct();
            }
        }, "生产者B");

        Thread customerA =  new Thread(() -> {
            for(int i = 0; i < 20; i++){
                resourceSJG.sale();
            }
        }, "消费者A");

        Thread customerB =  new Thread(() -> {
            for(int i = 0; i < 20; i++){
                resourceSJG.sale();
            }
        }, "消费者B");

        producerA.start();
        producerB.start();
        customerA.start();
        customerB.start();

    }

}
