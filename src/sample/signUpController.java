package sample;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import org.ini4j.Ini;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class signUpController implements Initializable{

    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button signUpButton;
    @FXML
    private Label status;

    private String name;
    private int age;
    private String username;
    private String password;

    saveData data;

    {
        try {
            data = (saveData) resourceManager.load("balance.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backButton(ActionEvent actionEvent) throws Exception {

        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        secondaryStage.setTitle("Sterling");
        secondaryStage.setScene(new Scene(root, 743, 406));
        secondaryStage.setResizable(false);
        secondaryStage.show();
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        stage.close();

    }


    @FXML
    private void signUpAction(ActionEvent actionEvent) throws Exception {

        //probably good to add some error handling, to ensure that people dont mess up peoples accounts etc.
        name = nameField.getText();
        age = Integer.parseInt(ageField.getText().trim().toUpperCase());
        username = usernameField.getText();
        password = passwordField.getText();

        data.setName(name);
        data.setAge(age);
        data.setUsername(username);
        data.setPassword(password);
        resourceManager.save(data, "balance.txt");

        status.setText("Account Created");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
