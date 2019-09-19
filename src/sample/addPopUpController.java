package sample;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.*;
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

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        Stage addStage = (Stage) cancelButton.getScene().getWindow();
        addStage.close();
    }

    @FXML
    public void confirmAction(ActionEvent actionEvent) throws Exception {

        int loan;
        int loan1;
        int salary;
        int salary1;
        int credit;
        int credit1;
        int investment;
        int investment1;
        int finall;

        saveData data = new saveData();
        if(addBox.getValue().equals("salary"))
        {
            salary = Integer.parseInt(addValue.getText().trim().toUpperCase());
            salary1 = data.getSalary();
            finall = salary + salary1;
            data.setSalary(finall);
            System.out.println(salary);
            System.out.println(salary1);
            System.out.println(finall);
            resourceManager.save(data, "income.txt");

        }
        else if(addBox.getValue().equals("investment")) {

            investment = Integer.parseInt(addValue.getText().trim().toUpperCase());
            investment1 = data.getInvestment();
            finall = investment + investment1;
            data.setInvestment(finall);
            resourceManager.save(data, "income.txt");

        }
        else if(addBox.getValue().equals("credit")) {

            credit = Integer.parseInt(addValue.getText().trim().toUpperCase());
            credit1 = data.getCredit();
            finall = credit + credit1;
            data.setCredit(finall);
            resourceManager.save(data, "income.txt");

        }
        else if(addBox.getValue().equals("loan")) {

            loan = Integer.parseInt(addValue.getText().trim().toUpperCase());
            loan1 = data.getLoan();
            finall = loan + loan1;
            data.setCredit(finall);
            resourceManager.save(data, "income.txt");

        }
        else {
            System.err.println("Error! Pick a correct choice");
        }
        resourceManager.save(data, "income.txt");



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
