package container.internal.decorator;

import container.ArrayFiller;
import generator.Generator;
import time.Stopwatch;

public class ArrayFillerBenchmarkDecorator<T> implements ArrayFiller<T> {

    private final ArrayFiller<T> arrayFiller;
    private final Stopwatch stopwatch;

    public ArrayFillerBenchmarkDecorator(final ArrayFiller<T> arrayFiller, final Stopwatch stopwatch) {
        this.arrayFiller = arrayFiller;
        this.stopwatch = stopwatch;
    }

    @Override
    public T[] fillArray(final T[] arrayToFill) {
        stopwatch.start();
        var result = arrayFiller.fillArray(arrayToFill);
        stopwatch.stop();
        System.out.println("Duration: " + stopwatch.getDuration().toMillis());
        return result;
    }
}
