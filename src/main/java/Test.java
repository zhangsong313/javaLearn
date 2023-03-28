import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    public static void main(String[] args) {

    }



    public static void testObject(){
        Worker worker = new Worker();
        System.out.println(worker.hashCode());
        System.out.println(ClassLayout.parseInstance(worker).toPrintable());
    }
    public static class Worker{
        private boolean id;
        private String name;
        private String age;
    }
}
