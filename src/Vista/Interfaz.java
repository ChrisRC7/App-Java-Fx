package Vista;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

import controlador.*;

public class Interfaz extends Tabla {


   
  
  /** 
   * @param args
   */
  public static void main(String[] args) {
      launch(args);
      
      
  }
  
  
  /** 
   * @param pantalla_inicial
   * @throws IOException
   */
  @Override
  public void start(Stage pantalla_inicial) throws IOException {


  
    


      //Se hace uso de la clase cargar
      VBox Archivo = Cargar.CrearBoton(pantalla_inicial);

      pantalla_inicial.setTitle("Menu de Inicio");
      Button boton = new Button();
      boton.setText("Cargar archivo");
      boton.setOnAction(new EventHandler<ActionEvent>() {


          @Override
          public void handle(ActionEvent event) {
            //Sobrecarga
            String ruta = Cargar.Table();
            if(ruta!=null){
              Table(pantalla_inicial, ruta);
            }
          }
      });

      
      
      StackPane ventana = new StackPane();
      ventana.getChildren().add(Archivo);
      ventana.getChildren().add(boton);
      pantalla_inicial.setScene(new Scene(ventana, 1300, 500));



      pantalla_inicial.show();


  }

  

  
}
