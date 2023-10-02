package ch15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 조상으로부터 상속받은 인스턴스변수에 대한 직렬화를 구현
 */
class SuperUserInfo {
    String name;
    String password;

    public SuperUserInfo() {
        this("Unknown", "1111");
    }

    public SuperUserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

public class UserInfo2 extends SuperUserInfo implements Serializable {
    int age;

    public UserInfo2() {
        this("Unknown", "1111", 0);
    }

    public UserInfo2(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeUTF(name);
        out.writeUTF(password);
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        password = in.readUTF();
        in.defaultReadObject();
    }

}
