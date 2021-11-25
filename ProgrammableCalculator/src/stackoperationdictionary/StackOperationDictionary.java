/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperationdictionary;

import java.util.Map;
import java.util.HashMap;
import calculatorstack.*;
import stackoperation.*;

/**
 * This class represent a Dictionary that contains associations between an
 * operation and it's name.
 * @author aferr
 */
public class StackOperationDictionary {
    
    private Map<String, StackOperation> dict;
    
    /**
     * The dictionary is initialized with the following entries: <br>
     * - &lt;"+", SumStackOperation&;gt <br>
     * - &lt;"-", SubtractionStackOperation;gt <br>
     * @param calculatorStack represent the stack to which the operations refer.
     */
    public StackOperationDictionary(CalculatorStack calculatorStack){
        dict = new HashMap<>();
        
        StackOperation sumStackOperation = new SumStackOperation(calculatorStack);
        StackOperation subtractionStackOperation = new SubtractionStackOperation(calculatorStack);
        
        dict.put("+", sumStackOperation);
        dict.put("-", subtractionStackOperation);
    }
    
    /**
     * Return the operation to which the specified name is mapped.
     * @param name the name whose associated operation is to be returned.
     * @return the operation to which the specified name is mapped, or null
     * if this dictionary contains no mapping for the name.
     */
    public StackOperation getOperation(String name){
        return dict.get(name);
    }
    
    /**
     * Associates the specified name with the specified operation in this dictionary.
     * @param name the operation's name.
     * @param operation the operation associated with the specified name.
     */
    public void putOperation(String name, StackOperation operation){
        dict.put(name, operation);
    }
    
    /**
     * Removes the mapping for the specified name in this dictionary if present.
     * @param name name whose mapping is to be removed from the dictionary.
     * @return the previous operation associated with the name, or null if there was
     * no mapping for the name.
     */
    public StackOperation removeOperation(String name){
        return dict.remove(name);
    }
    
    /**
     * Change the name associated with an operation.
     * @param name the name currently associated with an operation which 
     * should be changed.
     * @param newName the new name which should be associated with the
     * operation.
     * @return True if name has been changed, false if the specified name
     * was not present in the dictionary.
     */
    public boolean renameOperation(String name, String newName){
        if (dict.containsKey(newName)){
            return false;
        }
        else{
            StackOperation operation = dict.get(name);
            dict.put(newName, operation);
            return true;
        }
    }
    
    /**
     * Returns true if this dictionary contains a mapping for the specified name.
     * @param name the name whose presence in this dictionary is to be tested.
     * @return true if this dictionary contains a mapping for the specified name.
     */
    public boolean containsKey(String name){
        return dict.containsKey(name);
    }
    
    /**
     * Execute the operation associated with the specified name.
     * @param name the name whose operation has to be executed.
     * @return true if the operation was executed correctly, false if there was 
     * no mapping for the specified name.
     */
    public boolean execute(String name){
        if (!dict.containsKey(name)){
            return false;
        }
        else{
            StackOperation operation = dict.get(name);
            operation.execute();
            return true;
        }
    }
}
