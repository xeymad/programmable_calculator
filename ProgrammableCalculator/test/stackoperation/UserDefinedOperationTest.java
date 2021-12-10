/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import java.util.ArrayList;
import org.apache.commons.math3.complex.Complex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arianna Carratù, Giuseppe
 */
public class UserDefinedOperationTest {
    private UserDefinedOperation instance;
    private String operationName;
    private String operationsText; 
    private CalculatorStack calculatorStack;
    private ArrayList<StackOperation> operationsSequence;

    @Before
    public void setUp() {
    operationName = "hypotenuse";
    calculatorStack = new CalculatorStack();
    operationsSequence = new ArrayList<>();
    calculatorStack.push(new Complex(3,0));
    calculatorStack.push(new Complex(4,0));
    operationsSequence.add(new DupStackOperation(calculatorStack));
    operationsSequence.add(new MultiplicationStackOperation(calculatorStack));
    operationsSequence.add(new SwapStackOperation(calculatorStack));
    operationsSequence.add(new DupStackOperation(calculatorStack));
    operationsSequence.add(new MultiplicationStackOperation(calculatorStack));
    operationsSequence.add(new SumStackOperation(calculatorStack));
    operationsSequence.add(new SqrtStackOperation(calculatorStack));
    operationsText = "dup * swap dup * + sqrt";
    instance= new UserDefinedOperation(operationName ,operationsSequence, calculatorStack);
    instance.setOperationsTextual(operationsText);
    }

    /**
     * Test of getOperationName method, of class UserDefinedOperation.
     */
    @Test
    public void testGetOperationName() {
        System.out.println("getOperationName");
        String result = instance.getOperationName();
        assertEquals(operationName, result);

    }

    /**
     * Test of execute method, of class UserDefinedOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        instance.execute();
        assertEquals(calculatorStack.top(), new Complex(5,0));
    }
    
    /**
     * Test of modifyOperations method of class UserDefinedOperation.
     */
    @Test(expected = UserDefinedCycleException.class)
    public void testModifyOperations() throws UserDefinedCycleException{
        System.out.println("modify");
        ArrayList<StackOperation> sequenceUs = new ArrayList<>();
        sequenceUs.add(instance);
        UserDefinedOperation b = new UserDefinedOperation("B",sequenceUs,calculatorStack);
        operationsSequence.add(b);
        instance.modifyOperations(operationsSequence);
        
    }

    /**
     * Test of getOperationsTextual method, of class UserDefinedOperation.
     */
    @Test
    public void testGetOperationsTextual() {
        System.out.println("getOperationsTextual");
        String result=instance.getOperationsTextual();
        assertEquals(operationsText, result);
    }

    /**
     * Test of checkValidate method, of class UserDefinedOperation.
     * Assert a runtime exception is being thrown when the operation has been removed.
     */
    @Test(expected = RuntimeException.class)
    public void testCheckValidateSelf() {
        System.out.println("checkValidate");
        
        // creating user defined A = "+"
        ArrayList<StackOperation> usOpSequenceA = new ArrayList<>();
        usOpSequenceA.add(new SumStackOperation(calculatorStack));
        UserDefinedOperation userDefinedA = new UserDefinedOperation("A", usOpSequenceA, calculatorStack);
        
        userDefinedA.removeOperations();
        userDefinedA.checkValidate();
    }
    
    /**
     * Test of checkValidate method, of class UserDefinedOperation.
     * Assert a runtime exception is being thrown when a parent operation has been removed.
     */
    @Test(expected = RuntimeException.class)
    public void testCheckValidateParent() {
        System.out.println("checkValidate");
        
        // creating user defined A = "+"
        ArrayList<StackOperation> usOpSequenceA = new ArrayList<>();
        usOpSequenceA.add(new SumStackOperation(calculatorStack));
        UserDefinedOperation userDefinedA = new UserDefinedOperation("A", usOpSequenceA, calculatorStack);
        
        // creating user defined B = "A"
        ArrayList<StackOperation> usOpSequenceB = new ArrayList<>();
        usOpSequenceB.add(userDefinedA);
        UserDefinedOperation userDefinedB = new UserDefinedOperation("B", usOpSequenceB, calculatorStack);
        
        userDefinedA.removeOperations();
        userDefinedB.checkValidate();
    }
    
    /**
     * Test of checkValidate method, of class UserDefinedOperation.
     * Assert a runtime exception is being thrown when a grandparent operation has been removed.
     */
    @Test(expected = RuntimeException.class)
    public void testCheckValidateGrandParent() {
        System.out.println("checkValidate");
        
        // creating user defined A = "+"
        ArrayList<StackOperation> usOpSequenceA = new ArrayList<>();
        usOpSequenceA.add(new SumStackOperation(calculatorStack));
        UserDefinedOperation userDefinedA = new UserDefinedOperation("A", usOpSequenceA, calculatorStack);
        
        // creating user defined B = "A"
        ArrayList<StackOperation> usOpSequenceB = new ArrayList<>();
        usOpSequenceB.add(userDefinedA);
        UserDefinedOperation userDefinedB = new UserDefinedOperation("B", usOpSequenceB, calculatorStack);
        
        // creating user defined C = "B"
        ArrayList<StackOperation> usOpSequenceC = new ArrayList<>();
        usOpSequenceC.add(userDefinedB);
        UserDefinedOperation userDefinedC = new UserDefinedOperation("C", usOpSequenceC, calculatorStack);
        
        userDefinedA.removeOperations();
        userDefinedC.checkValidate();
    }

    /**
     * Test of removeOperations method, of class UserDefinedOperation.
     */
    @Test
    public void testRemoveOperations() {
        System.out.println("removeOperations");
        instance.removeOperations();
        assertEquals("", instance.getOperationsTextual());
    }

    /**
     * Test of setOperationsTextual method, of class UserDefinedOperation.
     */
    @Test
    public void testSetOperationsTextual() {
        System.out.println("setOperationsTextual");
        String operationsTextual = "+ -";
        instance.setOperationsTextual(operationsTextual);
        String result=instance.getOperationsTextual();
        assertEquals(operationsTextual, result);
        
    }
}
