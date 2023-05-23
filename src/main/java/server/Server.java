package server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.net.Socket;
import java.net.ServerSocket;

public class Server extends JFrame{
    private JTextArea textArea1;
    private JButton startButton;
    private JButton stopButton;
    private JPanel serverPanel;

    public Server() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
    }

    public static void main(String[] args) {
        Server s= new Server();
        s.setContentPane(s.serverPanel);
        s.setTitle("Server side");
        s.setSize(480, 320);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void start(){
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            writeText("Server was started");
            startButton.setEnabled(false);
            stopButton.setEnabled(true);

            while(true){
                Socket clientSocket= serverSocket.accept();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void stop(){
        int stopQuestion= JOptionPane.showConfirmDialog(this, "Do you confirm the stop of the server?","Confirm the stop", JOptionPane.YES_NO_OPTION);
        if(stopQuestion==JOptionPane.YES_OPTION){
            writeText("The server was stopped");
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }
    private void writeText(String m) {
        LocalDateTime date = LocalDateTime.now();
        textArea1.append(date + " "+ m+ "\n");
    }

}
