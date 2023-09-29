package ch15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx4 {
    public static void main(String[] args) {
        String currDir = System.getProperty("user.dir");
        String upperDir = currDir.substring(0, currDir.lastIndexOf("\\"));
        System.out.println("currDir : " + currDir);
        System.out.println("upperDir : " + upperDir);
//        File dir = new File(currDir); //현재 디렉토리
        File dir = new File(upperDir); //상위 디렉토리
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            String name = f.getName();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mma");
            String attribute = "";
            String size = "";

            if (files[i].isDirectory()) {
                attribute = "DIR";
            } else {
                size = f.length() + "";
                attribute = f.canRead() ? "R" : " ";
                attribute += f.canWrite() ? "W" : " ";
                attribute += f.isHidden() ? "H" : " ";
            }
            System.out.printf("%s %3s %6s %s\n",
                    df.format(new Date(f.lastModified())), attribute, size, name);
        }
    }
}
