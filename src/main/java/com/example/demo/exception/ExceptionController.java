package com.example.demo.exception;

import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 4:39<br>
 * todo javadoc
 */
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleServiceException(ServiceException ex) {
        if (ex.isNeedLogging()) {
            logger.error(ex.getMessage(), ex);
        }
        return ex.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(RuntimeException ex) {
        logger.error(ex.getMessage(), ex);
        return ex.getMessage();
    }
}

