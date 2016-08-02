package br.com.camilamacedo.context;


import br.com.camilamacedo.CompileParameters;
import br.com.camilamacedo.Parameters;
import br.com.camilamacedo.generate.CompileJavaCodeGenerate;
import br.com.camilamacedo.generate.Generate;
import br.com.camilamacedo.validate.CompileValidateJavaCode;
import br.com.camilamacedo.validate.Validate;

public class CompileContext {
    public enum generate implements Generate {
        COMPILE_JAVA_CODE(new CompileJavaCodeGenerate());
        private Generate delegate;

        private generate(Generate delegate) {
            this.delegate = delegate;
        }

        @Override
        public <T> T generate(Parameters parameters) throws Exception {
            return this.delegate.generate(parameters);
        }
    }

    public enum validate implements Validate {
        VALIDATE_JAVA_CODE(new CompileValidateJavaCode());

        private Validate delegate;

        private validate(Validate delegate) {
            this.delegate = delegate;
        }

        @Override
        public <T> T validate(Parameters parameters) throws Exception {
            return this.delegate.validate(parameters);
        }
    }


    public static final CompileParameters getParameters() {
        return new CompileParameters();
    }
}
