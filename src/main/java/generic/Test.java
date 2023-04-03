package generic;

import generic.genericClass.Tuple;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
//        testTuple();
        Random random = new Random(47);
//        Random random = new Random();
        System.out.println(random.nextInt(30));

    }

    /**
     * 有时候我们想返回多个对象。
     * 可以使用元组Tuple的形式
     */
    public static void testTuple(){
        Tuple<String, Integer> data = getData();
        System.out.println(data.a);
        System.out.println(data.b);

        // final类型不可变，因此使用者只能读不能写。想要赋值会发生编译错误。
//        data.a = "bbb";
    }
    private static Tuple<String, Integer> getData(){
        return new Tuple<>("aaa", 999);
    }
}


