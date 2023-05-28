package com.example.messenger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class ipFormController {
    @FXML
    TextField tf_ip;

    @FXML
    Button bt_send;

    private CommonMethods commonMethods= new CommonMethods();
    private Client client;

    @FXML
    void initialize(){
        bt_send.setOnAction(event->{
            String ip =tf_ip.getText().trim();
            if(!ip.isBlank()){
                ClientConnection.initialize(ip);
                commonMethods.changeScene(bt_send, "logIn.fxml", "Log in form");
            }
        });
    }

}
