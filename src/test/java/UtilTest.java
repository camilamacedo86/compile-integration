import br.com.camilamacedo.context.CompileResources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by camilamacedo on 8/1/16.
 */
public class UtilTest {

    private static final String PATH = CompileResources.getProperties("dir.files");

    public static void createValidCompileFile(String name) throws IOException{
        List<String> lines = new ArrayList<String>();
        lines.add("public class "+ name.replace(".java","") +" {");
        lines.add("public static void main(String[] args) {");
        lines.add("System.out.println(\"HI\");");
        lines.add("System.out.println(\"HI\");");
        lines.add("}");
        lines.add("}");
        Files.write(Paths.get(PATH+name), lines);
    }

    public static void deleteValidCompileFile(String name) throws IOException{
        Files.delete(Paths.get(PATH+name));
    }



    public static  void createInValidCompileFile(String name) throws IOException{
        List<String> lines = new ArrayList<String>();
        lines.add("public class MyTest {");
        lines.add("public static void main(String[] args) {");
        lines.add("System.out");
        lines.add("}");
        lines.add("}");
        Files.write(Paths.get(PATH+name), lines);
    }


}
