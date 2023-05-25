package server;

import java.io.*;
import java.net.Socket;

public class ServerLogic implements Runnable {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ServerLogic(Socket socket){
        this.socket=socket;
        try {
            bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void run() {

    }
}
