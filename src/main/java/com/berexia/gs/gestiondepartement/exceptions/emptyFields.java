package com.berexia.gs.gestiondepartement.exceptions;

import jdk.internal.org.jline.utils.Log;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class emptyFields extends gestionDepartExcept {
    private String msg;
    private static final long serialVersionUID = 1L;

    public emptyFields(String message) {
        super(message);
        this.msg=message;
        Log.debug(message,this);
    }
}
