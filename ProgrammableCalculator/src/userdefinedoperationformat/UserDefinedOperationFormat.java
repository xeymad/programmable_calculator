/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdefinedoperationformat;

/**
 *
 * @author Giuseppe
 */

public class UserDefinedOperationFormat {
    
    /**
     * Parses a string checking if is in UserDefinedOperationFormat.
     * 
     * @param text the string to parse
     * @return String[] a vector of 2 elements, the first attributed to UserDefinedOperation's name
     * and the second attributed to operations sequence.
     * @throws UserDefinedParseException if the passed string isn't in UserDefinedOperationFormat.
     */
    public static String[] parse(String text) throws UserDefinedParseException{
        String[] splitted = text.split(": ");
        if(splitted.length<2)
            throw new UserDefinedParseException("Wrong User defined operation");
        splitted[1] = splitted[1].replaceAll("\\s+$", "");
        if("".equals(splitted[1]))
            throw new UserDefinedParseException("Wrong User defined operation");
        return splitted;
    }
}
