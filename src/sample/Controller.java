package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.ini4j.Ini;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class Controller implements Initializable {

    @FXML
    private Pane changePane;

    @FXML
    private Label name;

    @FXML
    private Button profileButton;

    @FXML
    private Button incomeButton;

    @FXML
    private Button spendingsButton;

    @FXML
    private Button savingsButton;

    //add an ImageView with this fx:id and then set the image in initialize function
    @FXML
    private ImageView avatar;

    AnchorPane homepane;

    //------Path to config file---------//
    private final String pathIni = "ini\\LoginData.ini";

    public void setNode(Node node) {

        changePane.getChildren().clear();
        changePane.getChildren().add((Node)node);

    }

    public void createPage(AnchorPane home, String loc) throws IOException {
        home = FXMLLoader.load(getClass().getResource(loc));
        setNode(home);
    }

    //-----------------FOR BUTTON ACTIONS----------------//
    @FXML
    void profileAction(ActionEvent event) throws IOException {
        this.createPage(homepane, "profile.fxml");
    }

    @FXML
    void incomeAction(ActionEvent event) throws IOException {
        this.createPage(homepane, "income.fxml");
    }

    @FXML
    void savingsAction(ActionEvent event) throws IOException {
        this.createPage(homepane, "");
    }

    @FXML
    void spendingsAction(ActionEvent event) throws IOException {
        this.createPage(homepane, "");
    }


    //---------Instantly Initialize variables etc. here --------------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Set name on main page by grabbing username from file
        try {

            this.createPage(homepane, "profile.fxml");
            File file = new File(pathIni);
            Ini wini = new Ini(new File(pathIni));
            String namev = wini.get("login_data", "username");
            name.setText(namev);



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
