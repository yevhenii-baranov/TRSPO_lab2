package ua.nure.baranov.lab2;

public class Message {

    private final String payload;

    Message(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "payload='" + payload + '\'' +
                '}';
    }
}
