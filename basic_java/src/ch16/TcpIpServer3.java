package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import static ch16.TcpIpServer.getTime;

public class TcpIpServer3 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println(getTime() + "연결 요청을 기다립니다.");
                //요청 대기시간을 5초로한다.
                //5초동안 접속 요청이 없으면 SocketTimeoutException이 발생한다.
                serverSocket.setSoTimeout(5 * 1000);
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 연결 요청이 들어왔습니다.");

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("[NOTICE] Test Message3 from Server");
                dos.writeUTF("Hello everyone!");

                System.out.println(getTime() + "데이터 전송완료!!");

                dos.close();
                socket.close();

            } catch (SocketTimeoutException e) {
                System.out.println("지정된 시간동안 접속 요청이 없어서 서버를 종료합니다.");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
