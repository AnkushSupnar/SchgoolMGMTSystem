package com.school.controller.userlogin;

import com.school.data.entity.Employee;
import com.school.data.service.EmployeeService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtContact;
    @FXML private TextField txtEmail;
    @FXML private TextField txtRole;
    @FXML private Button btnRegister;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private void registerEmployee() {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String role = txtRole.getText();

        if (name.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty() || role.isEmpty()) {
            showAlert("Error", "All fields must be filled!");
            return;
        }

        Employee employee = new Employee(name, address, contact, email, role);
        employeeService.saveEmployee(employee);

        showAlert("Success", "Employee registered successfully!");
        clearFields();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtRole.clear();
    }
}
