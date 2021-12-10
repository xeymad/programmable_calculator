/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperationdictionary;

/**
 * Thrown when trying to insert a non-existent operation
 * @author aferr
 */
class InvalidOperationsException extends Exception {
    
    public InvalidOperationsException(){
    
    }
    
    public InvalidOperationsException(String message){
        super(message);
    }
}
