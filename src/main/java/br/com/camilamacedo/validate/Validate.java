package br.com.camilamacedo.validate;

import br.com.camilamacedo.Parameters;

/**
 * Created by camilamacedo on 8/1/16.
 */
public interface Validate {
    public abstract <T> T validate(Parameters parameters) throws Exception;

}

