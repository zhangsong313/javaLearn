package nio.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
    /**
     * 逐行读写
     */
    private static void readAndWriteLines() {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        try (
                Stream<String> input =
                        Files.lines(new File("src/main/resources/test.properties").toPath());
                PrintWriter output =
                        new PrintWriter("src/main/resources/dev/test2.properties")
        ) {
            input.map(line -> replaceValue(line, map))
                    .forEachOrdered(output::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 逐行读取
     * 然后写出
     */
    private static void readLines() throws IOException {
        List<String> lines = Files.readAllLines(
                new File("src/main/resources/test.properties").toPath())
                .stream()
                .collect(Collectors.toList());
        System.out.println(lines);

        Files.write(new File("src/main/resources/test2.properties").toPath(), lines);
    }

    /**
     * 输出子目录。
     * @throws IOException
     */
    private static void accessDirectory() throws IOException {
        Files.newDirectoryStream(new File("src/main")
                .toPath()).iterator().forEachRemaining(path -> System.out.println(path.getFileName().toString()));
    }

    /**
     * 递归删除目录下所有文件
     * @throws IOException
     */
    public static void deleteRecurse() {
        String folderPath = "D:\\doc - 副本";
        File root = new File(folderPath);
        if (!root.isDirectory() || root.isFile()) {
            throw new RuntimeException("path is not dir.");
        }

        Stack<File> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            File folder = stack.pop();
            File[] nexts = folder.listFiles();
            // 没有子文件，直接删除。
            if(nexts==null) {
                System.out.println("delete :"+folder.getAbsolutePath());
                folder.delete();
                continue;
            }

            // 将当前文件夹压栈。
            stack.push(folder);

            boolean hasChildFolder = false;
            for (File next : nexts) {
                if (next.isFile()) {
                    // 有子文件，删除。
                    System.out.println("delete :"+next.getAbsolutePath());
                    next.delete();
                }
                if (next.isDirectory()) {
                    hasChildFolder = true;
                    stack.push(next);
                }
            }

            if(!hasChildFolder){
                // 没有子文件夹，删除当前文件夹。当前文件夹出栈。
                File pop = stack.pop();
                System.out.println("delete :"+pop.getAbsolutePath());
                folder.delete();
            }
        }
        return;
    }


    public static void main(String[] args) throws IOException {
//        accessDirectory();
//        deleteRecurse();
        int days = 3;
        System.out.println(0-days);
    }

    public static String replaceValue(String line, Map<String, String> map) {
        if (line.startsWith("#")) {
            return line;
        }
        String[] split = line.split("=");
        String key = split[0];
        if (map.containsKey(key)) {
            return key + "=" + map.get(key);
        }
        return line;
    }
}
