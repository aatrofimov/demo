package com.example.demo.exception;

/**
 * Created by IntelliJ IDEA.<br>
 * User: Alexey<br>
 * Date: 04.07.2017<br>
 * Time: 4:41<br>
 * todo javadoc
 */
public class ServiceException extends Exception {

    private boolean needLogging = false;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(boolean needLogging) {
        super();
        this.needLogging = needLogging;
    }

    public ServiceException(String message, boolean needLogging) {
        super(message);
        this.needLogging = needLogging;
    }

    public boolean isNeedLogging() {
        return needLogging;
    }

    public void setNeedLogging(boolean needLogging) {
        this.needLogging = needLogging;
    }
}
