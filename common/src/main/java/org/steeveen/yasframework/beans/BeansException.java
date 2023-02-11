package org.steeveen.yasframework.beans;

/**
 * @author steeveen
 * @date 2023/2/11
 */
public class BeansException extends Exception {
    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(String message) {
        super(message);
    }
}