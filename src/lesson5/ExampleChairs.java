package lesson5;

public class ExampleChairs {

    public static void main(String[] args) {
        Object стул1 = new Object();

        Thread человек1 = new Thread(()->{
            System.out.println("Человек 1 подошел к стулу1");
           synchronized (стул1){
               System.out.println("Чел1 сел на стул1");
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("Человек 1 встал со стула1");
           }
        });

        человек1.start();

        Thread человек2 = new Thread(()->{
            System.out.println("Человек 2 подошел к стулу1");
            synchronized (стул1){
                System.out.println("Чел2 сел на стул1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 2 встал со стула1");
            }
        });

        человек2.start();

        Thread человек3 = new Thread(()->{
            System.out.println("Человек 3 подошел к стулу1");
            synchronized (стул1){
                System.out.println("Чел3 сел на стул1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 3 встал со стула1");
            }
        });

        человек3.start();

        Thread человек4 = new Thread(()->{
            System.out.println("Человек 4 подошел к стулу1");
            synchronized (стул1){
                System.out.println("Чел4 сел на стул1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 4 встал со стула1");
            }
        });

        человек4.start();

    }
}
