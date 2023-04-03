package generic.genericClass;

/**
 * 在类作为对象容器时，使用泛型。
 */
public class Tuple<A, B> {
    // 使用public final比private+get方法更简洁。
    public final A a;
    public final B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }
}