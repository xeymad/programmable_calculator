/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmablecalculator;

import userdefinedoperationformat.UserDefinedOperationFormat;
import stackoperationdictionary.StackOperationDictionary;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.apache.commons.math3.complex.*;
import calculatorstack.*;
import complexvariablesvector.*;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import operationexecutor.OperationExecutor;
import org.apache.commons.math3.exception.MathParseException;
import stackoperation.*;
import stackvariableoperation.StackVariableOperation;
import javafx.stage.FileChooser;

/**
 * Controller used to get input from user, invoke the right methods on the
 * model classes and update the view
 * @author group 02
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtInput;
    @FXML
    private ListView<Complex> stackView;
    @FXML
    private TableView<ComplexVariable> variablesView;
    
    private CalculatorStack calculatorStack;
    
    private ComplexVariablesVector complexVariablesVector;
    
    private OperationExecutor operationExecutor;
    
    private static final int ELEMENTS_VIEW = 20;
    
    private StackOperationDictionary stackOperationDictionary;
    @FXML
    private TableColumn<ComplexVariable, Character> varClm;
    @FXML
    private TableColumn<ComplexVariable, Complex> valueClm;
    @FXML
    private TableView<UserDefinedOperation> userDefinedView;
    @FXML
    private TableColumn<UserDefinedOperation, String> varClm1;
    @FXML
    private TableColumn<UserDefinedOperation, String> valueClm1;   
    private ComplexFormat cf;
 
    
    /**
     * Initializes the components of the GUI.
     * @param url: The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param rb: The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cf = ComplexFormat.getInstance('j', Locale.US);
        calculatorStack = new CalculatorStack();
        complexVariablesVector = new ComplexVariablesVector();
        stackOperationDictionary = new StackOperationDictionary(calculatorStack, complexVariablesVector);
        operationExecutor = new OperationExecutor();
        varClm.setCellValueFactory(new PropertyValueFactory<>("character"));
        valueClm.setCellValueFactory(new PropertyValueFactory<>("complex"));
        
        varClm1.setCellValueFactory(new PropertyValueFactory<>("operationName"));
        valueClm1.setCellValueFactory(new PropertyValueFactory<>("operationsTextual"));
        updateUserDefinedView();
        updateVariablesView();
        // hook performUserAction on textField
        txtInput.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            if(key == KeyCode.ENTER)
                performUserAction();
        });
    }    
    
    /**
     * This method updates the variablesView in the GUI.
     * It shows all the 26 variables of the variablesVector.
     */
    public void updateVariablesView(){
       variablesView.getItems().clear();
       for(ComplexVariable cv : complexVariablesVector){
            variablesView.getItems().add(cv);
       }
    }

    /**
     * This method updates the userDefinedView in the GUI.
     * It shows all the UserDefinedOperation defined. 
     * 
     */
   public void updateUserDefinedView(){
     userDefinedView.getItems().clear();
       for(StackOperation operation : stackOperationDictionary.listOperations()){
           if(operation instanceof UserDefinedOperation)
               userDefinedView.getItems().add((UserDefinedOperation)operation);
       }
    }
   
    /**
     * This method updates the stackView in the GUI.
     * It shows the last ELEMENTS_VIEW elements of the stack.
     */
    public void updateStackView(){
        stackView.getItems().clear();
        int i=0;
        for(Complex c : calculatorStack){
            if(i>=ELEMENTS_VIEW) return;
            stackView.getItems().add(c);
            i++;
        }
    }
     
    /**
     * This method runs automatically after the insertBtn got pressed.
     * @param event 
     */
    @FXML
    private void insertBtnPressed(ActionEvent event) {
        performUserAction();
    }
    
    /**
     * This method runs automatically after closeBtn pression.
     * It simply closes the window.
     * @param event 
     */
    @FXML
    private void closeBtnPressed(ActionEvent event) {
        Platform.exit();
    }
    
    /**
     * This method first tries to parse the received string from txtInput as a ComplexNumber.
     * If it can't parse, it tries to execute an operation from StackOperationDictionary.
     * If the inserted text isn't an operation, it will show an Error Message.
     */
    private void performUserAction(){
        String inserted = txtInput.getText();
        txtInput.clear();
        if(inserted.equals("")) return;
        
        Exception catched;
        try{
            Complex c = cf.parse(inserted);
            StackOperation stackOperation = new PushStackOperation(calculatorStack, c);
            operationExecutor.setCommand(stackOperation);
            operationExecutor.execute();
            updateStackView();
            return;
        }
        catch(MathParseException ex){
            catched = ex;
        }
        StackOperation stackOperation=stackOperationDictionary.getOperation(inserted);
        if(stackOperation == null){
            if(inserted.contains("del ")){
                String opName = inserted.split("del ")[1];
                StackOperation inDict = stackOperationDictionary.getOperation(opName);
                if(inDict!=null && inDict instanceof UserDefinedOperation){
                    stackOperationDictionary.removeUserDefinedOperation((UserDefinedOperation)inDict);
                return;
                }
            }
            try{
                String[] usd = UserDefinedOperationFormat.parse(inserted);
                stackOperationDictionary.addUserDefinedOperation(usd[0], usd[1]);
                return;
            } catch(Exception ex){
                catched = ex;
            }
        }
        else{
            try{
                operationExecutor.setCommand(stackOperation);
                operationExecutor.execute();
                if (stackOperation instanceof StackVariableOperation ||
                        stackOperation instanceof UserDefinedOperation)
                    updateVariablesView();
                updateStackView();
                return;
            }
            catch(Exception ex){
                catched = ex;           
            }
        }
        if (catched != null){
            Alert alert = new Alert(AlertType.ERROR, catched.getMessage());
            alert.showAndWait();
        }
    }
    
    /**
     * This method is performed when the user clicks the "Save User Defined Operations" button.
     * Shows a new file save dialog and saves on the choosen file.
     * Shows an alert if the file save fails.
     * @param event high-level event generated by "Save User Defined Operations" button when is pressed.
     */
    @FXML
    private void saveFile(ActionEvent event) {
        FileChooser fc=new FileChooser();
        fc.setTitle("Save as...");
        File file=fc.showSaveDialog(null);
        if(file!=null){
            try {
                stackOperationDictionary.saveUserDefinedOperation(file);
            } catch (IOException ex) {
                Alert alert = new Alert(AlertType.ERROR, "Save on File failed");
                alert.showAndWait();
            }
        }
       
    }
    
}
    

