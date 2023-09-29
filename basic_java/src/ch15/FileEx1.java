package ch15;

import java.io.File;

public class FileEx1 {
    public static void main(String[] args) {
        File f = new File("E:\\blog_code\\basic_java\\src\\ch15\\FileEx1.java");
        String fileName = f.getName();
        int pos = fileName.lastIndexOf(".");
        System.out.println(f.getPath());
        System.out.println(f.separatorChar);



    }
}
