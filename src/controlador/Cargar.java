package controlador;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import java.io.*;
import javafx.stage.FileChooser;

public class Cargar extends Application {

    @Override
    public void start(Stage stage) {

        try{
            //Se escoge el titulo 
            stage.setTitle("Escoge el archivo");

            //Se crea una instantacia de FileChooser

            FileChooser escoge_archivo= new FileChooser();

            //Se escoge el titulo
            escoge_archivo.setTitle("Buscar archivo");
            

            //Se limita al tipo de archivo que se puede selecionar
            escoge_archivo.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("CSV", "*.csv*")
                    );

            //Se inicia el archivo
            escoge_archivo.setInitialDirectory(new File("C:\\"));

            //Se crea un Label
            Label label1= new Label("Archivo no selecionado");

            //Se crea un boton
            Button button= new Button("Escoger Archivo");

            //Se crea un evento tipo Handler
            EventHandler<ActionEvent> evento1=new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){

                    //Se toma el archivo
                    File file= escoge_archivo.showOpenDialog(stage);
                    
                        if(file!=null) {
                            label1.setText(file.getAbsolutePath()+ " selected");
                        }
                    
                }
            };

            button.setOnAction(evento1);

  
        // create a VBox
        VBox vbox = new VBox(30, label1, button);
  
        // set Alignment
        vbox.setAlignment(Pos.CENTER);
  
        // create a scene
        Scene scene = new Scene(vbox, 800, 500);
  
        // set the scene
        stage.setScene(scene);
  
        stage.show();
    }
  
    catch (Exception e) {
  
        System.out.println(e.getMessage());
    }
}
  
// Main Method
public static void main(String args[])
{
  
    // launch the application
    launch(args);
}
}

            
        

