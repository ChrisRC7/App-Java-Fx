package controlador;


 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 

public class Tabla{
 
    public class Record {
       
        private SimpleStringProperty carnet, nombre, correo, telefono, 
        nickname, tipo, examenes, promedioquiz, promediotareas, proyecto1, proyecto2,
        proyecto3, promedioP;
 
        public String getCarnet() {
            return carnet.get();
        }
 
        public String getNombre() {
            return nombre.get();
        }
 
        public String getCorreo() {
            return correo.get();
        }
 
        public String getTelefono() {
            return telefono.get();
        }
 
        public String getNickname() {
            return nickname.get();
        }
 
        public  String getTipo() {
            return tipo.get();
        }

        public String getExamenes() {
            return examenes.get();
        }

        public String getPromedioquiz() {
            return promedioquiz.get();
        }

        public String getPromediotareas() {
            return promediotareas.get();
        }

        public String getProyecto1() {
            return proyecto1.get();
        }

        public String getProyecto2() {
            return proyecto2.get();
        }

        public String getProyecto3() {
            return proyecto3.get();
        }

        public String getPromedioP() {
            return promedioP.get();
        }
        

 
        Record(String carnet, String nombre, String correo, String telefono,
                String nickname, String tipo, String examenes, String promedioquiz, 
                String promediotareas, String proyecto1, String proyecto2, String proyecto3,
                String promedioP) {

            this.carnet = new SimpleStringProperty(carnet);
            this.nombre = new SimpleStringProperty(nombre);
            this.correo = new SimpleStringProperty(correo);
            this.telefono = new SimpleStringProperty(telefono);
            this.nickname = new SimpleStringProperty(nickname);
            this.tipo = new SimpleStringProperty(tipo);
            this.examenes= new SimpleStringProperty(examenes);
            this.promedioquiz= new SimpleStringProperty(promedioquiz);
            this.promediotareas= new SimpleStringProperty(promediotareas);
            this.proyecto1= new SimpleStringProperty(proyecto1);
            this.proyecto2= new SimpleStringProperty(proyecto2);
            this.proyecto3= new SimpleStringProperty(proyecto3);
            this.promedioP= new SimpleStringProperty(promedioP);
            
        }
 
    }
 
    private final TableView<Record> tableView = new TableView<>();
 
    private final ObservableList<Record> dataList = FXCollections.observableArrayList();
 
   

    public void IniciarTable(Stage primaryStage, String archivo) {
        
        primaryStage.setTitle("CVS");
 
        Group root = new Group();
 
        TableColumn<Record, String> CarnetColumn = new TableColumn<Record, String>("carnet");
        CarnetColumn.setCellValueFactory(new PropertyValueFactory<>("carnet"));
 
        TableColumn<Record, String> NombreColumn = new TableColumn<Record, String>("nombre");
        NombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
 
        TableColumn<Record, String> CorreoColumn = new TableColumn<Record, String>("correo");
        CorreoColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));
 
        TableColumn<Record, String> TelefonoColumn = new TableColumn<Record, String>("telefono");
        TelefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
 
        TableColumn<Record, String> NicknameColumn = new TableColumn<Record, String>("nickname");
        NicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
 
        TableColumn<Record, String> TipoColumn = new TableColumn<Record, String>("tipo");
        TipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Record, String> ExamenesColumn= new TableColumn<Record, String>("examenes");
        ExamenesColumn.setCellValueFactory(new PropertyValueFactory<>("examenes"));

        TableColumn<Record, String> PromedioquizColumn= new TableColumn<Record, String>("promedioquiz");
        PromedioquizColumn.setCellValueFactory(new PropertyValueFactory<>("promedioquiz"));

        TableColumn<Record, String> PromediotareasColumn= new TableColumn<Record, String>("promediotareas");
        PromediotareasColumn.setCellValueFactory(new PropertyValueFactory<>("promediotareas"));

        TableColumn<Record, String> Proyecto1Column= new TableColumn<Record, String>("proyecto1");
        Proyecto1Column.setCellValueFactory(new PropertyValueFactory<>("proyecto1"));

        TableColumn<Record, String> Proyecto2Column= new TableColumn<Record, String>("proyecto2");
        Proyecto2Column.setCellValueFactory(new PropertyValueFactory<>("proyecto2"));

        TableColumn<Record, String> Proyecto3Column= new TableColumn<Record, String>("proyecto3");
        Proyecto3Column.setCellValueFactory(new PropertyValueFactory<>("proyecto3"));

        TableColumn<Record, String> PromedioPColumn= new TableColumn<Record, String>("Promedio de Proyecto");
        PromedioPColumn.setCellValueFactory(new PropertyValueFactory<>("promedioP"));



        

 
        tableView.setItems(dataList);

        tableView.getColumns().add(CarnetColumn);
        tableView.getColumns().add(NombreColumn);
        tableView.getColumns().add(CorreoColumn);
        tableView.getColumns().add(TelefonoColumn);
        tableView.getColumns().add(NicknameColumn);
        tableView.getColumns().add(TipoColumn);
        tableView.getColumns().add(ExamenesColumn);
        tableView.getColumns().add(PromedioquizColumn);
        tableView.getColumns().add(PromediotareasColumn);
        tableView.getColumns().add(Proyecto1Column);
        tableView.getColumns().add(Proyecto2Column);
        tableView.getColumns().add(Proyecto3Column);
        tableView.getColumns().add(PromedioPColumn);

 
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().add(tableView);
 
        root.getChildren().add(vBox);
 
        primaryStage.setScene(new Scene(root, 700, 250));
        primaryStage.show();
 
        LeerArchivo(archivo);
    }

    


    

  
    
 
    public void LeerArchivo(String Archivo) {
 
        //String CsvFile ="C:/Users/chris/Desktop/Materia/Algoritmo y Estructuras de Datos 1/Tarea 1/ejemplo_TEq.csv";
        String FieldDelimiter = ",";
        BufferedReader br;

        
 
        try {
            br = new BufferedReader(new FileReader(Archivo));

            //Esta linea es para saltarse el encabezado
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);

                String PromedioP= "";
                char TipodeEstudiante= fields[5].charAt(0);
                
                if(TipodeEstudiante!='A'){
                    PromedioP= ((Integer.parseInt(fields[9])+
                Integer.parseInt(fields[10])+Integer.parseInt(fields[11]))/3)+"";
                }
                Record record = new Record(fields[0], fields[1], fields[2],
                        fields[3], fields[4], fields[5], fields[6], fields[7],
                        fields[8], fields[9], fields[10], fields[11], PromedioP);
                dataList.add(record);
 
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tabla.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tabla.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
 
    }
 

}



