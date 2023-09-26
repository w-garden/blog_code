package ch15;

import java.io.*;

/**
 * DataOutputStreamEx1에서 만든 sample.dat를 DataInputStream을 통해서 읽는 예제 코드
 */
public class DataInputStreamEx1 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("sample.dat");
        DataInputStream dis = new DataInputStream(fis);
        try {

            System.out.println(dis.readInt()); //write한 순서대로 출력해야 한다
            System.out.println(dis.readFloat());
            System.out.println(dis.readBoolean());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
