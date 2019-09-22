package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class profileController implements Initializable{

    @FXML
    private Label name;
    @FXML
    private Label username;
    @FXML
    private Label age;
    @FXML
    private Label netWorth;
    @FXML
    private Label totalIncome;
    @FXML
    private Label spending;
    @FXML
    private Label savings;
    @FXML
    private BarChart<String, Number> bar_chart;
    @FXML
    private ImageView avatarImage;

    private final String pathIni = "ini\\LoginData.ini";

    public void changeChartColor(String name, String fxStyle) {

        //Used to change series color.
        for (XYChart.Series<String, Number> series : bar_chart.getData()) {
            if(series.getName().equals(name))
            {
                System.out.println("Series name: " + series.getName());
                for(XYChart.Data data : series.getData())
                {
                    data.getNode().setStyle(fxStyle);
                }
            }
        }

        //Used to change legend color
        for(Node node : bar_chart.lookupAll("Label.chart-legend-item"))
        {
            Label tempLabel = (Label)node;
            if(tempLabel.getText().equals(name))
            {
                tempLabel.getGraphic().setStyle(fxStyle);
                //"-fx-bar-fill: #2a73ff;" //blueish
                //"-fx-bar-fill: #26bfbc;" //redish
                //"-fx-bar-fill: #fa5f7e;" //pinkish
            }
        }


    }

    public void setUpChart() throws Exception {

        Ini wini = new Ini(new File(pathIni));

        saveData data = (saveData) resourceManager.load("balance.txt");

        //get values from file to fill in the chart
        int salary = data.getSalary();
        int investment = data.getInvestment();
        int credit =  data.getCredit();
        int loan = data.getLoan();
        int home = data.getHome();
        int transport = data.getHome();
        int health = data.getHealth();
        int entertainment = data.getEntertainment();
        int four01k = data.getFour01k();
        int education = data.getEducation();
        int emergencyFund = data.getEmergencyFund();
        int uncategorized = data.getUncategorized();

        //set up chart here
        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName("Savings");
        series1.getData().add(new XYChart.Data<>("401k", four01k));
        series1.getData().add(new XYChart.Data<>("Education", education));
        series1.getData().add(new XYChart.Data<>("E.F", emergencyFund));
        series1.getData().add(new XYChart.Data<>("No Category", uncategorized));

        XYChart.Series series2 = new XYChart.Series<>();
        series2.setName("Income");
        series2.getData().add(new XYChart.Data<>("Salary", salary));
        series2.getData().add(new XYChart.Data<>("Investment", investment));
        series2.getData().add(new XYChart.Data<>("Credit", credit));
        series2.getData().add(new XYChart.Data<>("Loans", loan));

        XYChart.Series series3 = new XYChart.Series<>();
        series3.setName("Spendings");
        series3.getData().add(new XYChart.Data<>("Home", home));
        series3.getData().add(new XYChart.Data<>("Transport", transport));
        series3.getData().add(new XYChart.Data<>("Health", health));
        series3.getData().add(new XYChart.Data<>("Entertainment", entertainment));

        //Add items, change chart color using method, and plotChart
        bar_chart.getData().addAll(series1, series2, series3);
        changeChartColor("Savings", "-fx-bar-fill: #2a73ff;");
        changeChartColor("Income", "-fx-bar-fill: #26bfbc;");
        changeChartColor("Spendings", "-fx-bar-fill: #fa5f7e;");
        plotChart();
    }

    public void readIniFile() {

        try {

            saveData data = (saveData) resourceManager.load("balance.txt");
            File file = new File(pathIni);

            if (file.exists()) {
                Ini wini = new Ini(new File(pathIni));
                int incomev = data.getIncome();
                int savingsv = data.getSavings();
                int spendingv = data.getSpendings();
                int netWorthv = (data.getIncome() + data.getSavings()) - data.getSpendings();
                String namev = data.getName();
                int agev = data.getAge();
                String usernamev = data.getUsername();

                //Set label text to the variables pulled from ini file above
                name.setText(namev);
                username.setText(usernamev);
                age.setText("" + agev);

                netWorth.setText("$" + netWorthv);
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
        try {
            File file = new File("img/jimmy-fallon.png");
            Image avatar = new Image(file.toURI().toString());
            avatarImage.setImage(avatar);
        } catch (Exception e) {
            e.printStackTrace();
        }

        readIniFile();

        try {
            setUpChart();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
