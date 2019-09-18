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
import javafx.stage.Stage;
import org.ini4j.Ini;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class incomeController implements Initializable{

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

    private int salary;
    private int investment;
    private int credit;
    private int loan;
    private int income;

    //-----------------------------------------------Start of Buttons--------------------------------------------------//

    //-----------Salary Buttons------------//
    @FXML
    public void salAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("addPopUp.fxml");
    }

    @FXML
    public void salChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("changePopUp.fxml");
    }

    //------------Investment Buttons---------//
    @FXML
    public void investmentAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("addPopUp.fxml");
    }

    @FXML
    public void investmentChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("changePopUp.fxml");
    }

    //------------------Credit Buttons---------------//
    @FXML
    public void creditAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("addPopUp.fxml");
    }

    @FXML
    public void creditChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("changePopUp.fxml");
    }

    //-------------------Loan Buttons----------------//

    @FXML
    public void loanAddBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("addPopUp.fxml");
    }

    @FXML
    public void loanChangeBtn(ActionEvent actionEvent) throws Exception {
        openPopUp("changePopUp.fxml");
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


            File file = new File(pathIni);
            if (file.exists()) {
                Ini wini = new Ini(new File(pathIni));
                salary = wini.get("income_data", "salary", int.class);
                investment = wini.get("income_data", "investment", int.class);
                credit = wini.get("income_data", "credit", int.class);
                loan = wini.get("income_data", "loan", int.class);
                income = wini.get("balance_data", "income", int.class);

                //Set label text to the variables pulled from ini file above
                salaryVal.setText("$" + salary);
                investmentVal.setText("$" + investment);
                creditVal.setText("$" + credit);
                loanVal.setText("$" + loan);

                salaryVal1.setText("$" + salary);
                investmentVal1.setText("$" + investment);
                creditVal1.setText("$" + credit);
                loanValue1.setText("$" + loan);

                totalIncome.setText("$" + (income));

            }


        } catch (Exception e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readIncomeFromFile();

    }
}
