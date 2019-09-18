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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.ini4j.Ini;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class changePopUpController {

    @FXML
    private TextField changeValue;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button cancelButton;

    @FXML
    public void confirmAction(ActionEvent actionEvent) {

    }

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        Stage changeStage = (Stage) cancelButton.getScene().getWindow();
        changeStage.close();
    }

}
