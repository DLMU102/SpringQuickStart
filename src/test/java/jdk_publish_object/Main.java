package jdk_publish_object;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final Holder holder = new Holder(4);
        Thread testA = new TestRunnerA(holder);
        Thread testB = new TestRunnerB(holder);
        Thread testC = new TestRunnerA(holder);
        Thread testD = new TestRunnerB(holder);
        Thread testE = new TestRunnerA(holder);
        Thread testF = new TestRunnerB(holder);
        testA.start();
        testB.start();
        testC.start();
        testD.start();
        testE.start();
        testF.start();
    }

    static class TestRunnerA extends Thread{

        private Holder holder;

        public TestRunnerA(Holder holder) {
            this.holder = holder;
            this.holder.n = (int) (Math.random() * 10);
        }

        @Override
        public void run() {
            if(null != holder){
                try {
                    Thread.sleep((long) (Math.random() * 100));
                    holder.assertSanity();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class TestRunnerB extends Thread{

        private Holder holder;

        public TestRunnerB(final Holder holder) {
            this.holder = holder;
            this.holder.n = (int) (Math.random() * 10);
        }

        @Override
        public void run() {
            if(null != holder){
                try {
                    holder.assertSanity();
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Holder{
        private int n;
        public Holder(int n){
            this.n = n;
        }
        public void assertSanity(){
            if(n != n){
                throw new AssertionError("This statement is false.");
            }else {
                System.out.println("current n = "+n);
            }
        }
    }
}
