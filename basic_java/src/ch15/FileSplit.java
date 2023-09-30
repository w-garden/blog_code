package ch15;

import java.io.*;

public class FileSplit {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("USAGE : java FileSplit filename SIZE_KB");
            System.exit(0);
        }
        final int VOLUME = Integer.parseInt(args[1]) * 1000;

        try {
            String filename = args[0];
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));

            BufferedOutputStream bos = null;

            int data = 0;
            int i = 0;
            int number = 0;

            while ((data = bis.read()) != -1) {
                if (i % VOLUME == 0) {
                    if (i != 0) {
                        bos.close();
                    }
                    bos = new BufferedOutputStream(new FileOutputStream(filename + "_." + ++number));
                }
                bos.write(data);
                i++;
            }
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
