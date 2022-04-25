package spring_jdk_proxy;

public class Landlord implements Rent{

    @Override
    public int rent(int a) {
        System.out.println("rental price: "+a);
        return a;
    }
}
