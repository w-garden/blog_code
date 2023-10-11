package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TcpIpServer4 implements Runnable {
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        //5개의 쓰레드를 생성하는 서버 생성
        TcpIpServer4 server = new TcpIpServer4(5);
        server.start();
    }

    private void start() {
        for (int i = 0; i < 5; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    public TcpIpServer4(int num) {
        try {
            //서버 소켓을 생성하여 7777번 포트와 결합시킨다.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");

            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(getTime() + "가 연결 요청을 기다립니다.");

                Socket socket = serverSocket.accept();

                System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("[Notice] Test Message4 form Server!!!");
                System.out.println(getTime() + " 데이터를 전송했습니다.");
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    static String getTime(){
        String name = Thread.currentThread().getName();
        SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
        return sdf.format(new Date())+name;
    }
}
