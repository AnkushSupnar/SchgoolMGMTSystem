package com.school.controller.userlogin;

import com.school.common.CommonData;
import com.school.data.service.LoginService;
import com.school.view.AlertNotification;
import com.school.view.FxmlView;
import com.school.view.StageManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {
   // private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired @Lazy
    StageManager stageManager;
    
    @FXML private AnchorPane mainPane;
    @FXML private ComboBox<String> cmbUserName;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin;
    @FXML private Hyperlink linkAddEmployee;
    @FXML private Text txtQuestion;
    @Autowired
    private LoginService loginService;
    @Autowired
    private AlertNotification alert;
    private ObservableList<String>userNameList= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtQuestion.setVisible(false);
        linkAddEmployee.setVisible(false);
        userNameList.addAll(loginService.getAllUserNames());
        try {
            if (userNameList.isEmpty()) {
                System.out.println("No login found");
                linkAddEmployee.setVisible(true);
                stageManager.switchScene(FxmlView.CREATE);
            }
            else{
                cmbUserName.setItems(userNameList);
                linkAddEmployee.setOnAction(e->{
                    //stageManager.switchScene(FxmlView.EMPLOYEE);
                    stageManager.switchScene(FxmlView.CREATE);
                    stageManager.showFullScreen();
                });
                btnLogin.setOnAction(e->login());
//        PrintBill printbill = new PrintBill();
//        printbill.setBill(billService.getBillByBillNo(44));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    private void login() {
        try {
            if(cmbUserName.getValue()==null)
            {
                alert.showError("Select Your Name");
                cmbUserName.requestFocus();
                return;
            }
            if(txtPassword.getText().isEmpty())
            {
                alert.showError("Enter Your Password");
                txtPassword.requestFocus();
                return;
            }
            if(loginService.validate(cmbUserName.getValue(),txtPassword.getText())==1)
            {
                alert.showSuccess("Wel come "+cmbUserName.getValue());
                CommonData.setLoginUser(loginService.getLoginByUserName(cmbUserName.getValue()));
               

                stageManager.switchScene(FxmlView.HOME);
                stageManager.showFullScreen();
            }
            else
            {
                alert.showError("Wrong Password!");
            }
        }catch(Exception e)
        {
            alert.showError("Error in Login");
            e.printStackTrace();
        }
    }
}
