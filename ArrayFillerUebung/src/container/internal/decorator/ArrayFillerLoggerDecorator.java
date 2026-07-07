package container.internal.decorator;

import container.ArrayFiller;

public class ArrayFillerLoggerDecorator<T> implements ArrayFiller<T> {
    private final ArrayFiller<T> arrayFiller;

    public ArrayFillerLoggerDecorator(final ArrayFiller<T> arrayFiller) {
        this.arrayFiller = arrayFiller;
    }

    @Override
    public T[] fillArray(final T[] arrayToFill) {
        System.out.println("ArrayFillerLoggerDecorator.fillArray");
        return arrayFiller.fillArray(arrayToFill);
    }
}
