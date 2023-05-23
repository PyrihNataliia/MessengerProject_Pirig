package com.example.messenger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class logInContoller {
    @FXML
    Button bt_logIn_l;
    @FXML
    Button bt_signUp_l;

    @FXML
    void initialize(){
        bt_signUp_l.setOnAction(event->{
            bt_signUp_l.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(logInContoller.class.getResource("signUp.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root =fxmlLoader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Sign up form");
            stage.show();
        });
    }

}
