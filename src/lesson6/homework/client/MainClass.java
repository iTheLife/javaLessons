package lesson6.homework.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    final static String SERVER_IP = "localhost";
    final static int SERVER_PORT = 8189;
    static Scanner inConsole;
    static DataInputStream in;
    static DataOutputStream out;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            Thread t = new Thread(() -> {
                inConsole = new Scanner(System.in);
                while (true) {

                    String s = inConsole.nextLine();
//                    System.out.println("from client: " + s);
                    sendMsg(s);
                }
            });

            Thread tIn = new Thread(() -> {
                try {
                    out = new DataOutputStream(socket.getOutputStream());
                    in = new DataInputStream(socket.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while (true) {
                    String msg = null;
                    try {
                        msg = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("from server: " + msg);
                }
            });
            t.setDaemon(true);
            t.start();
            tIn.setDaemon(true);
            tIn.start();
            tIn.join();
            t.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
