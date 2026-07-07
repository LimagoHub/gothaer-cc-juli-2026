package container.internal.builder;

import container.ArrayFiller;
import container.internal.decorator.ArrayFillerBenchmarkDecorator;
import container.internal.decorator.ArrayFillerLoggerDecorator;
import container.internal.sequential.ArrayFillerSequentialImpl;
import generator.Generator;
import time.Stopwatch;

public class ArrayFillerBuilder<T> {

    private Generator<T> generator;
    private boolean logger = false;
    private Stopwatch stopwatch = null;
    public static ArrayFillerBuilder builder() {
        return new ArrayFillerBuilder();
    }

    public ArrayFillerBuilder<T> generator(Generator<T> generator) {
        this.generator = generator;
        return this;
    }
    public ArrayFillerBuilder<T> logger(boolean logger) {
        this.logger = logger;
        return this;
    }


    public ArrayFillerBuilder<T> stopwatch(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
        return this;
    }


    public ArrayFiller<T> build() {
        ArrayFiller<T> arrayFiller =  new ArrayFillerSequentialImpl<>(generator);
        if(stopwatch != null)
            arrayFiller = new ArrayFillerBenchmarkDecorator<>(arrayFiller, stopwatch);
        if(logger )
            arrayFiller = new ArrayFillerLoggerDecorator<>(arrayFiller);
        return arrayFiller;
    }

}
