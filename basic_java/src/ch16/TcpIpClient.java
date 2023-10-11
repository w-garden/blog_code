package ch16;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CompletionException;

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIP = "127.0.0.1";

            System.out.println("서버에 연결중입니다. 서버 IP : " + serverIP);
            //소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIP, 7777);

            //소켓의 입력 스트림을 얻는다
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            //소켓으로 부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
            System.out.println("연결을 종료합니다.");

            dis.close();
            socket.close();
            System.out.println("연결이 종료되었습니다.");
        } catch (CompletionException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
