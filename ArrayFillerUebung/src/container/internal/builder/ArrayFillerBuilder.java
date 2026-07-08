package container.internal.builder;

import container.ArrayFiller;
import container.internal.decorator.ArrayFillerBenchmarkDecorator;
import container.internal.decorator.ArrayFillerLoggerDecorator;
import container.internal.parallel.ArrayFillerAutoImpl;
import container.internal.parallel.ArrayFillerParallelImpl;
import generator.GeneratorBuilder;
import time.Stopwatch;

public class ArrayFillerBuilder<T> {

    private GeneratorBuilder<T> generatorBuilder;
    private boolean logger = false;
    private Stopwatch stopwatch = null;
    private int threadCount = 0;

    public static <T> ArrayFillerBuilder<T> builder() {
        return new ArrayFillerBuilder<>();
    }

       public ArrayFillerBuilder<T> generatorBuilder(final GeneratorBuilder<T> generatorBuilder) {
        this.generatorBuilder = generatorBuilder;
        return this;
    }

    public ArrayFillerBuilder<T> logger(final boolean logger) {
        this.logger = logger;
        return this;
    }

    public ArrayFillerBuilder<T> stopwatch(final Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
        return this;
    }

    public ArrayFillerBuilder<T> parallel(final int threadCount) {
        this.threadCount = threadCount;
        return this;
    }

    public ArrayFiller<T> build() {
        if (generatorBuilder == null) {
            throw new IllegalStateException("generator must be set before build()");
        }
        ArrayFiller<T> arrayFiller = createStrategy();
        arrayFiller = applyDecorators(arrayFiller);
        return arrayFiller;
    }

    private ArrayFiller<T> createStrategy() {
        return threadCount > 0
                ? new ArrayFillerParallelImpl<>(threadCount, generatorBuilder)
                : new ArrayFillerAutoImpl<>(generatorBuilder);
    }

    private ArrayFiller<T> applyDecorators(ArrayFiller<T> arrayFiller) {
        if (stopwatch != null) {
            arrayFiller = new ArrayFillerBenchmarkDecorator<>(arrayFiller, stopwatch);
        }
        if (logger) {
            arrayFiller = new ArrayFillerLoggerDecorator<>(arrayFiller);
        }
        return arrayFiller;
    }

}
