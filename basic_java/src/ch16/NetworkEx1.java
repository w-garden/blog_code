package ch16;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkEx1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("ip.getHostName() = " + ip.getHostName()); //host의 이름을 반환
            System.out.println("ip.getHostAddress() = " + ip.getHostAddress()); //host의 IP주소를 반환
            System.out.println("ip.toString() = " + ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress() =" + Arrays.toString(ipAddr));

            String result = "";
            for (int i = 0; i < ipAddr.length; i++) {
                result += ((ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i]) + ".";
            }
            System.out.println("getAddress()+256 : " + result);
            System.out.println();
        } catch (UnknownHostException e) {
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("ip.getHostName() = " + ip.getHostName());
            System.out.println("ip.getHostAddress() = " + ip.getHostAddress());
            System.out.println();
        } catch (UnknownHostException e) {
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for (int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr[" + i + "] : " + ipArr[i]);
            }
        } catch (UnknownHostException e) {
        }
    }
}
