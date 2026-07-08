package container.internal.parallel;

import container.ArrayFiller;
import generator.Generator;
import generator.GeneratorBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayFillerParallelImpl<T> implements ArrayFiller<T> {

    private T[] arrayToFill;
    private ExecutorService service;
    private int partitionSize;
    private final int runnningThreadCount;
    private final GeneratorBuilder<T> generatorBuilder;

    public ArrayFillerParallelImpl(final int runnningThreadCount, final GeneratorBuilder<T> generatorBuilder) {
        this.runnningThreadCount = runnningThreadCount;
        this.generatorBuilder = generatorBuilder;
    }

    @Override
    public T[] fillArray(T[] arrayToFill) {
        this.arrayToFill = arrayToFill;
        calculatePartitionSize();
        tryToFillArrayParallel();
        return arrayToFill;
    }

    private void calculatePartitionSize() {

        partitionSize = arrayToFill.length / runnningThreadCount;
    }

    private void tryToFillArrayParallel() {

        try {
            fillArrayParallel();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }

    private void fillArrayParallel() throws InterruptedException{

        initializeThreadHolder();
        addWorkersToThreads();
        joinThreads();
    }

    private void initializeThreadHolder(){
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private void addWorkersToThreads() {
        for (int actThread = 0; actThread < runnningThreadCount; actThread++) {
            startSingleWorkerForSegment(actThread);
        }
    }

    private void joinThreads() throws InterruptedException {
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startSingleWorkerForSegment(final int actThread) {


        // TODO separate Segment Logic or Spliterator

        final int start = actThread *partitionSize;
        final int end = start+partitionSize;
        service.execute(new FillSegmentWorker(start, end));

    }



    private class FillSegmentWorker implements Runnable{
        private final Generator<T> generator = generatorBuilder.create();
        private final int start;
        private final int end;

        public FillSegmentWorker(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {

            for (int i = start; i < end; i++) {
                arrayToFill[i] = generator.next();
            }
        }
    }

}
