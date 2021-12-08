/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdefinedoperationformat;

/**
 *
 * @author giuse
 */

public class UserDefinedOperationFormat {
    
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
