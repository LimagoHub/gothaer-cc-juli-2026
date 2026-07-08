package client.internal;


import client.Client;
import container.ArrayFiller;

public class ClientImpl implements Client {

    private Integer field[] = new Integer[Integer.MAX_VALUE / 8];
    private final ArrayFiller<Integer> arrayFiller;

    public ClientImpl(ArrayFiller<Integer> arrayFiller) {
        this.arrayFiller = arrayFiller;
    }

    @Override
    public void doSomethingWithLargeArray() {
        //System.out.println("Showing first 10 values of Array");
        arrayFiller.fillArray(field);

 /*       for (int i = 0; i < 10; i++) {
            System.out.println(field[i]);
        }

  */
    }
}
