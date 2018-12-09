package lesson5.HomeWork;

public class MainClass {
    private static Object concat;
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {

        concat = new Object();
        method1();
        method2();
    }

    private static void method1() {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void method2() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            calculate(a1, 0);
            //System.out.println("Первый поток закончил вычисления");
            synchronized (concat) {
                //System.out.println("Первый поток начал склейку");
                System.arraycopy(a1, 0, arr, 0, h);
            }
        });
        Thread t2 = new Thread(() -> {
            calculate(a2, h);
            //System.out.println("Второй поток закончил вычисления");
            synchronized (concat) {
                //System.out.println("Второй поток начал склейку");
                System.arraycopy(a2, 0, arr, h, h);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - a);

    }

    private static void calculate(float[] a2, int offset) {
        for (int i = 0; i < h; i++) {
            int j = i + offset;
            a2[i] = (float) (a2[i] * Math.sin(0.2f +j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));

        }
    }
}

