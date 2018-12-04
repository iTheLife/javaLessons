package lesson5;

public class Counter {
    int c;

    public int value() {
        return c;
    }

    public Counter() {
        this.c = 0;
    }

    public synchronized void dec() {
        c--;
    }

    public synchronized void inc() {
        c++;
    }
}
