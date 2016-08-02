import br.com.camilamacedo.CompileParameters;
import br.com.camilamacedo.context.CompileContext;
import br.com.camilamacedo.context.CompileResources;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;

/**
 * Created by camilamacedo on 8/1/16.
 */
public class ValidateJavaCodeGenerateTest {

    @Test
    public void testHasntLanguageSelected()  {
        String fileName = "MyTest.java";
        CompileParameters compileParameters = new CompileParameters();
        compileParameters.setFileName(fileName);
        try {
            UtilTest.createValidCompileFile(fileName);
            String result = CompileContext.validate.VALIDATE_JAVA_CODE.validate(compileParameters);
            assertNotNull(result);
            assertEquals(CompileResources.getMessage("compile-integration.language.not_select"),result);
            UtilTest.deleteValidCompileFile(fileName);
        } catch (Exception e){
            fail("Exception was occurred :" + e.getMessage());
        }
    }

    @Test
    public void testIsLanguageNotSupported()  {
        String fileName = "MyTest.java";
        CompileParameters compileParameters = new CompileParameters();
        compileParameters.setFileName(fileName);
        compileParameters.setIdlanguage(3);
        try {
            UtilTest.createValidCompileFile(fileName);
            String result = CompileContext.validate.VALIDATE_JAVA_CODE.validate(compileParameters);
            assertNotNull(result);
            assertEquals(CompileResources.getMessage("compile-integration.unsupport.language"),result);
            UtilTest.deleteValidCompileFile(fileName);
        } catch (Exception e){
            fail("Exception was occurred :" + e.getMessage());
        }
    }


    @Test
    public void testIsFileNotCorrectFormat()  {
        String fileName = "MyTest.txt";
        CompileParameters compileParameters = new CompileParameters();
        compileParameters.setFileName(fileName);
        compileParameters.setIdlanguage(1);
        try {
            UtilTest.createValidCompileFile(fileName);
            String result = CompileContext.validate.VALIDATE_JAVA_CODE.validate(compileParameters);
            assertNotNull(result);
            assertEquals(CompileResources.getMessage("compile-integration.incorrect.file.format"),result);
            UtilTest.deleteValidCompileFile(fileName);
        } catch (Exception e){
            fail("Exception was occurred :" + e.getMessage());
        }
    }

    @Test
    public void testIsHasntFile()  {
        String fileName = "MyTest.java";
        CompileParameters compileParameters = new CompileParameters();
        compileParameters.setFileName(fileName);
        compileParameters.setIdlanguage(1);
        try {
            String result = CompileContext.validate.VALIDATE_JAVA_CODE.validate(compileParameters);
            assertNotNull(result);
            assertEquals(CompileResources.getMessage("compile-integration.file.not.found"),result);
        } catch (Exception e){
            fail("Exception was occurred :" + e.getMessage());
        }
    }

    @Test
    public void testAllValidationsPass()  {
        String fileName = "MyTest.java";
        CompileParameters compileParameters = new CompileParameters();
        compileParameters.setFileName(fileName);
        compileParameters.setIdlanguage(1);
        try {
            UtilTest.createValidCompileFile(fileName);
            Assert.assertNull(CompileContext.validate.VALIDATE_JAVA_CODE.validate(compileParameters));
            UtilTest.deleteValidCompileFile(fileName);
        } catch (Exception e){
            fail("Exception was occurred :" + e.getMessage());
        }
    }
}
