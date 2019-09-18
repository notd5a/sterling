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

public class addPopUpController implements Initializable {

    @FXML
    private TextField addValue;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox<String> addBox;

    private final String pathIni = "ini\\LoginData.ini";

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        Stage addStage = (Stage) cancelButton.getScene().getWindow();
        addStage.close();
    }

    @FXML
    public void confirmAction(ActionEvent actionEvent) throws IOException {

        File file = new File(pathIni);
        Ini wini = new Ini(new File(pathIni));
        String choice = addBox.getValue();
        int choiceValue = wini.get("income_value", choice, int.class); ///<<<-----CULPRIT HERE
        int textFieldValue = Integer.parseInt(addValue.getText().trim().toUpperCase());
        int finalValue = choiceValue + textFieldValue;
        System.out.println(choiceValue); //<---Issue is with choiceValue, pulling the value and storing it as 0
        System.out.println(textFieldValue);
        System.out.println(finalValue);
        wini.put("income_data", choice, finalValue); //----This works however
        wini.store();

        //closes file after saving data into config file
        Stage addStage = (Stage) confirmBtn.getScene().getWindow();
        addStage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //get Items for choiceBox and Add items to it instantly
        addBox.getItems().addAll("salary", "investment", "credit", "loan");
        //default value
        addBox.setValue("salary");

    }


}
