package test;

public class Derived extends Base {
//    public void sth(){
//        super.
//    }
    @Override
    public void print() {
        System.out.println("from derived");
    }

    public void msg(){
        System.out.println("message from child");
    }
}
