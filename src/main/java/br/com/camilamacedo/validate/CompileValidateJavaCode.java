package br.com.camilamacedo.validate;

import br.com.camilamacedo.CompileParameters;
import br.com.camilamacedo.LanguageEnum;
import br.com.camilamacedo.Parameters;
import br.com.camilamacedo.context.CompileResources;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by camilamacedo on 8/1/16.
 */
public class CompileValidateJavaCode implements Validate {

    private static final String PATH = CompileResources.getProperties("dir.files");
    private LanguageEnum languageEnumSelected ;

    @Override
    public String validate(Parameters parameters) throws Exception {
        CompileParameters compileParameters = (CompileParameters) parameters;

        if ( !hasLanguageSelected(compileParameters) ){
            return CompileResources.getMessage("compile-integration.language.not_select");
        }
        if ( !isLanguageSupported(compileParameters) ){
            return CompileResources.getMessage("compile-integration.unsupport.language");
        }
        if ( !isFileCorrectFormat(compileParameters) ){
            return CompileResources.getMessage("compile-integration.incorrect.file.format");
        }
        if ( !hasFile(compileParameters) ){
            return CompileResources.getMessage("compile-integration.file.not.found");
        }

        return null;
    }

    private boolean hasFile(CompileParameters compileParameters) {
        return Files.exists(Paths.get(PATH+compileParameters.getFileName()));
    }

    private boolean isFileCorrectFormat(CompileParameters compileParameters) {
        return compileParameters.getFileName().endsWith(this.languageEnumSelected.getExtensionFile());
    }

    private boolean isLanguageSupported(CompileParameters compileParameters) {
        this.languageEnumSelected = LanguageEnum.getLanguageEnumById(compileParameters.getIdlanguage());
        return this.languageEnumSelected != null;
    }

    private boolean hasLanguageSelected(CompileParameters compileParameters) {
        return compileParameters.getIdlanguage() != null;
    }
}
