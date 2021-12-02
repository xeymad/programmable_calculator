/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variablesvector;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.complex.Complex;

/**
 * This class implements a vector of 26 complex numbers.Each number is associated with a letter of the alphabet.
 * The indexes of the array in ascending order correspond to the 26 letters of the alphabet in alphabetical order.
 * The element in position 0 corresponds to the content of the variable 'a', the element in position 1 to the content
 * of the variable 'b' and so on.
 * 
 * @author Arianna Carratù
 */
public class VariablesVector {
    private ArrayList<Complex> variablesVector;

    /**
    * Class constructor.It initializes the content of the 26 variables to 0.
    */
    public VariablesVector() {
        variablesVector= new ArrayList<Complex>();
        for(int i=0;i<26;i++){
            variablesVector.add(i, Complex.ZERO);
        }
        
    }

    /**
    * This method takes a variable's name and a complex number.It sets the variable's content with the specific complex number passed.
    * @param var The character of the alphabet that identifies the variable
    * @param val The complex number to set as variable's value
    */ 
    public void setVarValue(char var, Complex val) {
       variablesVector.add(var-'a', val);
    }
    
    /**
    * This method returns the value of the variable identified by the passed character.
    * @param var The character of the alphabet that identifies the variable
    * @return Complex This returns the complex number contained in the variable
    */ 
    public Complex getVarValue(char var) {
        return variablesVector.get(var-'a');
    }
    
    /**
    * This method returns an iterator over the elements of the vector, starting from the first.
    * @return Iterator an iterator over the elements of the vector
    */
    public Iterator<Complex> iterator() {
        return variablesVector.iterator();
    }
    
}
