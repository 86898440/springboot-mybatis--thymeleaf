package com.yungo.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by cx on 17-8-2.
 */

@RestControllerAdvice
public class MyException {

    @ExceptionHandler(value = { RuntimeException.class })


   /* @ResponseStatus(HttpStatus.BAD_REQUEST)*/
    public Map excptionHandle(){
        Map map = new HashMap();
        map.put("erro",500);
        return map;
    }
}
