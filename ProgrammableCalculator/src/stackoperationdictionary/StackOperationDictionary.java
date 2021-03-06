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
import stackvariableoperation.*;
import stackvariableoperation.SumStackVariableOperation;
import complexvariablesvector.ComplexVariablesVector;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;
import org.apache.commons.math3.exception.MathParseException;

/**
 * This class represent a Dictionary that contains associations between an
 * operation and it's name.
 * @author group 02
 */
public class StackOperationDictionary {
    
    private Map<String, StackOperation> dict;
    private CalculatorStack calculatorStack;
    
    /**
     * The dictionary is initialized with the following entries: <br>
     * - &lt;"+", SumStackOperation&gt; <br>
     * - &lt;"-", SubtractionStackOperation&gt; <br>
     * - &lt;"*", MultiplicationStackOperation&gt; <br>
     * - &lt;"/", DivisionStackOperation&gt; <br>
     * - &lt;"sqrt", SqrtStackOperation&gt; <br>
     * - &lt;"+-", InvertSignStackOperation&gt; <br>
     * - &lt;"clear", ClearStackOperation&gt; <br>
     * - &lt;"drop", DropStackOperation&gt; <br>
     * - &lt;"dup", DupStackOperation&gt; <br>
     * - &lt;"swap", SwapStackOperation&gt; <br>
     * -- &lt;"over", OverStackOperation&gt; <br>
     * @param calculatorStack represent the stack to which the operations refer.
     * @param variablesVector represent the variables collection to which the operations refer.
     */
    public StackOperationDictionary(CalculatorStack calculatorStack, ComplexVariablesVector variablesVector){
        dict = new HashMap<>();
        this.calculatorStack = calculatorStack;
        
        StackOperation sumStackOperation = new SumStackOperation(calculatorStack);
        StackOperation subtractionStackOperation = new SubtractionStackOperation(calculatorStack);
        StackOperation multiplicationStackOperation = new MultiplicationStackOperation(calculatorStack);
        StackOperation divisionStackOperation = new DivisionStackOperation(calculatorStack);
        StackOperation sqrtStackOperation = new SqrtStackOperation(calculatorStack);
        StackOperation invertSignStackOperation = new InvertSignStackOperation(calculatorStack);
        StackOperation clearStackOperation = new ClearStackOperation(calculatorStack);
        StackOperation dropStackOperation = new DropStackOperation(calculatorStack);
        StackOperation dupStackOperation = new DupStackOperation(calculatorStack);
        StackOperation swapStackOperation = new SwapStackOperation(calculatorStack);
        StackOperation overStackOperation = new OverStackOperation(calculatorStack);
        
        dict.put("+", sumStackOperation);
        dict.put("-", subtractionStackOperation);
        dict.put("*", multiplicationStackOperation);
        dict.put("/", divisionStackOperation);
        dict.put("sqrt", sqrtStackOperation);
        dict.put("+-", invertSignStackOperation);
        dict.put("clear", clearStackOperation);
        dict.put("drop", dropStackOperation);
        dict.put("dup", dupStackOperation);
        dict.put("swap", swapStackOperation);
        dict.put("over", overStackOperation);
        
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet ++){
            dict.put("+"+alphabet, new SumStackVariableOperation(calculatorStack, variablesVector, alphabet));
            dict.put("-"+alphabet, new SubtractionStackVariableOperation(calculatorStack, variablesVector, alphabet));
            dict.put(">"+alphabet, new StoreStackVariableOperation(calculatorStack, variablesVector, alphabet)); 
            dict.put("<"+alphabet, new PushStackVariableOperation(calculatorStack, variablesVector, alphabet)); 
        }
    }
    
    /**
     * Returns the operation to which the specified name is mapped.
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
     * Changes the name associated with an operation.
     * @param name the name currently associated with an operation which 
     * should be changed.
     * @param newName the new name to be associated with the operation.
     * @return True if name has been changed, false if the specified name
     * was not present in the dictionary or the newName is already used.
     */
    public boolean renameOperation(String name, String newName){
        if (!dict.containsKey(name) || dict.containsKey(newName)){
            return false;
        }
        else{
            StackOperation operation = dict.get(name);
            dict.put(newName, operation);
            dict.remove(name);
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
    * This method returns an ArrayList of the operations the dictionary contains
    * @return listOperations the list of all the operations in the dictionary
    */
    public ArrayList<StackOperation> listOperations() {
        return new ArrayList<>(dict.values());
    }
    
    /**
     * Creates or modifies an user defined operation with the given name and 
     * defined by the given sequence of operations.
     * @param name The name of the user defined operation to be added or modified
     * @param operations The names of the operations that define the user defined
     * operation to be added or modified
     * @throws InvalidOperationNameException Thrown if the given name has the 
     * same syntax of a complex number
     * @throws InvalidOperationsException Thrown if one of the given operations 
     * has not been defined or it is not a number
     * @throws UserDefinedCycleException Thrown if the inserted Operations have 
     * cycles.
     */
    public void addUserDefinedOperation(String name, String operations) 
        throws InvalidOperationNameException, InvalidOperationsException, 
            UserDefinedCycleException{
        // validate the operation's name
        ComplexFormat cf = ComplexFormat.getInstance('j', Locale.US);
        try{
            cf.parse(name);
            throw new InvalidOperationNameException("This name is forbidden.");
        }
        catch(MathParseException ex){}

        // create an array containing the operations' name
        String[] operationNameArray = operations.split(" ");
        int i = 0;
        for(i = 0; i < operationNameArray.length; i++){
            operationNameArray[i] = operationNameArray[i].trim();
        }
        
        // create a list containing the operations to be perfomed
        ArrayList<StackOperation> operationList = new ArrayList<>();
        for(String operationName : operationNameArray){
            if(containsKey(operationName)){
                StackOperation operation = getOperation(operationName);
                operationList.add(operation);
            }
            else{
                try{
                    Complex c = cf.parse(operationName);
                    StackOperation operation = new PushStackOperation(calculatorStack, c);
                    operationList.add(operation);
                }
                catch(MathParseException ex){
                    throw new InvalidOperationsException();
                }
            }
        }
        if(containsKey(name)){
            UserDefinedOperation operation;
            operation = (UserDefinedOperation)getOperation(name);
            operation.modifyOperations((ArrayList)operationList);
            operation.setOperationsTextual(operations);
        }
        else{
        UserDefinedOperation userDefinedOp = new UserDefinedOperation(name, operationList, calculatorStack);
        userDefinedOp.setOperationsTextual(operations);
        putOperation(name, userDefinedOp);
        }
    }
    
    /**
     * This method saves all the user defined operations contained in the dictionary in the given file.
     * @param file the file on which saving the user defined operations
     * @exception IOException if the file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason
     */
    public void saveUserDefinedOperation(File file) throws IOException{
        try(PrintWriter o= new PrintWriter(new BufferedWriter(new FileWriter(file)))){
           for (StackOperation op: this.listOperations()){
               if(op instanceof UserDefinedOperation ){
                   UserDefinedOperation ud= (UserDefinedOperation)op;
                   o.print(ud.getOperationName()+": "+ ud.getOperationsTextual()+'\n');
                }
            }
        }
           
    }
     
    /**
     * Removes the given user-defined operation by deleting its sequence of operations.
     * @param  ud the user defined operation to remove
     */ 
    public void removeUserDefinedOperation(UserDefinedOperation ud){
        ud.removeOperations();
          
    }
    
}
