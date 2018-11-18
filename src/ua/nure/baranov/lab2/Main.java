package ua.nure.baranov.lab2;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Producer> producers = Arrays.asList(new Producer(1), new Producer(2), new Producer(3));
        List<Consumer> consumers = Arrays.asList(new Consumer(1), new Consumer(2), new Consumer(3));

        Connector connector = new Connector(producers, consumers);
    }
}
