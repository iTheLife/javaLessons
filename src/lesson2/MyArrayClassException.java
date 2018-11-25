package lesson2;

public class MyArrayClassException extends RuntimeException {
    public MyArrayClassException() {
        super("Получен массив недопустимого размера");
    }
}
