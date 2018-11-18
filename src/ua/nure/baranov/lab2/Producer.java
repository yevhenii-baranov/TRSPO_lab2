package ua.nure.baranov.lab2;

public class Producer {

    private final int id;

    public Producer(int id) {
        this.id = id;
    }

    public Message produce() {
        return new Message(String.valueOf(this.id));
    }

    public int getId() {
        return id;
    }
}
