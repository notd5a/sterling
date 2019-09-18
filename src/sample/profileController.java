package sample;

import javafx.fxml.FXML;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import org.ini4j.Ini;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class profileController implements Initializable{

    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private Label age;
    @FXML
    private Label totalSaved;
    @FXML
    private Label totalIncome;
    @FXML
    private Label spending;
    @FXML
    private Label savings;
    @FXML
    private BarChart bar_chart;

    private final String pathIni = "ini\\LoginData.ini";

    public void readIniFile() {

        try {



            File file = new File(pathIni);
            if (file.exists()) {
                Ini wini = new Ini(new File(pathIni));
                int incomev = wini.get("balance_data", "income", int.class);
                int savingsv = wini.get("balance_data", "savings", int.class);
                int spendingv = wini.get("balance_data", "spending", int.class);
                int totalSavedv = wini.get("balance_data", "totalSaved", int.class);
                //int savingsv = Integer.parseInt(wini.get("balance_data", "savings"));
                //int spendingv = Integer.parseInt(wini.get("balance_data", "spending"));
                //int totalSavedv = Integer.parseInt(wini.get("balance_data", "totalSaved"));
                String namev = wini.get("login_data", "name");
                String agev = wini.get("login_data", "age");
                String usernamev = wini.get("login_data", "username");

                //Set label text to the variables pulled from ini file above
                name.setText(namev);
                username.setText(usernamev);
                age.setText(agev);
                totalSaved.setText("$" + totalSavedv);
                totalIncome.setText("$" + incomev);
                spending.setText("$" + spendingv);
                savings.setText("$" + savingsv);

            }




        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void plotChart()
    {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Set name on main page by grabbing username from file
        readIniFile();
        plotChart();


    }




}
