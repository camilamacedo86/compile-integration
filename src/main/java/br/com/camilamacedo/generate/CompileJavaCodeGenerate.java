package br.com.camilamacedo.generate;

import br.com.camilamacedo.CompileParameters;
import br.com.camilamacedo.Parameters;
import br.com.camilamacedo.context.CompileResources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class CompileJavaCodeGenerate implements Generate {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private static final String COMPILE_COMMAND = "javac ";
    private static final String PATH = CompileResources.getProperties("dir.files");

    @Override
    public Boolean generate(Parameters parameters) throws Exception {
        CompileParameters compileParameters = (CompileParameters) parameters;
        compileJavaFile(compileParameters);
        return Files.exists(Paths.get(PATH+compileParameters.getFileName().replace(".java",".class")));
    }

    private void compileJavaFile(CompileParameters compileParameters) {
        runCommand(COMPILE_COMMAND+PATH+compileParameters.getFileName());
    }

    private void runCommand(String command) {
        logger.info(CompileResources.getMessage("compile-integration.info.command", command));
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (IOException io) {
            logger.severe(CompileResources.getMessage("compile-integration.execute.command",command,io.getMessage()));
        } catch (InterruptedException ei){
            logger.severe(CompileResources.getMessage("compile-integration.witing.execution.command",ei.getMessage()));
        }

    }


}