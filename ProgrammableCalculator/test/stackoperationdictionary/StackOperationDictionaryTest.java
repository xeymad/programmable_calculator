/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperationdictionary;

import stackoperationdictionary.StackOperationDictionary;
import org.junit.*;
import static org.junit.Assert.*;
import calculatorstack.*;
import stackoperation.*;

/**
 *
 * @author aferr
 */
public class StackOperationDictionaryTest {

    private StackOperationDictionary stackOperationDictionary;
    private CalculatorStack calculatorStack;

    /**
     * Initialize a StackOperationDictionary with a new CalculatorStack
     */
    @Before
    public void init() {
        calculatorStack = new CalculatorStack();
        stackOperationDictionary = new StackOperationDictionary(calculatorStack);
    }

    /**
     * Test if the constructor puts the right entries into the dictionary. The
     * dictionary should contains the following entries: <br>
     * - &lt;"+", SumStackOperation&gt; <br>
     * - &lt;"-", SubtractionStackOperation&gt; <br>
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
        
        StackOperation shouldBeSumOperation = stackOperationDictionary.getOperation("sum");
        assertNotNull(shouldBeSumOperation);
        assertTrue(shouldBeSumOperation instanceof SumStackOperation);
    }
    
    /**
     * Test if the renameOperation method returns False if an entry with
     * key equals to name is not present in the dictionary and the names
     * have not been changed.
     */
    @Test
    public void testRenameOperationNotPresent(){
        boolean nameChanged = stackOperationDictionary.renameOperation("404", "+");
        assertFalse(nameChanged);
        
        StackOperation shouldBeNullOperation = stackOperationDictionary.getOperation("404");
        assertNull(shouldBeNullOperation);
        
        StackOperation shouldBeSumOperation = stackOperationDictionary.getOperation("+");
        assertNotNull(shouldBeSumOperation);
        assertTrue(shouldBeSumOperation instanceof SumStackOperation);
        
    }
    
    /**
     * Test if the renameOperation method returns False if an entry with 
     * Key equals to newName is already present in the dictionary and the
     * names have not been changed.
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
}