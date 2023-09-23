package input_output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);
        output.write(temp, 5, 5);
        //temp[5] 부터 5개의 데이터를 wirte 함. 바구니를 이용해서 한 번에 더 많은 물건을 옮길 수 있는 것과 같은 개념

        outSrc=output.toByteArray();
        System.out.println("Input Source = " + Arrays.toString(inSrc));
        System.out.println("temp = " + Arrays.toString(temp));
        System.out.println("Output Source = " + Arrays.toString(outSrc));
    }
}
