package spring_jdk_proxy;

import javafx.concurrent.Worker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) throws Exception {
        Landlord landlord = new Landlord();

        Rent landlordProxy = (Rent) MyProxy.newProxyInstance(landlord.getClass().getClassLoader(),
                landlord.getClass().getInterfaces(),
                new MyInvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("前置操作...");
                        Object result = method.invoke(landlord, args);
                        System.out.println("后置操作...");
                        return 1;
                    }
                });

        landlordProxy.rent(1);
    }

    public static void mains(String[] args) throws Exception {
        Class<?> proxyClass = Proxy.getProxyClass(Landlord.class.getClassLoader(), Rent.class);
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        InvocationHandler workHandler = new LandlordInvocationHandler(new Landlord());
        Rent renter = (Rent) constructor.newInstance(workHandler);
        renter.rent(1);
    }
}
