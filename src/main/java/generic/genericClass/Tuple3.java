package generic.genericClass;

public class Tuple3<A, B, C> extends Tuple<A, B> {
    public final C c ;
    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }
}
