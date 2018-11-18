package ua.nure.baranov.lab2;

import java.util.ArrayList;
import java.util.List;

public class Connector {

    private final MessageQueue queue = new MessageQueue();

    public Connector(List<Producer> producers, List<Consumer> consumers) {
        List<ProducerThread> producerThreads = new ArrayList<>();
        List<ConsumerThread> consumerThreads = new ArrayList<>();


        for (Producer producer : producers) {
            producerThreads.add(new ProducerThread(producer, queue));
        }
        for (Consumer consumer : consumers) {
            consumerThreads.add(new ConsumerThread(consumer, queue));
        }

        producerThreads.forEach(Thread::start);
        consumerThreads.forEach(Thread::start);
    }


    private static class ProducerThread extends Thread {
        private final Producer producer;
        private final MessageQueue queue;

        ProducerThread(Producer producer, MessageQueue queue) {
            this.producer = producer;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!this.isInterrupted()) {
                try {
                    this.queue.push(producer.produce());
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    private static class ConsumerThread extends Thread {
        private final Consumer consumer;
        private final MessageQueue queue;

        ConsumerThread(Consumer consumer, MessageQueue queue) {
            this.consumer = consumer;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!this.isInterrupted()) {
                try {
                    Message message = queue.pop();
                    consumer.consume(message);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
