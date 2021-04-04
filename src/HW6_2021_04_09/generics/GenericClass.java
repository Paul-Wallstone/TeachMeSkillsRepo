package HW6_2021_04_09.generics;

public class GenericClass<T extends Number> {
    private T[] array;

    public GenericClass(T[] array) {
        this.array = array;
    }

    public GenericClass() {
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public T getObjectFormArray(int a) {
        return this.array[a];
    }
}

