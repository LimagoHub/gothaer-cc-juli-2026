package container.internal.parallel;

import container.ArrayFiller;
import generator.Generator;
import generator.GeneratorBuilder;

import java.util.stream.IntStream;

public class ArrayFillerAutoImpl<T> implements ArrayFiller<T> {

    private final GeneratorBuilder<T> generatorBuilder;

    public ArrayFillerAutoImpl(final GeneratorBuilder<T> generatorBuilder) {
        this.generatorBuilder = generatorBuilder;
    }

    @Override
    public T[] fillArray(final T[] arrayToFill) {
        final ThreadLocal<Generator<T>> generator = ThreadLocal.withInitial(generatorBuilder::create);
        IntStream.range(0, arrayToFill.length)
                .parallel()
                .forEach(i -> arrayToFill[i] = generator.get().next());
        return arrayToFill;
    }
}
