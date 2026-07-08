package generator.internal.random;

import generator.Generator;
import generator.GeneratorBuilder;

public class RandomNumberGeneratorBuilder implements GeneratorBuilder<Integer> {
    @Override
    public Generator<Integer> create() {
        return new RandomNumberGenerator();
    }
}
