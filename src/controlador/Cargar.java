package controlador;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Cargar extends Application{
    
    @Override
    public void start(Stage stage) {

        try{
            //Se escoge el titulo 
            stage.setTitle("Escoge el archivo");

            //Se crea una instantacia de FileChooser

            FileChooser escoge_archivo= new FileChooser();

            //Se escoge el titulo
            escoge_archivo.setTitle("Escoge archivo");

            //Se inicia el archivo
            escoge_archivo.setInitialDirectory(new File("C:\\"));
            

        }


    }



    
}
