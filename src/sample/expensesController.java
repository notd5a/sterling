package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class expensesController implements Initializable {
    @FXML
    private Label salaryVal;

    @FXML
    private Label salaryVal1;

    @FXML
    private Label investmentVal;

    @FXML
    private Label investmentVal1;

    @FXML
    private Label creditVal;

    @FXML
    private Label creditVal1;

    @FXML
    private Label loanVal;

    @FXML
    private Label loanValue1;

    @FXML
    private Label totalIncome;

    //-----------------------------------------------Start of Buttons--------------------------------------------------//

    //-----------Salary Buttons------------//
    @FXML
    public void salAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingsaddPopUp.fxml");
    }

    @FXML
    public void salChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingschangePopUp.fxml");
    }

    //------------Investment Buttons---------//
    @FXML
    public void investmentAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingsaddPopUp.fxml");
    }

    @FXML
    public void investmentChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingschangePopUp.fxml");
    }

    //------------------Credit Buttons---------------//
    @FXML
    public void creditAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingsaddPopUp.fxml");
    }

    @FXML
    public void creditChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingschangePopUp.fxml");    }

    //-------------------Loan Buttons----------------//

    @FXML
    public void loanAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingsaddPopUp.fxml");
    }

    @FXML
    public void loanChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("SpendingschangePopUp.fxml");
    }
    //-----------------------------------------------End of Buttons--------------------------------------------------//

    //-----------Path to config file ---------///
    private final String pathIni = "ini\\LoginData.ini";

    public void openPopUp(String path) throws Exception {

        Stage popUpStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        popUpStage.setTitle("Sterling");
        popUpStage.setScene(new Scene(root, 375, 300));
        popUpStage.setResizable(false);
        popUpStage.show();

    }

    public void readIncomeFromFile() {

        try {

            saveData data = (saveData) resourceManager.load("balance.txt");
            salaryVal.setText("$" + data.getHome());
            salaryVal1.setText("$" + data.getHome());
            investmentVal.setText("$" + data.getTransport());
            investmentVal1.setText("$" + data.getTransport());
            creditVal.setText("$" + data.getHealth());
            creditVal1.setText("$" + data.getHealth());
            loanVal.setText("$" + data.getEntertainment());
            loanValue1.setText("$" + data.getEntertainment());
            int total = data.getHome() + data.getTransport() + data.getHealth() + data.getEntertainment();
            data.setSpendings(total);
            totalIncome.setText("$" + total);
            resourceManager.save(data, "balance.txt");


        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readIncomeFromFile();

    }
}
