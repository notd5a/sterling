package sample;

import javafx.fxml.FXML;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.ini4j.Ini;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class IncomechangePopUpController implements Initializable {

    @FXML
    private TextField changeValue;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox<String> changeBox;

    @FXML
    public void confirmAction(ActionEvent actionEvent) throws Exception {

        //income
        int loan;
        int loan1;
        int salary;
        int salary1;
        int credit;
        int credit1;
        int investment;
        int investment1;
        int finall;

        saveData data = (saveData) resourceManager.load("balance.txt");
        if(changeBox.getValue().equals("salary"))
        {
            salary = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setSalary(salary);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("investment")) {

            investment = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setInvestment(investment);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("credit")) {

            credit = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setCredit(credit);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("loan")) {

            loan = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setCredit(loan);
            resourceManager.save(data, "balance.txt");

        }
        else {
            System.err.println("Error! Pick a correct choice");
        }

        //saves object into the file
        resourceManager.save(data, "balance.txt");


        //closes file after saving data into config file
        Stage addStage = (Stage) confirmBtn.getScene().getWindow();
        addStage.close();


    }

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        Stage changeStage = (Stage) cancelButton.getScene().getWindow();
        changeStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //get Items for choiceBox and Add items to it instantly
        changeBox.getItems().addAll("salary", "investment", "credit", "loan");
        //default value
        changeBox.setValue("salary");
    }
}
