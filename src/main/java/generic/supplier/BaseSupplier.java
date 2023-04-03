package generic.supplier;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class BaseSupplier<T> implements Supplier<T> {

    private Class<T> type;
    /**
     * 泛型类的构造方法名后不要跟泛型
     */
    public BaseSupplier(Class<T> clazz){
        this.type = clazz;
    }

    /**
     * 反射生成对象。
     */
    @Override
    public T get() {
        try {
            return type.getConstructor().newInstance();
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提供静态方法，比使用构造器好一些。
     */
    public static <E> Supplier<E> create(Class<E> clazz){
        return new BaseSupplier<>(clazz);
    }

    public static void main(String[] args) {
        BaseSupplier<String> s = new BaseSupplier<>(String.class);
        String s1 = s.get();
        System.out.println(s1);

        Supplier<String> ss = BaseSupplier.create(String.class);
        String s2 = ss.get();
        System.out.println(s2);

        // 没有无参构造的类型会报错。
//        Supplier<Integer> is = BaseSupplier.create(Integer.class);
//        Integer i = is.get();
//        System.out.println(i);
    }
}
