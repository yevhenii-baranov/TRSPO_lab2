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
        if (messages.isEmpty()) message = null;
        else message = messages.pop();

        sleep(50);

        semaphore.release();

        return message;
    }

    public void push(Message message) throws InterruptedException {
        semaphore.acquire();

        this.messages.push(message);

        sleep(50);

        semaphore.release();
    }
}
