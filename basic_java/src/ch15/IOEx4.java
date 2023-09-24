package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

//IOEx3에 대한 수정
public class IOEx4 {
    public static void main(String[] args) {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("Input Source  : " + Arrays.toString(inSrc));

        try {

            while (input.available() > 0) {
                int len = input.read(temp);
                output.write(temp,0,len);

                outSrc = output.toByteArray();
                printArrays(temp, outSrc);
            }
        } catch (IOException e) {

        }
    }

    private static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp          : "+Arrays.toString(temp));
        System.out.println("Output Source : "+Arrays.toString(outSrc));
    }
}
