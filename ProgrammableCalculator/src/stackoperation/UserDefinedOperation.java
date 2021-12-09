/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import java.util.ArrayList;
import java.util.*;

/**
 * This class implements the creation and the execution of user defined operations.
 * @author Arianna Carratù, Giuseppe
 */
public class UserDefinedOperation extends StackOperation {
    private String operationName;
    private String operationsTextual;
    private ArrayList<StackOperation> operationsSequence;
    private List<UserDefinedOperation> parents;
    private Map<String,UserDefinedOperation> children;
    private boolean validate;
    
    /**
     * Factory Method to remove the UserDefinedOperation
     * @param toRemove the user defined to remove
     */
    public static void remove(UserDefinedOperation toRemove){
        //for(UserDefinedOperation parent : toRemove.parents)
            //parent.removeChild(toRemove);
        if(!toRemove.children.isEmpty())
            toRemove.operationsSequence.clear();
        else{
            toRemove = null;
        }
        toRemove.invalidate();
    }
    private void invalidate(){
        validate=false;
        
    }
    /** 
     * Class constructor
     * @param opName name of the user defined operation.
     * @param opSequence sequence of operations which define the user operation(including the push of numbers).
     * @param calculatorStack instance of calculator's stack.
     */
    public UserDefinedOperation(String opName, String opText,  ArrayList<StackOperation> opSequence, CalculatorStack calculatorStack) {
        super(calculatorStack);
        operationName = opName;
        operationsTextual = opText;
        operationsSequence = new ArrayList<>();
        parents = new ArrayList<>(10);
        children = new HashMap<>();
        validate=true;
        for(StackOperation op : opSequence)
            this.addOperation(op);
    }
    
    /**
     * Private method for add a new StackOperation
     * @param stackOperation the StackOperation to add
     */
    private void addOperation(StackOperation stackOperation){
        operationsSequence.add(stackOperation);
        if(stackOperation instanceof UserDefinedOperation){
            UserDefinedOperation us = (UserDefinedOperation) stackOperation;
            parents.add(us);
            us.addChild(this);
        }
    }
    
    /**
    * This method returns the name of the user defined operation.
    * @return String This returns the string containing the operation's name
    */ 
    public String getOperationName() {
        return operationName;
    }
      
    public String getOperationsTextual() {
        return operationsTextual;
    }

    /**
     * Modifies the old sequence of operations with the new sequence of operations.
     * @param operations the new sequence of operations
     * @throws UserDefinedCycleException If the inserted Operations have cycles.
     */
    public void modifyOperations(String operationsText, ArrayList<StackOperation> operations) throws UserDefinedCycleException{
        for(StackOperation op : operations){
           if(op instanceof UserDefinedOperation){
               UserDefinedOperation us = (UserDefinedOperation) op;
               if(children.containsKey(us.operationName))
                   throw new UserDefinedCycleException("Could not modify operation (Cycle found)");
           }
        }
        operationsSequence.clear();
        parents.clear();
        operationsTextual = operationsText;
        for(StackOperation op : operations)
            this.addOperation(op);
        validate=true;
    }
    
    /**
     * This method implements the execution of the operations's sequence that defines the user operation.
     * If a UserDefined does not exists it launchs an Exception.
     */ 
    @Override
    public void execute() {
        for(UserDefinedOperation usOperation : parents){
            //if(usOperation.operationsSequence.isEmpty())
            if(usOperation.validate==false)
                throw new RuntimeException("The dependency "+usOperation.operationName+" has been deleted");
        }
        for(StackOperation stackOperation: operationsSequence)
            stackOperation.execute();
    }
    
    /**
     * Add a new child of the userDefined operation
     * @param child 
     */
    private void addChild(UserDefinedOperation child){
        children.put(child.operationName,child);
        for(UserDefinedOperation parent : parents)
            parent.addChild(child);
    }
    
    /**
     * remove a child from the userDefined operation
     * @param child 
     */
    private void removeChild(UserDefinedOperation child){
        children.remove(child.operationName,child);
        for(UserDefinedOperation parent : parents)
            parent.removeChild(child);
    }
}
