package ch15;

import java.io.*;

public class DataOutputStreamEx1 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("sample.dat");
            dos = new DataOutputStream(fos);
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = new FileInputStream("sample.dat");
        DataInputStream dis = new DataInputStream(fis);

        try{
            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readBoolean());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
