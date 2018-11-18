package ua.nure.baranov.lab2;

public class Producer {
    private static int counter = 0;

    public Message produce() {
        if (counter > 10000) counter = 0;
        return new Message(String.valueOf(counter++));
    }

}
