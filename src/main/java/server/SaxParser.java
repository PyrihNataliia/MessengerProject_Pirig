package server;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SaxParser extends DefaultHandler{

    private String thisElement = "";
    private String name;
   private String password;

   private String sendTo;
   private String text;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement=qName;
    }
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equalsIgnoreCase("name")){
            name= new String(ch, start, length);
        }
       else if(thisElement.equalsIgnoreCase("password")){
           password=new String(ch, start, length);
        }
       else if(thisElement.equalsIgnoreCase("sendto")){
           sendTo=new String(ch, start, length);
        }
        else if(thisElement.equalsIgnoreCase("text")){
            text=new String(ch, start, length);
        }
    }
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement="";
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getSendTo(){
        return sendTo;
    }

    public String getText(){
        return text;
    }

}
