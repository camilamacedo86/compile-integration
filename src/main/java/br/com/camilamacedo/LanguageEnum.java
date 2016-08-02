package br.com.camilamacedo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by camilamacedo on 8/1/16.
 */
public enum LanguageEnum {

    JAVA(1,"Java", ".java");

    private String name;
    private Integer id;
    private String extensionFile;

    LanguageEnum(Integer id, String name, String extensionFile) {
        this.name = name;
        this.id=id;
        this.extensionFile = extensionFile;
    }

    public String getExtensionFile() {
        return extensionFile;
    }

    public Integer getId() {
        return id;
    }

    public static LanguageEnum getLanguageEnumById(Integer id){
        List<LanguageEnum> all = Arrays.asList(LanguageEnum.values());

        for(int i=0; i<all.size(); i++){
            if ( all.get(i).getId() == id){
                return all.get(i);
            }
        }
        return null;
    }

}
