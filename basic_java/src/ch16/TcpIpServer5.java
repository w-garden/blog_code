package ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpServer5 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();

        System.out.println("서버가 준비되었습니다.");

        Sender sender = new Sender(socket);
        Receiver receiver = new Receiver(socket);

        sender.start();
        receiver.start();

    }

    static class Sender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;


        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (out != null) {
                try {
                    out.writeUTF(name + scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            super.run();
        }

        public Sender(Socket socket) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                name = "[" + socket.getInetAddress() + " : " + socket.getPort() + "] ";
            } catch (IOException e) {
            }

        }
    }

    static class Receiver extends Thread {
        Socket socket;
        DataInputStream in;

        public Receiver(Socket socket) {
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
                    e.printStackTrace();
                }
            }
        }
    }
}
