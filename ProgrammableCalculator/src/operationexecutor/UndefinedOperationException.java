/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationexecutor;

/**
 * This Exception is thrown when the the client tries to execute an operation in 
 * OperationExecute, but the operation was not set
 * @author matteo
 */
public class UndefinedOperationException extends RuntimeException {

    /**
     * Creates a new instance of <code>UndefinedOperationExeption</code> without
     * detail message.
     */
    public UndefinedOperationException() {
    }

    /**
     * Constructs an instance of <code>UndefinedOperationExeption</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public UndefinedOperationException(String msg) {
        super(msg);
    }
}
