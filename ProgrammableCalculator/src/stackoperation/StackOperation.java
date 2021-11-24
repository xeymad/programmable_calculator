/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;
import calculatorstack.CalculatorStack;

/**
 * This abstract class provides the generic stack operation interface, and it contains a concrete istance of a calculator stack.
 * @author Matteo Di Rienzo
 */
public abstract class StackOperation {
    
    CalculatorStack calculatorStack;

    /**
    * Class constructor
     * @param calculatorStack istance of the calculator stack
    */
    public StackOperation(CalculatorStack calculatorStack) {
        this.calculatorStack = calculatorStack;
    }
    
    /**
    * Interface for the method which contains the operation logic
    */
    abstract public void execute();
    
}
