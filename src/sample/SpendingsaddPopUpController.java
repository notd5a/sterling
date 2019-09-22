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

public class SpendingsaddPopUpController implements Initializable {

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
        int home;
        int home1;
        int transport;
        int transport1;
        int health;
        int health1;
        int entertainment;
        int entertainment1;
        int finall;


        saveData data = (saveData) resourceManager.load("balance.txt");

        if(addBox.getValue().equals("home"))
        {
            home = Integer.parseInt(addValue.getText().trim().toUpperCase());
            home1 = data.getHome();
            finall = home + home1;
            data.setHome(finall);
            resourceManager.save(data, "balance.txt");

        }
        else if(addBox.getValue().equals("transport")) {

            transport = Integer.parseInt(addValue.getText().trim().toUpperCase());
            transport1 = data.getTransport();
            finall = transport + transport1;
            data.setTransport(finall);
            resourceManager.save(data, "balance.txt");

        }
        else if(addBox.getValue().equals("health")) {

            health = Integer.parseInt(addValue.getText().trim().toUpperCase());
            health1 = data.getHealth();
            finall = health + health1;
            data.setHealth(finall);
            resourceManager.save(data, "balance.txt");

        }
        else if(addBox.getValue().equals("entertainment")) {

            entertainment = Integer.parseInt(addValue.getText().trim().toUpperCase());
            entertainment1 = data.getEntertainment();
            finall = entertainment + entertainment1;
            data.setEntertainment(finall);
            resourceManager.save(data, "balance.txt");

        }
        else {
            System.err.println("Error! Pick a correct choice");
        }
        resourceManager.save(data, "balance.txt");


        //closes file after saving data into config file
        Stage addStage = (Stage) confirmBtn.getScene().getWindow();
        addStage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //get Items for choiceBox and Add items to it instantly
        addBox.getItems().addAll("home", "transport", "health", "entertainment");
        //default value
        addBox.setValue("home");

    }


}
