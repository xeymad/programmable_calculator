/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmablecalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.apache.commons.math3.complex.*;
import calculatorstack.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.apache.commons.math3.exception.MathParseException;
import stackoperationdictionary.*;
/**
 *
 * @author Giuseppe
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtInput;
    @FXML
    private Button insertBtn;
    @FXML
    private ListView<Complex> stackView;
    
    private CalculatorStack calculatorStack;
    
    private StackOperationDictionary stackOperationDictionary;
    /**
     * Initialize the components of the GUI
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculatorStack = new CalculatorStack();
        stackOperationDictionary = new StackOperationDictionary(calculatorStack);
    }    
    
    /**
     * This function updates the stackView in the GUI.
     * It shows the last 12 elements of the stack.
     */
    public void updateStackView(){
        stackView.getItems().clear();
        int i=0;
        for(Complex c : calculatorStack){
            if(i>=12) return;
            stackView.getItems().add(c);
            i++;
        }
    }

    /**
     * This function runs automatically after the insertBtn got pressed.
     * It first try to parse the received string from txtInput as a ComplexNumber.
     * If it can't parse, it tryes to execute an operation from stackOperationDictionary.
     * If the inserted text isn't an operation, it will show an Error Message.
     * @param event 
     */
    @FXML
    private void insertBtnPressed(ActionEvent event) {
        String inserted = txtInput.getText();
        if(inserted.equals("")) return;
        ComplexFormat cf = new ComplexFormat("j");
        try{
            Complex c = cf.parse(inserted);
            calculatorStack.push(c);
        }
        catch(MathParseException ex){
            if(!stackOperationDictionary.containsKey(inserted)){
               Alert alert = new Alert(AlertType.ERROR, "Complex value not parsable or Operation not Found");
               alert.showAndWait();
               return;
            }
            stackOperationDictionary.execute(inserted);
        }
        updateStackView();
    }
    
    /**
     * This function runs automatically after closeBtn pression.
     * It simply closes the window.
     * @param event 
     */
    @FXML
    private void closeBtnPressed(ActionEvent event) {
        Platform.exit();
    }
}
