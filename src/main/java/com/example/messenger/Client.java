package com.example.messenger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedWriter bufferedWriter;

    private BufferedReader bufferedReader;


    public Client(Socket socket){
        this.socket=socket;
        try {
            bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            cleanAndClose();
            throw new RuntimeException(e);
        }
    }

    public void initializeUser(String name, String password, String type ){

        String str= String.format("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><message><type>%s</type><name>%s</name><password>%s</password></message>", type, name, password);
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void cleanAndClose() {
        if(bufferedWriter!= null || bufferedReader!=null){
            try {
                bufferedWriter.close();
                bufferedReader.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
