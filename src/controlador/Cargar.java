package controlador;


import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import javafx.stage.FileChooser;

public class Cargar {

    static String ruta=null;
    
    
    /** 
     * @return String
     */
    public static String rutaArchivo(){
        return ruta;
    }
        

    
    /** 
     * @param stage
     * @return VBox
     */
    public static VBox CrearBoton(Stage stage) {

        try{
            
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
                            ruta= file.getAbsolutePath();
                        }
                    
                }
            };

            button.setOnAction(evento1);

  
        // create a VBox
        VBox vbox = new VBox(30, label1, button);
        vbox.setAlignment(Pos.TOP_CENTER);

        return vbox;


  
        
    }
  
    catch (Exception e) {
  
        System.out.println(e.getMessage());
    }
        return null;
}
  
}

            
        

