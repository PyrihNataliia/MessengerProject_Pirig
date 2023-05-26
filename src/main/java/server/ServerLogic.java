package server;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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

    public void getUserInformation(){
        String message;
        while(socket.isConnected()){
            try {
                message= bufferedReader.readLine();
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                SaxParser saxp = new SaxParser();
                InputStream m2 = new ByteArrayInputStream(message.getBytes());
                parser.parse(m2, saxp);
                String name= saxp.getName();
                String password=saxp.getPassword();
                System.out.println("Username:"+name+" Password: "+ password);
            } catch (IOException | SAXException | ParserConfigurationException e) {
                throw new RuntimeException(e);
            }
    }
    }
    @Override
    public void run() {
       getUserInformation();
        }


}
