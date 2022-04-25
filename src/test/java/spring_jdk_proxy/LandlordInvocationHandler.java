package spring_jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LandlordInvocationHandler implements InvocationHandler {

    private Landlord landlord;

    public LandlordInvocationHandler(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置操作...");
        Object result = method.invoke(landlord, args);
        System.out.println("后置操作...");
        return result;
    }
}
