package jdk_lock_test;

public class LoggingWidget extends Widget {

    @Override
    void passThroughImmigration() {

    }

    public synchronized void doSomething() {
        System.out.println(toString() + ": doSomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        // Run with: java -XX:CompileCommand='dontinline,*.passThroughImmigration'
        Widget widgetObjA = new LoggingWidget();
        Widget widgetObjB = new FileWidget();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_00; i++) {
            if (i % 100 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            Widget c = (i < 1_00) ? widgetObjA : widgetObjB;
            c.passThroughImmigration();
        }
    }
}
