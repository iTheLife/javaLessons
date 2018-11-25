package lesson2;

public class MyArrayDataException extends RuntimeException {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MyArrayDataException(int x, int y) {
        super(String.format("Произошел сбой в ячейке %d %d",x,y));
        this.x = x;
        this.y = y;
    }
}
