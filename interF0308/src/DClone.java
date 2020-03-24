public class DClone {
    static class A implements Cloneable{
        public  int num = 0;

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }
    }

    static class B implements Cloneable{
        public A a = new A();

        @Override
        protected B clone() throws CloneNotSupportedException {
            return (B)super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        B b2 = b.clone();
        b.a.num = 10;
        System.out.println(b2.a.num);
    }
}
