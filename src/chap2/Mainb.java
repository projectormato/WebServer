package chap2;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Mainb {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        String url = "./src/HTML/get.html";
        Path pathObj = fs.getPath(url);
        Path realPath = null;
        try {
            realPath = pathObj.toRealPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(realPath.toString());
    }
}
