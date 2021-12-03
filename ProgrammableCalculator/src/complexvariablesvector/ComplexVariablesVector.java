/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexvariablesvector;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.complex.Complex;

/**
 * This class implements a vector of 26 complex variables.Each variable is associated with a letter of the alphabet.
 * The indexes of the array in ascending order correspond to the 26 letters of the alphabet in alphabetical order.
 * The element in position 0 corresponds to the content of the variable 'a', the element in position 1 to the content
 * of the variable 'b' and so on.
 * 
 * @author Arianna Carratù
 */
public class ComplexVariablesVector implements Iterable<ComplexVariable>{
    private static final int NUM_VARIABLES=26;
    private final ArrayList<ComplexVariable> variablesVector;
  
    /**
    * Class constructor.It initializes the content of the 26 variables to 0.
    */
    public ComplexVariablesVector() {
        variablesVector= new ArrayList<>();
        for(int i=0;i<NUM_VARIABLES;i++){
            variablesVector.add(i, new ComplexVariable((char)('a'+i),Complex.ZERO));
            
        }
        
    }

    /**
    * This method takes a variable's name and a complex number.It sets the variable's content with the specific complex number passed.
    * @param var The character of the alphabet that identifies the variable
    * @param val The complex number to set as variable's value
    */ 
    public void setVarValue(char var, Complex val) {
       variablesVector.get(var-'a').setComplex(val);
    }
    
    /**
    * This method returns the value of the variable identified by the passed character.
    * @param var The character of the alphabet that identifies the variable
    * @return Complex This returns the complex number contained in the variable
    */ 
    public Complex getVarValue(char var) {
        return variablesVector.get(var-'a').getComplex();
    }

    /**
    * This method returns an iterator over the elements of the vector, starting from the first.
    * @return Iterator an iterator over the elements of the vector
    */
    @Override
    public Iterator<ComplexVariable> iterator() {
        return variablesVector.iterator();
    }

    

}
