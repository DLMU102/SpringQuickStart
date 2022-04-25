package JxyTest;

public class Rectangle {
    /**
     * 宽
     */
    private double width;
    /**
     * 高
     */
    private double height;

    /**
     * 构造方法
     *
     * @param width  宽
     * @param height 高
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;

    }

    /**
     * 计算长方形的面积
     *
     * @return 返回长方形的面积
     */
    public double getAra() {
        return this.width * this.height;
    }

    /**
     * 计算长方形的周长
     *
     * @return 返回长方形的周长
     */
    public double getGirth() {
        return 2 * (this.width + this.height);
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

class Test {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2, 3);
        System.out.print("长方形的宽:" + rect.getWidth());
        System.out.println("长方形的高；" + rect.getHeight());
        System.out.println("长方形的面积：" + rect.getAra());
        System.out.println("长方形的周长：" + rect.getGirth());
        //test edit
    }

//
//    public static void setWidth(double width){
//
//    }

}
