package com.berexia.gs.gestiondepartement.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class emptyFields extends gestionDepartExcept {
    private String msg;
    private static final long serialVersionUID = 1L;
    public static final Logger logger = LogManager.getLogger(gestionDepartExcept.class.getName());
    public emptyFields(String message) {
        super(message);
        logger.debug(message,this);
    }
}
