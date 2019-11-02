
package login;

import app.Sesion;
import login.Formulario;
import login.IResource;
import traver0.Tracer;
//import traver0.BufferedOutStream;

/**
 *
 * singleton
 */
public class Login {
    
    private String usuario;
    private String password;
    private static Login instance;
    private static IResource resource;
    private static final String masterPassword = "Jefa";
  
    
    private Login(){
        usuario="";
        password="";
    }
    
    public static Login getInstance(){
        if(instance == null){
            instance = new Login(); 
        }
        return instance;
    }

    public void setResource(IResource resource) {
        Login.resource = resource;
    }
    
    
     public static IResource getResource(){
         if(resource == null){
            resource = new Sesion();
        }
        return resource;
    }
    
    
    public String getUsuario(){
        String result;
        if(usuario.equals("")){
            usuario = "Anonimo";
        }
        result=usuario;
        return result;
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    
    public String getContraseña(){
        return password;
    }
    
    public void setContraseña(String password){
        this.password=password;
    }
    
    public void autentificcate(){
         (new Formulario()).show();
    }
    
    boolean validate(){
        boolean result = false;
        
        if(password.compareTo(masterPassword)==0){
            Tracer.getInstance().addLine(getUsuario() + " " +" Inicio sesion " );
            result = true;
        }else{
            Tracer.getInstance().addLine(getUsuario() + " " +" Iniento inicar sesion ");            
        }
        return result;
    }
   
}
