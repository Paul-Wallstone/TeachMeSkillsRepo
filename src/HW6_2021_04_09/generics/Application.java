package HW6_2021_04_09.generics;

public class Application {
    public static void main(String[] args) {
        GenericClass<Integer> genericClass1 = new GenericClass<>(new Integer[]{1, 2, 3});
        GenericClass<Double> genericClass2 = new GenericClass<>(new Double[]{1.1, 2.2, 3.3});
        GenericClass<Long> genericClass4 = new GenericClass<>();
        Long[] array = new Long[]{10L, 11L, 12L};
        genericClass4.setArray(array);
        System.out.println(genericClass1.getObjectFormArray(1));
        System.out.println(genericClass2.getObjectFormArray(1));
        System.out.println(genericClass4.getObjectFormArray(1));
    }
}
