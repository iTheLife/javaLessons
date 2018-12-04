package lesson5;

public class Monitor {
    public static void main(String[] args) {

        new Thread(()->{method();}).start();
        new Thread(()->{method();}).start();
    }

    public synchronized static void method(){
        MainClass.printFor();
    }
}
