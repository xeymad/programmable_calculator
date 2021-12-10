/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexvariablesvector;

import org.apache.commons.math3.complex.Complex;

/**
 * Wrapper Object used for display a complex Variable as its key (character) and value (complex number).
 * @author giuse
 */
public class ComplexVariable {
    
    private final char character;
    private Complex complex;

    /**
     * Class constructor.
     * @param character the character that identifies the variable
     * @param complex the complex number in the variable
     */
    public ComplexVariable(char character, Complex complex) {
        this.character = character;
        this.complex = complex;
    }
    
    /**
     * This method returns the character that identifies the variable.
     * @return char  the character that identifies the variable
     */ 
    public char getCharacter() {
        return character;
    }

    /**
     * This method returns the complex number contained in the variable.
     * @return Complex the complex number in the variable
     */ 
    public Complex getComplex() {
        return complex;
    }

    /**
     * This method sets the complex number contained in the variable with the given number complex.
     * @param complex the complex number to set in the variable
     */
    public void setComplex(Complex complex) {
        this.complex = complex;
    }
    
    
}
