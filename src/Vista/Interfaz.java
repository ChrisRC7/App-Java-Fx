package Vista;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

import controlador.*;

public class Interfaz extends Application {


   
  
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
      pantalla_inicial.setScene(new Scene(root, 1300, 500));



      pantalla_inicial.show();


  }

  

  
}
