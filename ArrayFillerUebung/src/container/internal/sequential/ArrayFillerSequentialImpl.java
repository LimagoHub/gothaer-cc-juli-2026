package container.internal.sequential;

import container.ArrayFiller;
import generator.Generator;


public class ArrayFillerSequentialImpl<T> implements ArrayFiller<T> {

    private final Generator<T> myGenerator;
    public ArrayFillerSequentialImpl(final Generator<T> myGenerator) {
        this.myGenerator = myGenerator;
    }

    @Override
    public T[] fillArray(final T[] arrayToFill) {
        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = myGenerator.next();
        }
        return arrayToFill;
    }
}
