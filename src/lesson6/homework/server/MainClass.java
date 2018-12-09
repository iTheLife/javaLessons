package lesson6.homework.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    static Scanner inConsole;
    static DataInputStream in;
    static DataOutputStream out;

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        System.out.println(str);

        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server started... Waiting clients...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.. adress: " + socket.getInetAddress() +" port: " + socket.getPort());
            Thread t = new Thread(() -> {
                try {
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
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
                    System.out.println("from client: " + msg);
                }
            });

            Thread tIn = new Thread(() -> {
                inConsole = new Scanner(System.in);
                while (true) {
                    String msgTo = null;
                    msgTo = inConsole.nextLine();
                    sendMsg(msgTo);
                }
            });
            tIn.setDaemon(true);
            tIn.start();
            t.setDaemon(true);
            t.start();
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
