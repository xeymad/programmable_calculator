/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperationdictionary;

import org.junit.*;
import static org.junit.Assert.*;
import calculatorstack.*;
import stackoperation.*;
import complexvariablesvector.ComplexVariablesVector;
import java.util.ArrayList;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author aferr
 */
public class StackOperationDictionaryTest {

    private StackOperationDictionary stackOperationDictionary;
    private CalculatorStack calculatorStack;
    private ComplexVariablesVector variablesVector;

    /**
     * Initialize a StackOperationDictionary with a new CalculatorStack
     */
    @Before
    public void init() {
        calculatorStack = new CalculatorStack();
        variablesVector = new ComplexVariablesVector();
        stackOperationDictionary = new StackOperationDictionary(calculatorStack,variablesVector);    
    }

    /**
     * Test if the constructor puts the right entries into the dictionary. The
     * dictionary should contains the following entries: <br>
     * - &lt;"+", SumStackOperation&gt; <br>
     * - &lt;"-", SubtractionStackOperation&gt; <br>
     * - &lt;"-", MultiplicationStackOperation&gt; <br>
     * - &lt;"-", DivisionStackOperation&gt; <br>
     * - &lt;"-", SqrtStackOperation&gt; <br>
     * - &lt;"-", InvertSignStackOperation&gt; <br>
     * In order to perform the test, the getOperation method is being used. Thus
     * the following tests the getOperation method too.
     */
    @Test
    public void testConstructor() {
        StackOperation sumStackOperation = stackOperationDictionary.getOperation("+");
        assertNotNull(sumStackOperation);
        assertTrue(sumStackOperation instanceof SumStackOperation);
        
        StackOperation subtractionStackOperation = stackOperationDictionary.getOperation("-");
        assertNotNull(subtractionStackOperation);
        assertTrue(subtractionStackOperation instanceof SubtractionStackOperation);
        
        StackOperation multiplicationStackOperation = stackOperationDictionary.getOperation("*");
        assertNotNull(multiplicationStackOperation);
        assertTrue(multiplicationStackOperation instanceof MultiplicationStackOperation);
        
        StackOperation divisionStackOperation = stackOperationDictionary.getOperation("/");
        assertNotNull(divisionStackOperation);
        assertTrue(divisionStackOperation instanceof DivisionStackOperation);
        
        StackOperation sqrtStackOperation = stackOperationDictionary.getOperation("sqrt");
        assertNotNull(sqrtStackOperation);
        assertTrue(sqrtStackOperation instanceof SqrtStackOperation);
        
        StackOperation invertSignStackOperation = stackOperationDictionary.getOperation("+-");
        assertNotNull(invertSignStackOperation);
        assertTrue(invertSignStackOperation instanceof InvertSignStackOperation);
    }

    /**
     * Test if the putOperation method puts an entry into the dictionary.
     */
    @Test
    public void testPutOperation() {
        StackOperation sumStackOperation = new SumStackOperation(calculatorStack);
        stackOperationDictionary.putOperation("sum", sumStackOperation);
        
        StackOperation shouldBeSumStackOperation = stackOperationDictionary.getOperation("sum");
        assertNotNull(shouldBeSumStackOperation);
        assertTrue(shouldBeSumStackOperation instanceof SumStackOperation);
    }

    /**
     * Test if the removeOperation method removes an existing entry from the dictionary.
     */
    @Test
    public void testRemoveOperation() {
        stackOperationDictionary.removeOperation("+");
        StackOperation shouldBeNullOperation = stackOperationDictionary.getOperation("+");
        assertNull(shouldBeNullOperation);
    }
    
    /**
     * Test if the removeOperation method returns null when an operation's name
     * not present in the dictionary is given as input.
     */
    @Test
    public void testRemoveOperationNotPresent(){
        StackOperation removedOperation = stackOperationDictionary.removeOperation("404");
        assertNull(removedOperation);
    }

    /**
     * Test if the renameOperation method changes the name of an existing entry
     * and returns True.
     */
    @Test
    public void testRenameOperation() {
        boolean nameChanged = stackOperationDictionary.renameOperation("+", "sum");
        assertTrue(nameChanged);
        
        StackOperation shouldBeNullOperation = stackOperationDictionary.getOperation("+");
        assertNull(shouldBeNullOperation);
        
        StackOperation shouldBeSumOperation = stackOperationDictionary.getOperation("sum");
        assertNotNull(shouldBeSumOperation);
        assertTrue(shouldBeSumOperation instanceof SumStackOperation);
    }
    
    /**
     * Test if the renameOperation method returns False if an entry with
     * key equals to name is not present in the dictionary and there aren't any
     * associations to the given names.
     */
    @Test
    public void testRenameOperationNotPresent(){
        boolean nameChanged = stackOperationDictionary.renameOperation("404", "200");
        assertFalse(nameChanged);
        
        StackOperation shouldBeNullOperation = stackOperationDictionary.getOperation("404");
        assertNull(shouldBeNullOperation);
        
        StackOperation shouldBeNullOperation2 = stackOperationDictionary.getOperation("200");
        assertNull(shouldBeNullOperation2);
        
    }
    
