package sample;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.CheckBox;
import org.ini4j.Ini;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class LoginController implements Initializable{
    @FXML
    private Button loginButton;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private Label status;
    @FXML
    private CheckBox rememberMe;

    private final String pathIni = "balance.txt";
    saveData data;

    {
        try {
            data = (saveData) resourceManager.load("balance.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///-----Create Ini File ---/////
    public void createIniFile(){
        try {
            File file = new File(pathIni);
            if (!file.exists()) {
                file.createNewFile();
            }

            data.setUsername(userField.getText());
            data.setPassword(passField.getText());

        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //-------------Read Ini File for login data------------/////
    public void readIniFile() {

        try {

            File file = new File("balance.txt");
            if (file.exists()) {
                String username = data.getUsername();
                String password = data.getPassword();

                //if empty then put in the username and pass in the fields
                if((username != null && !username.equals("")) && (password != null && !password.equals("")) ) {
                    userField.setText(username);
                    passField.setText(password);
                }
                else {
                    userField.setText(null);
                    passField.setText(null);
                }
            }


        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void signUpAction(ActionEvent actionEvent) throws IOException {
        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        secondaryStage.setTitle("Sterling");
        secondaryStage.setScene(new Scene(root, 743, 406));
        secondaryStage.setResizable(false);
        secondaryStage.show();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void LogAction(ActionEvent event) throws Exception {
        if(userField.getText().equals(data.getUsername()) && passField.getText().equals(data.getPassword())) {

            if(rememberMe.isSelected()) {
                createIniFile();
            }

            status.setText("Logging in");
            Stage secondaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            secondaryStage.setTitle("Sterling");
            secondaryStage.setScene(new Scene(root, 1012, 634));
            secondaryStage.setResizable(false);
            secondaryStage.show();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }
        else {
            status.setText("Login Failed");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readIniFile();
    }
}
