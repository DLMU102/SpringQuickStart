package jdk_lock_test;

public class FileWidget extends Widget{
    @Override
    void passThroughImmigration() {
    }

    public synchronized void doSomething(){
        System.out.println(toString()+": doSomething");
    }
}
