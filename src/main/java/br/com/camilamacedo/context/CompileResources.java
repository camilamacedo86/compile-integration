package br.com.camilamacedo.context;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class CompileResources {
    private static final ResourceBundle PROPERTIES = ResourceBundle.getBundle("compile", Locale.getDefault());
    private static final ResourceBundle MESSAGENS = ResourceBundle.getBundle("compile_messages", Locale.getDefault());

    private CompileResources() {

    }

    public static final String getMessage(String key, Object... params) {
        return MessageFormat.format(MESSAGENS.getString(key), params);
    }

    public static final String getProperties(String key, Object... params) {
        return MessageFormat.format(PROPERTIES.getString(key), params);
    }

}