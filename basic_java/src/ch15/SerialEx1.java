package ch15;

import java.io.*;
import java.util.ArrayList;

public class SerialEx1 {
    public static void main(String[] args) {
        serialization();
        deserialization();
    }

    private static void deserialization() {
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("UserInfo.ser")));
            System.out.println("역직렬화된 객체 출력");
            System.out.println(in.readObject());
            System.out.println( in.readObject());
            System.out.println(in.readObject());
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serialization() {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("UserInfo.ser"));

            ObjectOutputStream out = new ObjectOutputStream(bos);

            UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
            UserInfo u2 = new UserInfo("JavaWoman", "4321", 40);

            ArrayList<UserInfo> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.out.println("직렬화가 잘 끝났습니다");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
