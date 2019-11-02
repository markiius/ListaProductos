
package traver0;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.scene.input.DataFormat;

public class Tracer {
    
    private static Tracer instance;
    private PrintWriter out;
    private DateFormat dt;
    private static final String filename="log.txt";
    
    private Tracer(){
        try{
            out = new PrintWriter(
            new BufferedOutputStream(new FileOutputStream(filename,true)),true);
            dt = DateFormat.getDateTimeInstance(
                    DateFormat.SHORT,
                    DateFormat.DEFAULT,
                    new Locale("es","ES"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public static Tracer getInstance(){
        if(instance == null){
            instance = new Tracer(); 
        }
        return instance;
    }
    
    synchronized public void addLine(String mensaje){
         out.print(dt.format(new Date()));
         out.println(": " + mensaje);
    }
    
    public BufferedReader getContent(){
        BufferedReader result = null;
        try{
            result = new BufferedReader(new FileReader(filename));  
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
}
