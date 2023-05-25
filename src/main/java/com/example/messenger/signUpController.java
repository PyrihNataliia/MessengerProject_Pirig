package com.example.messenger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController {
    @FXML
    Button bt_sigup_s;
    @FXML
    Button bt_login_s;
    @FXML
    TextField tf_name_s;
    @FXML
    TextField tf_password_s;

    @FXML
    void initialize(){
        bt_sigup_s.setOnAction(event->{
            String Name=tf_name_s.getText().trim();
            String Password= tf_password_s.getText().trim();

            if(!Name.isBlank()&& !Password.isBlank()){

            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Double check your input");
                alert.setContentText("You haven't enter your username or password!");
                alert.showAndWait();
            }
        });
    }
    @FXML
    public void logInclick(){
        bt_login_s.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(signUpController.class.getResource("logIn.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root =fxmlLoader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Log in form");
            stage.show();
    }



}