    /**
     * Test if the renameOperation method returns False if an entry with 
     * Key equals to newName is already present in the dictionary and the
     * associations have not been changed.
     */
    @Test
    public void testRenameOperationAlreadyPresent(){
        boolean nameChanged = stackOperationDictionary.renameOperation("+", "-");
        assertFalse(nameChanged);
        
        StackOperation shouldBeSumOperation = stackOperationDictionary.getOperation("+");
        assertNotNull(shouldBeSumOperation);
        assertTrue(shouldBeSumOperation instanceof SumStackOperation);
        
        StackOperation shouldBeSubtractionOperation = stackOperationDictionary.getOperation("-");
        assertNotNull(shouldBeSubtractionOperation);
        assertTrue(shouldBeSubtractionOperation instanceof SubtractionStackOperation);
    }

    /**
     * Test if containsKey method returns True when the Key is present in the
     * dictionary.
     */
    @Test
    public void testContainsKey() {
        boolean keyIsPresent = stackOperationDictionary.containsKey("+");
        assertTrue(keyIsPresent);
    }

    /**
     * Test if containsKey method returns False when the Key is NOT present
     * in the dictionary.
     */
    @Test
    public void testContainsKeyNotPresent(){
        boolean keyIsPresent = stackOperationDictionary.containsKey("404");
        assertFalse(keyIsPresent);
    }
    /**
     * Test if the execute method performed on an operation present in the 
     * dictionary returns True.
     */
    @Test
    public void testExecute() {
        boolean operationPerformed = stackOperationDictionary.execute("+");
        assertTrue(operationPerformed);
    }
    
    /**
     * Test if the execute method performed on an operation NOT present
     * in the dictionary returns False.
     */
    @Test
    public void testExecuteNotPresent(){
        boolean operationPerformed = stackOperationDictionary.execute("404");
        assertFalse(operationPerformed);
    }
    
    @Test
    public void testAddUserDefinedOperationWithoutComplex() 
            throws InvalidOperationNameException, InvalidOperationsException{
        String operationName = "userdefined";
        String operations = "+ + -";
        stackOperationDictionary.addUserDefinedOperation(operationName, operations);
        
        // check if the operations in userdefined are correct
        UserDefinedOperation userdefined = (UserDefinedOperation) stackOperationDictionary.getOperation(operationName);
        assertEquals(userdefined.getOperationName(), operationName);
        ArrayList<StackOperation> userdefinedOperations = userdefined.getOperationsSequence();
        assertTrue(userdefinedOperations.get(0) instanceof SumStackOperation);
        assertTrue(userdefinedOperations.get(1) instanceof SumStackOperation);
        assertTrue(userdefinedOperations.get(2) instanceof SubtractionStackOperation);
    }
    
    @Test
    public void testAddUserDefinedOperationWithComplex() 
            throws InvalidOperationNameException, InvalidOperationsException{
        String operationName = "userdefined";
        String operations = "+ + 2+3j";
        stackOperationDictionary.addUserDefinedOperation(operationName, operations);
        
        // check if the operations in userdefined are correct
        UserDefinedOperation userdefined = (UserDefinedOperation) stackOperationDictionary.getOperation(operationName);
        assertEquals(userdefined.getOperationName(), operationName);
        ArrayList<StackOperation> userdefinedOperations = userdefined.getOperationsSequence();
        assertTrue(userdefinedOperations.get(0) instanceof SumStackOperation);
        assertTrue(userdefinedOperations.get(1) instanceof SumStackOperation);
        PushStackOperation pushStackOperation = (PushStackOperation) userdefinedOperations.get(2);
        assertTrue(pushStackOperation instanceof PushStackOperation);
        Complex c = new Complex(2, 3);
        assertEquals(pushStackOperation.getToPush(), c);
    }
    
    @Test
    public void testAddUserDefinedOperationWithUserDefined() 
            throws InvalidOperationNameException, InvalidOperationsException{
        stackOperationDictionary.addUserDefinedOperation("userdefined", "+ + -");
        String operationName = "userdefined2";
        String operations = "+ + userdefined";
        stackOperationDictionary.addUserDefinedOperation(operationName, operations);
        
        UserDefinedOperation userdefined2 = (UserDefinedOperation) stackOperationDictionary.getOperation(operationName);
        assertEquals(userdefined2.getOperationName(), operationName);
        
        // check if operations in userdefined2 are correct
        // regarding the operation "userdefined", it just checks its name
        ArrayList<StackOperation> userdefined2Operations = userdefined2.getOperationsSequence();
        assertTrue(userdefined2Operations.get(0) instanceof SumStackOperation);
        assertTrue(userdefined2Operations.get(1) instanceof SumStackOperation);
        UserDefinedOperation userdefined = (UserDefinedOperation) userdefined2Operations.get(2);
        assertEquals(userdefined.getOperationName(), "userdefined");
    }
    
    @Test(expected=InvalidOperationNameException.class)
    public void testAddUserDefinedOperationNameAlreadyTaken() 
            throws InvalidOperationNameException, InvalidOperationsException{
        stackOperationDictionary.addUserDefinedOperation("+", "+ +");
    }
    
    @Test(expected=InvalidOperationNameException.class)
    public void testAddUserDefinedOperationNameIsComplex() 
            throws InvalidOperationNameException, InvalidOperationsException{
        stackOperationDictionary.addUserDefinedOperation("2+3j", "+ +");
    }
    
    @Test(expected=InvalidOperationsException.class)
    public void testAddUserDefinedOperationInvalidOperations() 
            throws InvalidOperationNameException, InvalidOperationsException{
        stackOperationDictionary.addUserDefinedOperation("userdefined", "+ + userdefined2");
    }
}
