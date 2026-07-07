package generator.internal.random;


import generator.Generator;
import java.util.Random;

public class RandomNumberGenerator implements Generator<Integer> {
    private final Random random = new Random();

    @Override
    public Integer next() {
        return random.nextInt();
    }
}
