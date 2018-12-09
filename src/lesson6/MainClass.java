package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Server started... Waitin clients");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while(true){
                String msg = in.readUTF();
                System.out.println("from client: " + msg);
                out.writeUTF("echo: " + msg);

                if(msg.equalsIgnoreCase("/end")) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
