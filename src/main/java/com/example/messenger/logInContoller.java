package com.example.messenger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.net.Socket;

public class logInContoller {
    @FXML
    TextField tf_ip;
    @FXML
    TextField tf_userName;
    @FXML
    TextField tf_password;

    @FXML
    Button bt_logIn_l;
    @FXML
    Button bt_signUp_l;

    private Client client;

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
        bt_logIn_l.setOnAction(event->{
            String Name=tf_userName.getText().trim();
            String Password= tf_password.getText().trim();
            String ip= tf_ip.getText().trim();
            if(!Name.isBlank()&& !Password.isBlank()&& !ip.isBlank()){
                try {
                    client = new Client(new Socket(tf_ip.getText().trim(), 8080));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                client.initializeUser(Name, Password, "logIn");
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


}
