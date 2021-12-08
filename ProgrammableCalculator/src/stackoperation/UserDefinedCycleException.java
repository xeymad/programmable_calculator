/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

/**
 *
 * @author Giuseppe
 */
public class UserDefinedCycleException extends Exception{

    /**
     * Creates a new instance of <code>CycleException</code> without detail
     * message.
     */
    public UserDefinedCycleException() {
    }

    /**
     * Constructs an instance of <code>CycleException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UserDefinedCycleException(String msg) {
        super(msg);
    }
}
