package lesson5;

import javax.swing.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    Object mon = new Object();

    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//        t1.start();
//        t2.start();
//
//        Thread t3 = new Thread(new MyRunnable());
//        Thread t4 = new Thread(new MyRunnable());
//        t3.start();
//        t4.start();

//        Thread t1 = new Thread(()-> System.out.println("A"));
//        Thread t2 = new Thread(()-> System.out.println("B"));
//        t1.start();
//        t2.start();

//        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.execute(() -> {
//            System.out.println("A");
//        });
//        service.shutdown();
//        new Thread(() -> {
////            for (int i = 0; i < 10; i++) {
////                System.out.println(i);
////            }
////        }).start();

//        Thread t1 = new Thread(()-> System.out.println("A"));
//        t1.setPriority(5);
//        t1.start();

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <5 ; i++) {
//                    System.out.println(i);
//                }
//            }
//        });
//
//        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");

//        Thread c = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int time=0;
//                while(true){
//                    time++;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(time);
//                }
//            }
//        });
//        c.setDaemon(true);
//        c.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");

//        Counter counter = new Counter();
//
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <1000000 ; i++) {
//                    counter.inc();
//                }
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i< 10000000 ; i++) {
//                    counter.dec();
//                }
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(counter.value());
        MainClass mc = new MainClass();
        new Thread(() -> {
            mc.method1();
        }).start();
        new Thread(() -> {
            mc.method1();
        }).start();


    }

    public void method1() {
        System.out.println("Block1 begin");
        printFor();
        System.out.println("Block1 end");
        synchronized (mon) {
            System.out.println("Synch block begin");
            printFor();
            System.out.println("Synch block end");
        }

    }

    static void printFor() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
