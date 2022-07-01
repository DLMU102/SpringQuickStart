package jdk_lock_test;

public abstract class Widget {

    abstract void passThroughImmigration();

    public synchronized void doSomething(){
        System.out.println(toString()+": doSomething");
    }
}
