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

public class savingsaddPopUpController implements Initializable {

    @FXML
    private TextField addValue;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox<String> addBox;

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        Stage addStage = (Stage) cancelButton.getScene().getWindow();
        addStage.close();
    }

    @FXML
    public void confirmAction(ActionEvent actionEvent) throws Exception {

        //income
        int four01k;
        int four01k1;
        int education;
        int education1;
        int emergencyFund;
        int emergencyFund1;
        int uncategorized;
        int uncategorized1;
        int finall;


        saveData data = (saveData) resourceManager.load("balance.txt");


        if(addBox.getValue().equals("401K"))
        {
            four01k = Integer.parseInt(addValue.getText().trim().toUpperCase());
            four01k1 = data.getFour01k();
            finall = four01k + four01k1;
            data.setFour01k(finall);
            resourceManager.save(data, "balance.txt");

        }
        else if(addBox.getValue().equals("education")) {

            education = Integer.parseInt(addValue.getText().trim().toUpperCase());
            education1 = data.getEducation();
            finall = education + education1;
            data.setEducation(finall);
            resourceManager.save(data, "balance.txt");

        }
        else if(addBox.getValue().equals("emergency fund")) {

            emergencyFund = Integer.parseInt(addValue.getText().trim().toUpperCase());
            emergencyFund1 = data.getEmergencyFund();
            finall = emergencyFund + emergencyFund1;
            data.setEmergencyFund(finall);
            resourceManager.save(data, "balance.txt");

        }
        else if(addBox.getValue().equals("uncategorized")) {

            uncategorized = Integer.parseInt(addValue.getText().trim().toUpperCase());
            uncategorized1 = data.getUncategorized();
            finall = uncategorized + uncategorized1;
            data.setUncategorized(finall);
            resourceManager.save(data, "balance.txt");

        }
        else {
            System.err.println("Error! Pick a correct choice");
        }

        //final save of all data regardless of loop
        resourceManager.save(data, "balance.txt");

        //closes file after saving data into config file
        Stage addStage = (Stage) confirmBtn.getScene().getWindow();
        addStage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //get Items for choiceBox and Add items to it instantly
        addBox.getItems().addAll("401K", "education", "emergency fund", "uncategorized");
        //default value
        addBox.setValue("401K");

    }


}
