package nio.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws IOException {



        Map<String, String> map = new HashMap<>();
        map.put("name", "zs");
        map.put("age", "18");
//        List<Object> collect = Files.readAllLines(
//                new File("src/main/resources/test.properties").toPath())
//                .stream()
//                .map(line -> replaceValue(line, map))
//                .collect(Collectors.toList());
//
//        List<String> lines = new LinkedList<>();
//        for (Object o : collect) {
//            lines.add((String)o);
//        }
//
//        Files.write(new File("src/main/resources/test2.properties").toPath(), lines);


        try(
                Stream<String> input =
                        Files.lines(new File("src/main/resources/test.properties").toPath());
                PrintWriter output =
                        new PrintWriter("src/main/resources/dev/test2.properties")
        ) {
            input.map(line -> replaceValue(line, map))
                    .forEachOrdered(output::println);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String replaceValue(String line, Map<String, String> map){
        if(line.startsWith("#")){
            return line;
        }
        String[] split = line.split("=");
        String key = split[0];
        if (map.containsKey(key)) {
            return key+"="+map.get(key);
        }
        return line;
    }
}
