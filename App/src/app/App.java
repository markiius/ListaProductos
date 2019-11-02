/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import login.Formulario;
import login.Login;
import traver0.Tracer;

/**
 *
 * @author Marco
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           /* Formulario ventana = new Formulario();
            ventana.setTitle("Iniciar sesion");
            ventana.setVisible(true);*/
            Test p = new Test();
            cdp.testAutentificar();
            //p.testNoAutentificado();
            
    }
    
}

class Test{
        Test(){}
        void testAutentificar(){
           Login.getInstance().setResource(new Sesion());
           Login.getInstance().autentificcate();
          
        }
        
        void testNoAutentificado(){
            (new Formulario()).show();
        }
}
