package com.example.messenger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController {
    @FXML
    Button bt_sigup_s;

    @FXML
    Button bt_login_s;

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
