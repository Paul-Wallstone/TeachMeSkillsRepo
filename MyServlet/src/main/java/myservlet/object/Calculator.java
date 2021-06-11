package myservlet.object;

import java.util.Objects;

public class Calculator {
    private double operatorA;
    private double operatorB;

    public Calculator(double operatorA, double operatorB) {
        this.operatorA = operatorA;
        this.operatorB = operatorB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Double.compare(that.operatorA, operatorA) == 0 && Double.compare(that.operatorB, operatorB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatorA, operatorB);
    }

    public double getOperatorA() {
        return operatorA;
    }

    public void setOperatorA(double operatorA) {
        this.operatorA = operatorA;
    }

    public double getOperatorB() {
        return operatorB;
    }

    public void setOperatorB(double operatorB) {
        this.operatorB = operatorB;
    }

    public  double sum() {
        return operatorA + operatorB;
    }

    public double division() {
        return operatorA / operatorB;
    }

    public double multiply() {
        return operatorA * operatorB;
    }

    public  double subtraction() {
        return operatorA - operatorB;
    }
}
