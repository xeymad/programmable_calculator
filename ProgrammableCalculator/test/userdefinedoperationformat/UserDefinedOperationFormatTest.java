/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdefinedoperationformat;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import userdefinedoperationformat.UserDefinedOperationFormat;

/**
 *
 * @author giuse
 */
public class UserDefinedOperationFormatTest {
    
    @Test
    public void testExecuteWithoutException1() throws UserDefinedParseException {
        String[] s = UserDefinedOperationFormat.parse("A: + + -");
        assertEquals(s[0],"A");
        assertEquals(s[1],"+ + -");
    }
    
    @Test
    public void testExecuteWithoutException2() throws UserDefinedParseException {
        String[] s = UserDefinedOperationFormat.parse("A: + + -       ");
        assertEquals(s[0],"A");
        assertEquals(s[1],"+ + -");       
    }
    
    @Test(expected = UserDefinedParseException.class)
    public void testExecuteWithoutException3() throws UserDefinedParseException {
        String[] s = UserDefinedOperationFormat.parse("A:     ");       
    }
    
}
