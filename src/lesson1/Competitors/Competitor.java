package lesson1.Competitors;

public interface Competitor {
    void run(int distance);
    void swim(int distance);
    void jump(int distance);
    boolean isOnDistance();
    void showResult();
    void showInfo();
}
