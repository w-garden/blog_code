package ch15;

import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {
    public static void main(String[] args) {
        serialization();
        deserialization();
    }

    private static void serialization() {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("UserInfo2.ser"));

            ObjectOutputStream out = new ObjectOutputStream(bos);

            UserInfo2 u1 = new UserInfo2("JavaMan", "1234", 30);
            UserInfo2 u2 = new UserInfo2("JavaWoman", "4321", 40);

            ArrayList<UserInfo2> list = new ArrayList<>();
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

    private static void deserialization() {
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("UserInfo2.ser")));

            UserInfo2 u1 = (UserInfo2) in.readObject();
            UserInfo2 u2 = (UserInfo2) in.readObject();
            ArrayList list = (ArrayList) in.readObject();

            System.out.println("역직렬화된 객체 출력");

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
