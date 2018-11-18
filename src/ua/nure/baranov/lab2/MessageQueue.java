package ua.nure.baranov.lab2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class MessageQueue {
    private final Deque<Message> messages = new ArrayDeque<>();
    private final Semaphore semaphore = new Semaphore(1);

    public Message pop() throws InterruptedException {
        Message message;

        semaphore.acquire();
        System.out.println("Critical section entered");

        if (messages.isEmpty()) message = null;
        else message = messages.pop();

        sleep(500);

        semaphore.release();
        System.out.println("Critical section left");

        return message;
    }

    public void push(Message message) throws InterruptedException {

        semaphore.acquire();
        System.out.println("Critical section entered");


        this.messages.push(message);

        sleep(500);

        semaphore.release();
        System.out.println("Critical section left");
    }
}
