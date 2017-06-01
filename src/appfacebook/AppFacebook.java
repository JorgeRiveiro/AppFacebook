/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfacebook;

import javax.swing.JOptionPane;

/**
 *
 * @author JorgePc
 */
public class AppFacebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos met= new Metodos();
        int opcion;
        met.acceso();
        do {
         opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Nova publicación \n 2.Publicar unha Foto \n 3.Comentar publicación \n4.Comentar foto \n6.Salir" ));
         switch(opcion){
             case 1:
               met.publicar("Hola");
                 break;
             case 2:
                met.postFoto();
                 break;
             case 3:
                 met.commentPublicacion();
                 break;
             case 4:
                 met.comentarioFoto("Bonita foto");
                 break;
             
             case 5:
                 System.exit(opcion);
         }
        }while(opcion!=0);
    }
    
}
