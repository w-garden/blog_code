package ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }
            bos.close(); //12345 write 후 나머지 6789도 write 됨
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
