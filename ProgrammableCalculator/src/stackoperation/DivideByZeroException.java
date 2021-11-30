/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

/**
 *
 * @author Matteo Di Rienzo
 */
public class DivideByZeroException extends RuntimeException {

    /**
     * Creates a new instance of <code>DivideByZeroException</code> without
     * detail message.
     */
    public DivideByZeroException() {
    }

    /**
     * Constructs an instance of <code>DivideByZeroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DivideByZeroException(String msg) {
        super(msg);
    }
}
