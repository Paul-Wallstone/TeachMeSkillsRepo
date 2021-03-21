package HW3_2021_03_19;

public final class Calculator {

    private double a;
    private double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Calculator() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public static double addition(double a, double b) {
        return a + b;
    }

    public static double division(double a, double b) {
        return a / b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double subtraction(double a, double b) { return a - b; }

}
