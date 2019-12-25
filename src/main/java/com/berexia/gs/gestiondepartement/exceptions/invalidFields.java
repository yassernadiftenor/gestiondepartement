package com.berexia.gs.gestiondepartement.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class invalidFields extends gestionDepartExcept {
    public static final Logger logger = LogManager.getLogger(gestionDepartExcept.class.getName());

    private static final long serialVersionUID = 1L;

    public invalidFields(String message) {
        super(message);
        logger.debug(message,this);
    }
}
