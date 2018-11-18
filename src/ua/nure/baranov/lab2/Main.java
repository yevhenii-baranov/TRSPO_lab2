package ua.nure.baranov.lab2;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Producer> producers = Arrays.asList(new Producer(), new Producer(), new Producer());
        List<Consumer> consumers = Arrays.asList(new Consumer(), new Consumer(), new Consumer());

        Connector connector = new Connector(producers, consumers);
    }
}
