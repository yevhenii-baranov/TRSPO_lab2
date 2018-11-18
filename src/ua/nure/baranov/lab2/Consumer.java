package ua.nure.baranov.lab2;

public class Consumer {

    private final int id;

    public Consumer(int id) {
        this.id = id;
    }

    public void consume(Message message){
        System.out.println(String.format("Consumer %d got message from producer %s", id, message));
    }

    public int getId() {
        return id;
    }
}
