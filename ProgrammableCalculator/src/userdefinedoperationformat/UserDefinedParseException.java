/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdefinedoperationformat;

/**
 *
 * @author giuse
 */
public class UserDefinedParseException extends Exception {

    /**
     * Creates a new instance of <code>UserDefinedParseException</code> without
     * detail message.
     */
    public UserDefinedParseException() {
    }

    /**
     * Constructs an instance of <code>UserDefinedParseException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserDefinedParseException(String msg) {
        super(msg);
    }
}
