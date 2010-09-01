/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ujuzi.api;

/**
 *
 * @author Ahmed Maawy
 */
public class ApiException extends Exception {

    /**
     * Creates a new instance of <code>ApiException</code> without detail message.
     */

    public ApiException() {
    }


    /**
     * Constructs an instance of <code>ApiException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ApiException(String msg) {
        super(msg);
    }
}
