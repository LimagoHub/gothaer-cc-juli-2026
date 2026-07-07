package bootstrap;

import client.Client;
import client.internal.ClientImpl;
import container.ArrayFiller;
import container.internal.builder.ArrayFillerBuilder;
import container.internal.decorator.ArrayFillerBenchmarkDecorator;
import container.internal.sequential.ArrayFillerSequentialImpl;
import generator.Generator;
import generator.internal.random.RandomNumberGenerator;
import time.Stopwatch;
import time.internal.StopwatchImpl;

import java.util.random.RandomGenerator;

public class Bootstrap {

    public void startApplication(){
        createClient().doSomethingWithLargeArray();
    }

    private Stopwatch createStopwatch(){
        return new StopwatchImpl();
    }

    private Generator<Integer> createGenerator(){
        return new RandomNumberGenerator();
    }

    private ArrayFiller<Integer> createArrayFiller(){
        return ArrayFillerBuilder.builder().generator(createGenerator()).build();
    }

    private Client createClient() {
        return new ClientImpl(createArrayFiller());
    }
}
