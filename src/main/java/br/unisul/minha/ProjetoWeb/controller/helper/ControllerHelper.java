package br.unisul.minha.ProjetoWeb.controller.helper;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ControllerHelper {

    public static String getErrors(BindingResult result) {
        String errors = "\"errors\": [";
        for (ObjectError error : result.getAllErrors())
            errors += "{\"object\": \"" + error.getObjectName() + "\", " +
                    "\"message\": \"" + error.getDefaultMessage() + "\"},";
        if(errors.endsWith(","))
            errors = errors.substring(0, errors.length() -1);
        errors += "]";
        return errors;
    }
}
