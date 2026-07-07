package generator.internal.generic;


import generator.Generator;

import java.util.function.Function;

public class GenericNumberGenerator implements Generator<Integer> {

    private int oldValue;
    private Function<Integer,Integer> myFunction;

    public GenericNumberGenerator(int seed, Function<Integer, Integer> myFunction) {
        this.oldValue = seed;
        this.myFunction = myFunction;
    }

    @Override
    public Integer next() {
        int result = oldValue;
        oldValue = myFunction.apply(result);
        return result;
    }
}
