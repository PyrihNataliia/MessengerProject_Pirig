package com.example.messenger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

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
    private CommonMethods commonMethods= new CommonMethods();

    @FXML
    void initialize(){
        bt_signUp_l.setOnAction(event->{
           commonMethods.changeScene(bt_signUp_l,"signUp.fxml", "Sign up form" );
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
                String status="Fail";
                if(status.equals("Success")){
                    commonMethods.changeScene(bt_logIn_l,"hello-view.fxml", "Main page" );
                }
                else{
                    Alert alert= new Alert(Alert.AlertType.CONFIRMATION,"Do you already have an account?" ,ButtonType.YES,ButtonType.NO);
                    alert.setTitle("Have an account?");
                    Optional<ButtonType> result=alert.showAndWait();
                    if(result.get()==ButtonType.YES){
                        commonMethods.alertMessage("Check","Double check your input", "Check the correctness of input data!" );
                        tf_password.clear();
                    }
                    else{
                        commonMethods.alertMessage("Sign Up","You need to create a new account","");
                        commonMethods.changeScene(bt_signUp_l,"signUp.fxml", "Sign up form" );
                    }
                }
            }
            else{
                commonMethods.alertMessage("Error","Double check your input", "You haven't enter your username or password!" );
            }

        });
    }


}
