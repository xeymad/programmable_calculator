/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexvariablesvector;

import org.apache.commons.math3.complex.Complex;

/**
 * Wrapper Object used for display a complex Variable as its key and value.
 * @author giuse
 */
public class ComplexVariable {
    
    private final char character;
    private Complex complex;

    public ComplexVariable(char character, Complex complex) {
        this.character = character;
        this.complex = complex;
    }

    public char getCharacter() {
        return character;
    }

    public Complex getComplex() {
        return complex;
    }

    public void setComplex(Complex complex) {
        this.complex = complex;
    }
    
    
}
