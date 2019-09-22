package sample;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.event.ActionEvent;


public class savingsChangePopUpController implements Initializable {

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
        int four01k;
        int education;
        int emergencyFund;
        int uncategorized;

        saveData data = (saveData) resourceManager.load("balance.txt");
        if(changeBox.getValue().equals("401K"))
        {
            four01k = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setFour01k(four01k);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("education")) {

            education = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setEducation(education);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("emergency fund")) {

            emergencyFund = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setEmergencyFund(emergencyFund);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("uncategorized")) {

            uncategorized = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setUncategorized(uncategorized);
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
        changeBox.getItems().addAll("401K", "education", "emergency fund", "uncategorized");
        //default value
        changeBox.setValue("401K");
    }
}
