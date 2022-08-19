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
        nickname, tipo, promedioExamenes, promedioQuiz, promedioTareas, proyecto1, proyecto2,
        proyecto3, promedioProyectos, promedioEvaluaciones, promedioFinal;
 
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

        public String getPromedioExamenes() {
            return promedioExamenes.get();
        }

        public String getPromedioQuiz() {
            return promedioQuiz.get();
        }

        public String getPromedioTareas() {
            return promedioTareas.get();
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

        public String getPromedioProyectos(){
            return promedioProyectos.get();
        }

        public String getPromedioEvaluaciones() {
            return promedioEvaluaciones.get();
        }

        public String getPromedioFinal() {
            return promedioFinal.get();
        }
        
        

 
        Record(String carnet, String nombre, String correo, String telefono,
                String nickname, String tipo, String promedioExamenes, String promedioQuiz, 
                String promedioTareas, String proyecto1, String proyecto2, String proyecto3,
                String promedioProyectos, String promedioEvaluaciones, String promedioFinal) {

            this.carnet = new SimpleStringProperty(carnet);
            this.nombre = new SimpleStringProperty(nombre);
            this.correo = new SimpleStringProperty(correo);
            this.telefono = new SimpleStringProperty(telefono);
            this.nickname = new SimpleStringProperty(nickname);
            this.tipo = new SimpleStringProperty(tipo);
            this.promedioExamenes= new SimpleStringProperty(promedioExamenes);
            this.promedioQuiz= new SimpleStringProperty(promedioQuiz);
            this.promedioTareas= new SimpleStringProperty(promedioTareas);
            this.proyecto1= new SimpleStringProperty(proyecto1);
            this.proyecto2= new SimpleStringProperty(proyecto2);
            this.proyecto3= new SimpleStringProperty(proyecto3);
            this.promedioProyectos= new SimpleStringProperty(promedioProyectos);
            this.promedioEvaluaciones= new SimpleStringProperty(promedioEvaluaciones);
            this.promedioFinal= new SimpleStringProperty(promedioFinal);
            
        }
 
    }
 
    private final TableView<Record> tableView = new TableView<>();
 
    private final ObservableList<Record> dataList = FXCollections.observableArrayList();
 
   

    
    /** 
     * @param InterfazTabla
     * @param archivo
     */
    public void IniciarTable(Stage InterfazTabla, String archivo) {
        
        InterfazTabla.setTitle("Tabla de datos de estudiantes");
 
        Group Columnas = new Group();
 
        TableColumn<Record, String> CarnetColumn = new TableColumn<Record, String>("Carnét");
        CarnetColumn.setCellValueFactory(new PropertyValueFactory<>("carnet"));
 
        TableColumn<Record, String> NombreColumn = new TableColumn<Record, String>("Nombre y apellidos");
        NombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
 
        TableColumn<Record, String> CorreoColumn = new TableColumn<Record, String>("Correo");
        CorreoColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));
 
        TableColumn<Record, String> TelefonoColumn = new TableColumn<Record, String>("Teléfono");
        TelefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
 
        TableColumn<Record, String> NicknameColumn = new TableColumn<Record, String>("Nickname");
        NicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
 
        TableColumn<Record, String> TipoColumn = new TableColumn<Record, String>("Tipo de estudiante");
        TipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Record, String> ExamenesColumn= new TableColumn<Record, String>("Nota promedio (examenes)");
        ExamenesColumn.setCellValueFactory(new PropertyValueFactory<>("promedioExamenes"));

        TableColumn<Record, String> PromedioquizColumn= new TableColumn<Record, String>("Nota promedio (quices)");
        PromedioquizColumn.setCellValueFactory(new PropertyValueFactory<>("promedioQuiz"));

        TableColumn<Record, String> PromediotareasColumn= new TableColumn<Record, String>("Nota promedio (tareas)");
        PromediotareasColumn.setCellValueFactory(new PropertyValueFactory<>("promedioTareas"));

        TableColumn<Record, String> Proyecto1Column= new TableColumn<Record, String>("Nota proyecto #1");
        Proyecto1Column.setCellValueFactory(new PropertyValueFactory<>("proyecto1"));

        TableColumn<Record, String> Proyecto2Column= new TableColumn<Record, String>("Nota proyecto #2");
        Proyecto2Column.setCellValueFactory(new PropertyValueFactory<>("proyecto2"));

        TableColumn<Record, String> Proyecto3Column= new TableColumn<Record, String>("Nota proyecto #3");
        Proyecto3Column.setCellValueFactory(new PropertyValueFactory<>("proyecto3"));

        TableColumn<Record, String> PromedioProyectosColumn= new TableColumn<Record, String>("Nota Promedio (proyectos)");
        PromedioProyectosColumn.setCellValueFactory(new PropertyValueFactory<>("promedioProyectos"));

        TableColumn<Record, String> PromedioEvaluacionesColumn= new TableColumn<Record, String>("Note Promedio (exámenes, quices, tareas)");
        PromedioEvaluacionesColumn.setCellValueFactory(new PropertyValueFactory<>("promedioEvaluaciones"));

        TableColumn<Record, String> PromedioFinalColumn= new TableColumn<Record, String>("Nota Final");
        PromedioFinalColumn.setCellValueFactory(new PropertyValueFactory<>("promedioFinal"));



        

 
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
        tableView.getColumns().add(PromedioProyectosColumn);
        tableView.getColumns().add(PromedioEvaluacionesColumn);
        tableView.getColumns().add(PromedioFinalColumn);

 
        VBox TablaInterfaz = new VBox();
        TablaInterfaz.setSpacing(10);
        TablaInterfaz.getChildren().add(tableView);
 
        Columnas.getChildren().add(TablaInterfaz);
 
        InterfazTabla.setScene(new Scene(Columnas, 1300, 500));
        InterfazTabla.show();
 
        LeerArchivo(archivo);
    }

    


    

  
    
 
    
    /** 
     * @param Archivo
     */
    public void LeerArchivo(String Archivo) {

        String delimitador = ",";
        BufferedReader arhivocsv;

        
 
        try {
            arhivocsv = new BufferedReader(new FileReader(Archivo));

            //Esta linea es para saltarse el encabezado
            arhivocsv.readLine();


            String linea;
            while ((linea = arhivocsv.readLine()) != null) {
                String[] datos = linea.split(delimitador, -1);


                String PromedioProyectos= "";
                String PromedioEvaluaciones= "";
                String PromedioF= "";

                char TipodeEstudiante= datos[5].charAt(0);
                
                if(TipodeEstudiante!='A'){
                    Double resultado1= (Double.parseDouble(datos[9])+
                    Double.parseDouble(datos[10])+Double.parseDouble(datos[11]))/3;

                    Double resultado2= (resultado1+Double.parseDouble(datos[6])+
                    Double.parseDouble(datos[7])+Double.parseDouble(datos[8]))/4;

                    PromedioProyectos=  Math.round(resultado1*100.0)/100.0+"";

                    PromedioF= Math.round(resultado2*100.0)/100.0+"";
                   
                } 

                else{
                    Double resultado1= (Double.parseDouble(datos[6])+
                    Double.parseDouble(datos[7])+Double.parseDouble(datos[8]))/3;

                    Double resultado2= (resultado1+Double.parseDouble(datos[9])+
                    Double.parseDouble(datos[10])+Double.parseDouble(datos[11]))/4;


                    PromedioEvaluaciones= Math.round(resultado1*100.0)/100.0+"";

                    PromedioF= Math.round(resultado2*100.0)/100.0+"";
                }


                Record Datos_para_la_tabla = new Record(datos[0], datos[1], datos[2],
                        datos[3], datos[4], datos[5], datos[6], datos[7],
                        datos[8], datos[9], datos[10], datos[11], PromedioProyectos, 
                        PromedioEvaluaciones, PromedioF);
                dataList.add(Datos_para_la_tabla);
 
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



