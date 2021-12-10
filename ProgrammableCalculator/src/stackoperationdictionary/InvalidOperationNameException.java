/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperationdictionary;

/**
 * Thrown when trying to enter an invalid name for UserDefinedOperation
 * @author aferr
 */
public class InvalidOperationNameException extends Exception {

    public InvalidOperationNameException(String message) {
        super(message);
    }
    
}
