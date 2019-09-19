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

    private final String pathIni = "ini\\LoginData.ini";

    ///-----Create Ini File ---/////
    public void createIniFile(){
        try {

            File file = new File(pathIni);
            if (!file.exists()) {
                file.createNewFile();
            }
            Ini wini = new Ini(new File(pathIni));
            wini.put("login_data", "username", userField.getText());
            wini.put("login_data", "password", passField.getText());

            wini.put("login_data", "name", "Name");
            wini.put("login_data", "age", "18");
            wini.store();

        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //-------------Read Ini File for login data------------/////
    public void readIniFile() {

        try {


            File file = new File(pathIni);
            if (file.exists()) {
                Ini wini = new Ini(new File(pathIni));
                String username = wini.get("login_data", "username");
                String password = wini.get("login_data", "password");

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
    private void LogAction(ActionEvent event) throws Exception {
        if(userField.getText().equals("root") && passField.getText().equals("toor")) {

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
