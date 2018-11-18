package ua.nure.baranov.lab2;

public class Message {

    private final String payload;

    Message(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return payload;
    }
}
