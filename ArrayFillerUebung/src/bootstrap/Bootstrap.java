package bootstrap;

import client.Client;
import client.internal.ClientImpl;
import container.ArrayFiller;
import container.internal.sequential.ArrayFillerSequentialImpl;
import generator.Generator;
import generator.internal.random.RandomNumberGenerator;

import java.util.random.RandomGenerator;

public class Bootstrap {

    public void startApplication(){
        createClient().doSomethingWithLargeArray();
    }

    private Generator<Integer> createGenerator(){
        return new RandomNumberGenerator();
    }

    private ArrayFiller<Integer> createArrayFiller(){
        return new ArrayFillerSequentialImpl<>(createGenerator());
    }

    private Client createClient() {
        return new ClientImpl(createArrayFiller());
    }
}
