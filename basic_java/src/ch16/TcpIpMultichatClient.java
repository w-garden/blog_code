package ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpMultichatClient {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USEAGE : java TcpIpMultichatClient 대화명");
            System.exit(0);
        }
        try {
            String serverIp = "127.0.0.1";
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결했습니다.");
            Thread sender = new Thread(new ClientSender(socket, args[0]));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;

        public ClientSender(Socket socket, String name) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                this.name = name;
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                if (out != null) {
                    out.writeUTF(name);
                }
                while (true) {

                    out.writeUTF("[" + name + "]" + scanner.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;


        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                }
            }
        }
    }
}