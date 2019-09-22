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


public class SpendingsChangePopUpController implements Initializable {

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
        int home;
        int transport;
        int health;
        int entertainment;

        saveData data = (saveData) resourceManager.load("balance.txt");
        if(changeBox.getValue().equals("home"))
        {
            home = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setHome(home);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("transport")) {

            transport = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setTransport(transport);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("health")) {

            health = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setHealth(health);
            resourceManager.save(data, "balance.txt");

        }
        else if(changeBox.getValue().equals("entertainment")) {

            entertainment = Integer.parseInt(changeValue.getText().trim().toUpperCase());
            data.setEntertainment(entertainment);
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
        changeBox.getItems().addAll("home", "transport", "health", "entertainment");
        //default value
        changeBox.setValue("home");
    }
}
