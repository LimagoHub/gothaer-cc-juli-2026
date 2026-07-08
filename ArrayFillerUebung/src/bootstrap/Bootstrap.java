package bootstrap;

import client.Client;
import client.internal.ClientImpl;
import container.ArrayFiller;
import container.internal.builder.ArrayFillerBuilder;
import container.internal.decorator.ArrayFillerBenchmarkDecorator;
import container.internal.sequential.ArrayFillerSequentialImpl;
import generator.Generator;
import generator.GeneratorBuilder;
import generator.internal.random.RandomNumberGenerator;
import generator.internal.random.RandomNumberGeneratorBuilder;
import time.Stopwatch;
import time.internal.StopwatchImpl;

import java.util.random.RandomGenerator;

public class Bootstrap {

    public void startApplication(){
        for(int threadCount = 0; threadCount <= Runtime.getRuntime().availableProcessors(); threadCount++){
            System.out.println("Running " + threadCount + " threads");
            createClient(threadCount).doSomethingWithLargeArray();
        }

    }

    private Stopwatch createStopwatch(){
        return new StopwatchImpl();
    }

    private GeneratorBuilder<Integer> createGeneratorBuilder(){
        return new RandomNumberGeneratorBuilder();
    }

    private ArrayFiller<Integer> createArrayFiller(int threadCount){
        return ArrayFillerBuilder.<Integer>builder()
                .generatorBuilder(createGeneratorBuilder())
                .stopwatch(createStopwatch())
                .parallel(threadCount)
                .build();
    }

    private Client createClient(int threadCount) {
        return new ClientImpl(createArrayFiller(threadCount));
    }
}
