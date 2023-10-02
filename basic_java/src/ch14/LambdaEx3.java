package ch14;

import java.util.function.Supplier;

@FunctionalInterface
interface MyFunction3 {
    void myMethod(String str);

}
class Outer {
    int val = 10;

    class Inner {
        int val = 20;

        void method(int i) {
            int val = 30;
            //i = 10;

            MyFunction3 f = (e) ->{
                System.out.println("i\t\t\t\t: "+ i);
                System.out.println("val\t\t\t\t: "+ val);
                System.out.println("this.val\t\t: "+ ++this.val);
                System.out.println("Outer.this.val\t: "+ ++Outer.this.val);
                System.out.println("parameter\t\t: "+ e);
            };

            f.myMethod("매개변수");
        }
    }
}

public class LambdaEx3 {


    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }

}

