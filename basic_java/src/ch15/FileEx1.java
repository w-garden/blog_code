package ch15;

import java.io.File;

/**
 *  주로 자료실 예제 쓰임
 */
public class FileEx1 {
    public static void main(String[] args) {
        //경로를 세팅
        String path = "C:\\Users\\shc72\\";
        File dir = new File(path);
        String[] lists = dir.list(); //list() -> 경로의 모든 파일의 이름을 출력
        for (String s : lists) {
            File f = new File(path + "/" + s);
            System.out.println("===================");
            System.out.println("파일 이름 : " + f.getName());  //파일 이름 반환
            System.out.println("경로 : " + f.getPath());      // 파일 경로 반환
            System.out.println("부모 경로 : " + f.getParent());   //부모 경로 반환
            System.out.println("절대 경로 : " + f.getAbsolutePath());  // 절대 경로 반환
            System.out.println("디렉토리 여부 : " + f.isDirectory());
            //폴더이면 참, 아니면 거짓
            System.out.println("파일 여부 : " + f.isFile());  //파일이면 참, 아니면 거짓
        }//for

    }
}
