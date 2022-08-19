package Vista;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import controlador.*;

public class Interfaz extends Application {


   
  public static void main(String[] args) {
      launch(args);
      
      
  }
  
  @Override
  public void start(Stage pantalla_inicial) throws IOException {
    Tabla datos= new Tabla();

  
    


      //Se hace uso de la clase cargar
      VBox Archivo = Cargar.CrearBoton(pantalla_inicial);

      pantalla_inicial.setTitle("Hello World!");
      Button btn = new Button();
      btn.setText("Say 'Hello World'");
      btn.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
            String ruta = Cargar.rutaArchivo();
            if(ruta!=null){
              datos.IniciarTable(pantalla_inicial, ruta);
            }
          }
      });

      
      
      StackPane root = new StackPane();
      root.getChildren().add(Archivo);
      root.getChildren().add(btn);
      pantalla_inicial.setScene(new Scene(root, 800, 500));



      pantalla_inicial.show();


  }

  

  
}
