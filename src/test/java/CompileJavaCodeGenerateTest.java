import br.com.camilamacedo.CompileParameters;
import br.com.camilamacedo.context.CompileContext;
import org.junit.Test;

import java.nio.file.Files;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * Created by camilamacedo on 8/1/16.
 */
public class CompileJavaCodeGenerateTest {

    private static final UtilTest utilTest = new UtilTest();

    @Test
    public void testGenerateCompile()  {
        String fileName = "MyFileTest.java";
        CompileParameters compileParameters = new CompileParameters();
        compileParameters.setFileName(fileName);
        compileParameters.setIdlanguage(1);

        try {
            UtilTest.createValidCompileFile(fileName);
            assertTrue(CompileContext.generate.COMPILE_JAVA_CODE.generate(compileParameters));
            UtilTest.deleteValidCompileFile(fileName);
            UtilTest.deleteValidCompileFile(fileName.replace(".java",".class"));
        } catch (Exception e){
            fail("Exception was occurred :" + e.getMessage());
        }


    }

    @Test
    public void testGenerateNotCompile()  {
        String fileName = "MyFileTestFail.java";
        CompileParameters compileParameters = new CompileParameters();
        compileParameters.setFileName(fileName);
        compileParameters.setIdlanguage(1);
        try {
            UtilTest.createInValidCompileFile(fileName);
            assertFalse(CompileContext.generate.COMPILE_JAVA_CODE.generate(compileParameters));
            UtilTest.deleteValidCompileFile(fileName);
        } catch (Exception e){
            fail("Exception was occurred :" + e.getMessage());
        }
    }
}
