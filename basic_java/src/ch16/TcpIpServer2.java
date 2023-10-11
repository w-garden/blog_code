package ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static ch16.TcpIpServer.getTime;

public class TcpIpServer2 {
    public static void main(String[] args) {


    ServerSocket serverSocket = null;
    try{
        //서버 소켓을 생성하여 7777번 포트와 결합(bind)시킴
        serverSocket = new ServerSocket(7777);
        System.out.println(getTime() +"서버가 준비되었습니다.");
    }catch(IOException e){
        e.printStackTrace();
    }

    while (true){
        try{
            //서버 소켓
            System.out.println(getTime()+"연결 요청을 기다립니다.");
            Socket socket = serverSocket.accept();
            System.out.println(getTime()+socket.getInetAddress()+"로부터 연결 요청이 들어왔습니다.");
            System.out.println("getPort() : " + socket.getPort());
            System.out.println("getLocalPort() : " + socket.getLocalPort());

            //소켓의 출력스트림을 얻는다.
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            //원격 소켓(remore socket)에 데이터를 보낸다.
            dos.writeUTF("[Notice] Test Message2 from Server");
            System.out.println(getTime()+"데이터를 전송했습니다.");

            dos.close();
            socket.close();
        }catch (IOException e){e.printStackTrace();}
    }
    }

}
