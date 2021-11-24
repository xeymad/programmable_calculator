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
 *
 * @author aferr
 */
public class StackOperationDictionary {
    
    private Map<String, StackOperation> dict;
    
    public StackOperationDictionary(CalculatorStack calculatorStack){
        dict = new HashMap<>();
        
        StackOperation sumStackOperation = new SumStackOperation(calculatorStack);
        StackOperation subtractionStackOperation = new SubtractionStackOperation(calculatorStack);
        
        dict.put("+", sumStackOperation);
        dict.put("-", subtractionStackOperation);
    }
    
    public StackOperation getOperation(String name){
        return dict.get(name);
    }
    
    public void putOperation(String name, StackOperation operation){
        dict.put(name, operation);
    }
    
    public StackOperation removeOperation(String name){
        return dict.remove(name);
    }
    
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
    
    public boolean containsKey(String name){
        return dict.containsKey(name);
    }
    
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
