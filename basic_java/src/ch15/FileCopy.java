package ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 단순히 FileCopy.java의 내용 그대로를 읽어서
 * FileCopy.bak에 복사한다.
 * java FileCopy.java FileCopy.java FileCopy.bak
 */
public class FileCopy {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1], false);

            int data =0;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            fis.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
