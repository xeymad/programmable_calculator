/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdefinedoperationformat;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author giuse
 */
public class UserDefinedOperationFormatTest {
    
    /**
     * Parses a simple string
     * @throws UserDefinedParseException 
     */
    @Test
    public void testExecuteWithoutException1() throws UserDefinedParseException {
        String[] s = UserDefinedOperationFormat.parse("A: + + -");
        assertEquals(s[0],"A");
        assertEquals(s[1],"+ + -");
    }
    
    /**
     * Parses a string with useless spaces
     * @throws UserDefinedParseException 
     */
    @Test
    public void testExecuteWithoutException2() throws UserDefinedParseException {
        String[] s = UserDefinedOperationFormat.parse("A: + + -       ");
        assertEquals(s[0],"A");
        assertEquals(s[1],"+ + -");       
    }
    
    /**
     * Parses a string without operations
     * @throws UserDefinedParseException 
     */
    @Test(expected = UserDefinedParseException.class)
    public void testExecuteWithException() throws UserDefinedParseException {
        String[] s = UserDefinedOperationFormat.parse("A:     ");       
    }
    
}
