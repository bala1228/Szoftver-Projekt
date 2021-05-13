package hu.unideb.inf;

import Components.Alaplap;
import Components.Gephaz;
import Components.Memoria;
import Components.Processzor;
import Components.Videokartya;

import Database.Db_gephaz;
import Database.Db_alaplap;
import Database.Db_memoria;
import Database.Db_processzor;
import Database.Db_videokartya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;



  


public class FXMLController implements Initializable {
    
   Db_gephaz gh=new Db_gephaz();
   Db_alaplap al=new Db_alaplap();
   Db_memoria m=new Db_memoria();
   Db_processzor pr=new Db_processzor();
   Db_videokartya vk=new Db_videokartya();
    
   private final String MENU_EXIT="Kilépés";
   private final String MENU_GEPHAZAK="Gépházak"; 
   private final String MENU_PC_RESZEK="PC részek"; 
   private final String MENU_ALAPLAP="Alaplapok";
   private final String MENU_MEMORIA="Memóriák";
   private final String MENU_PROCESSZOR="Processzorok";
   private final String MENU_VIDEOKARTYA="Videokartya";
   
   @FXML
    private AnchorPane BASE;
   
    @FXML
    private StackPane menuPane;

    @FXML
    private Pane starterPane;
  /*###################################################################*/  
    /*gépház*/
    
    @FXML
    private Pane hazPane;

    @FXML
    private TableView hazTable;
     
    @FXML
    private Pane popUpGephazHozzadasPane; 
    
    @FXML
    private TextField gephazExportFileNeveInput;
    
    @FXML
    private Pane popUpGephazExportPane;
    
    @FXML
    private TextField gephazHozzadasNameInput;

    @FXML
    private TextField gephazHozzadasFormfactorInput;

    @FXML
    private TextField gephazHozzadasVentsInput;

    @FXML
    private TextField gephazHozzadasStorageInput;

    @FXML
    private TextField gephazHozzadasGPULengthInput;

    @FXML
    private TextField gephazHozzadasPriceInput; 
    
    @FXML
    //Gépház almenü -> Exportalás gomb Action        
    void exportalasAGephazhoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true); 
        
        hazPane.setOpacity(0.3);
        hazPane.setDisable(true); 
        popUpGephazExportPane.setVisible(true);
    }

    @FXML
    //Gépház almenü -> Exportálás gomb -> Exportálás popup -> Mégse gomb Action        
    void popUpGephazExportalasMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        hazPane.setOpacity(1);
        hazPane.setDisable(false); 
        popUpGephazExportPane.setVisible(false);
    }

    @FXML
    //Gépház almenü -> Exportálás gomb -> Exportálás popup -> PDF Mentés gomb Action        
    void popUpGephazExportalasPDFBttAction(ActionEvent event) {
               
        String fileNev=gephazExportFileNeveInput.getText();
        fileNev = fileNev.replaceAll("\\s+","");
        
        if(fileNev != null && !fileNev.equals("") )
        {              
            PdfGeneration pdfCreator=new PdfGeneration();
            pdfCreator.pdfGenrationGephaz(fileNev,dataGephaz);
        }
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        hazPane.setOpacity(1);
        hazPane.setDisable(false); 
        popUpGephazExportPane.setVisible(false);
    }

    @FXML
    //Gépház almenü -> Hozzáadás gomb -> Hozzáadás popUp -> Hozzáadás gomb Action        
    void popUpGephazHozzaadasBttAction(ActionEvent event) {
        try
        {
        Gephaz newGephaz= new Gephaz(
                gephazHozzadasNameInput.getText(),
                gephazHozzadasFormfactorInput.getText(),
                gephazHozzadasVentsInput.getText(),
                gephazHozzadasStorageInput.getText(),               
                gephazHozzadasGPULengthInput.getText(),
                gephazHozzadasPriceInput.getText());   
                  
        dataGephaz.add(newGephaz);
        gh.addGephaz(newGephaz);
                  
        gephazHozzadasNameInput.clear();
        gephazHozzadasFormfactorInput.clear();
        gephazHozzadasVentsInput.clear();
        gephazHozzadasStorageInput.clear();             
        gephazHozzadasGPULengthInput.clear();
        gephazHozzadasPriceInput.clear();
        
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        hazPane.setOpacity(1);
        hazPane.setDisable(false); 
        popUpGephazHozzadasPane.setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    //Gépház almenü -> Hozzáadás gomb -> Hozzáadás popUp -> Mégse gomb Action  
    void popUpGephazMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        hazPane.setOpacity(1);
        hazPane.setDisable(false); 
        popUpGephazHozzadasPane.setVisible(false);
    }

    @FXML
    //Gépház almenü -> Hozzáadás gomb Action        
    void ujHozzadasAGephazhoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true); 
        
        hazPane.setOpacity(0.3);
        hazPane.setDisable(true); 
        popUpGephazHozzadasPane.setVisible(true);
    }
    
    
    private final ObservableList<Gephaz> dataGephaz=
            FXCollections.observableArrayList();
    
    
   
    
    public void setTableDataGephaz(){
        TableColumn nevCol= new TableColumn("Gépház:");
        nevCol.setMinWidth(100);
        nevCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nevCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("name"));
        
        nevCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        Gephaz actualGephaz= (Gephaz) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualGephaz.setName(t.getNewValue());
                        gh.updateGephaz(actualGephaz);
                    }
                }
        );
        
        
         TableColumn alaplaptipusCol= new TableColumn("Alaplaptípusa:");
        alaplaptipusCol.setMinWidth(100);
        alaplaptipusCol.setCellFactory(TextFieldTableCell.forTableColumn());
        alaplaptipusCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("formfactor"));
        
        alaplaptipusCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                         Gephaz actualGephaz= (Gephaz) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualGephaz.setFormfactor(t.getNewValue());
                        gh.updateGephaz(actualGephaz);
                    }
                }
        );
        
         TableColumn beepitetVentilatorokSzamaCol= new TableColumn("Beépített ventilatorok száma:");
        beepitetVentilatorokSzamaCol.setMinWidth(100);
        beepitetVentilatorokSzamaCol.setCellFactory(TextFieldTableCell.forTableColumn());
        beepitetVentilatorokSzamaCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("vents"));
        
         beepitetVentilatorokSzamaCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                         Gephaz actualGephaz= (Gephaz) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualGephaz.setVents(t.getNewValue());
                        gh.updateGephaz(actualGephaz);
                    }
                }
        );
        
  
        
         TableColumn ssdhelyCol= new TableColumn("Storage:");
        ssdhelyCol.setMinWidth(100);
        ssdhelyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ssdhelyCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("storage"));
        
        ssdhelyCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        Gephaz actualGephaz= (Gephaz) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualGephaz.setStorage(t.getNewValue());
                        gh.updateGephaz(actualGephaz);
                    }
                }
        );
        
        TableColumn gpuCol= new TableColumn("GPULength");
        gpuCol.setMinWidth(100);
        gpuCol.setCellFactory(TextFieldTableCell.forTableColumn());
        gpuCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("GPULength"));
        
        gpuCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                         Gephaz actualGephaz= (Gephaz) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualGephaz.setGPULength(t.getNewValue());
                        gh.updateGephaz(actualGephaz);
                    }
                }
        );
                    
        
         TableColumn arCol= new TableColumn("Ár");
        arCol.setMinWidth(100);
        arCol.setCellFactory(TextFieldTableCell.forTableColumn());
        arCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("price"));
        
        arCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        Gephaz actualGephaz= (Gephaz) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualGephaz.setPrice(t.getNewValue());
                        gh.updateGephaz(actualGephaz);
                    }
                }
        );
        
        TableColumn removeCol= new TableColumn("Törlés");
        

        Callback<TableColumn<Gephaz, String>, TableCell<Gephaz, String>> cellFactory = 
                new Callback<TableColumn<Gephaz, String>, TableCell<Gephaz, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Gephaz, String> param )
                    {
                        final TableCell<Gephaz, String> cell = new TableCell<Gephaz, String>()
                        {   
                            final Button btn = new Button( "Törlés" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                                Gephaz gephaz = getTableView().getItems().get( getIndex() );
                                                dataGephaz.remove(gephaz);
                                                gh.removeGephaz(gephaz);
                                            } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
        
        
        hazTable.getColumns().addAll(nevCol,alaplaptipusCol,
                beepitetVentilatorokSzamaCol,ssdhelyCol,gpuCol,arCol,removeCol);
        
        dataGephaz.addAll(gh.getAllGephaz());
        
        hazTable.setItems(dataGephaz);
    } 
    
    
    
    /*#####################################################*/
     
    @FXML
    private TableView alaplapTable;
    
    @FXML
    private Pane alaplapPane;

    @FXML
    private Button HozzadasAlaplapBtt;

    @FXML
    private Button ExportálásAlaplapBtt;

    @FXML
    private Pane popUpAlaplapHozzadasPane;

    @FXML
    private TextField alaplapHozzadasNameInput;

    @FXML
    private TextField alaplapHozzadasFormfactorInput;

    @FXML
    private TextField alaplapHozzadasSocketInput;

    @FXML
    private TextField alaplapHozzadasMemoryslotInput;

    @FXML
    private TextField alaplapHozzadasAmountofmemInput;
   
    @FXML
    private TextField alaplapHozzadasPriceInput;

    @FXML
    private Pane popUpAlaplapExportPane;

    @FXML
    private TextField alaplapExportFileNeveInput;


    @FXML
    void exportalasAzAlaplaphoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true); 
        
        alaplapPane.setOpacity(0.3);
        alaplapPane.setDisable(true); 
        popUpAlaplapExportPane.setVisible(true);
    }

    @FXML
    void popUpAlaplapExportalasMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        alaplapPane.setOpacity(1);
        alaplapPane.setDisable(false); 
        popUpAlaplapExportPane.setVisible(false);
    }

    @FXML
    void popUpAlaplapExportalasPDFBttAction(ActionEvent event) {
        String fileNev=alaplapExportFileNeveInput.getText();
        fileNev = fileNev.replaceAll("\\s+","");
        
        if(fileNev != null && !fileNev.equals("") )
        {              
            PdfGeneration pdfCreator=new PdfGeneration();
            pdfCreator.pdfGenrationAlaplap(fileNev,dataAlaplap);
        }
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        alaplapPane.setOpacity(1);
        alaplapPane.setDisable(false); 
        popUpAlaplapExportPane.setVisible(false);
    }

    @FXML
    void popUpAlaplapHozzaadasBttAction(ActionEvent event) {
try
        {
        Alaplap newAlaplap= new Alaplap(
                alaplapHozzadasNameInput.getText(),
                alaplapHozzadasFormfactorInput.getText(),
                alaplapHozzadasSocketInput.getText(),
                alaplapHozzadasMemoryslotInput.getText(),               
                alaplapHozzadasAmountofmemInput.getText(),
                alaplapHozzadasPriceInput.getText());   
                  
        dataAlaplap.add(newAlaplap);
        al.addAlaplap(newAlaplap);
                  
        alaplapHozzadasNameInput.clear();
        alaplapHozzadasFormfactorInput.clear();
        alaplapHozzadasSocketInput.clear();
        alaplapHozzadasMemoryslotInput.clear();             
        alaplapHozzadasAmountofmemInput.clear();
        alaplapHozzadasPriceInput.clear();
        
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        alaplapPane.setOpacity(1);
        alaplapPane.setDisable(false); 
        popUpAlaplapHozzadasPane.setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void popUpAlaplapMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        alaplapPane.setOpacity(1);
        alaplapPane.setDisable(false); 
        popUpAlaplapHozzadasPane.setVisible(false);

    }

    @FXML
    void ujHozzadasAzAlaplaphozhoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true);        
        alaplapPane.setOpacity(0.3);
        alaplapPane.setDisable(true); 
        popUpAlaplapHozzadasPane.setVisible(true);
    }
    
    private final ObservableList<Alaplap> dataAlaplap=
            FXCollections.observableArrayList();
    
    public void setTableDataAlaplap(){
        TableColumn nevCol= new TableColumn("Alaplap:");
        nevCol.setMinWidth(100);
        nevCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nevCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("name"));
        
        nevCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        Alaplap actualAlaplap= (Alaplap) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualAlaplap.setName(t.getNewValue());
                        al.updateAlaplap(actualAlaplap);
                    }
                }
        );
        
        
         TableColumn formfactorCol= new TableColumn("Formátum:");
        formfactorCol.setMinWidth(100);
        formfactorCol.setCellFactory(TextFieldTableCell.forTableColumn());
        formfactorCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("formfactor"));
        
        formfactorCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                         Alaplap actualAlaplap= (Alaplap) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualAlaplap.setFormfactor(t.getNewValue());
                        al.updateAlaplap(actualAlaplap);
                    }
                }
        );
        
         TableColumn socketCol= new TableColumn("Foglalat:");
        socketCol.setMinWidth(100);
        socketCol.setCellFactory(TextFieldTableCell.forTableColumn());
        socketCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("socket"));
        
         socketCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                         Alaplap actualAlaplap= (Alaplap) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualAlaplap.setSocket(t.getNewValue());
                        al.updateAlaplap(actualAlaplap);
                    }
                }
        );
        
  
        
         TableColumn memoryslotCol= new TableColumn("Memória Fog:");
        memoryslotCol.setMinWidth(100);
        memoryslotCol.setCellFactory(TextFieldTableCell.forTableColumn());
        memoryslotCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("memoryslot"));
        
        memoryslotCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        Alaplap actualAlaplap= (Alaplap) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualAlaplap.setMemoryslot(t.getNewValue());
                        al.updateAlaplap(actualAlaplap);
                    }
                }
        );
        
       TableColumn amountofmemCol= new TableColumn("Memórahelyek Száma:");
        amountofmemCol.setMinWidth(100);
        amountofmemCol.setCellFactory(TextFieldTableCell.forTableColumn());
        amountofmemCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("amountofmem"));
        
        amountofmemCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        Alaplap actualAlaplap= (Alaplap) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualAlaplap.setAmountofmem(t.getNewValue());
                        al.updateAlaplap(actualAlaplap);
                    }
                }
        );
                    
        
         TableColumn arCol= new TableColumn("Ár");
        arCol.setMinWidth(100);
        arCol.setCellFactory(TextFieldTableCell.forTableColumn());
        arCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("price"));
        
        arCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        Alaplap actualAlaplap= (Alaplap) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualAlaplap.setPrice(t.getNewValue());
                        al.updateAlaplap(actualAlaplap);
                    }
                }
        );
        
        TableColumn removeCol= new TableColumn("Törlés");
        

        Callback<TableColumn<Alaplap, String>, TableCell<Alaplap, String>> cellFactory = 
                new Callback<TableColumn<Alaplap, String>, TableCell<Alaplap, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Alaplap, String> param )
                    {
                        final TableCell<Alaplap, String> cell = new TableCell<Alaplap, String>()
                        {   
                            final Button btn = new Button( "Törlés" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                                Alaplap alaplap = getTableView().getItems().get( getIndex() );
                                                dataAlaplap.remove(alaplap);
                                                al.removeAlaplap(alaplap);
                                            } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
        
        
        alaplapTable.getColumns().addAll(nevCol,formfactorCol,
                socketCol,memoryslotCol,amountofmemCol,arCol,removeCol);
        
        dataAlaplap.addAll(al.getAllAlaplap());
        
        alaplapTable.setItems(dataAlaplap);
    }
    /*#####################################################*/
                    /*Memória*/
     
    


    @FXML
    private Pane memoriaPane;

    @FXML
    private TableView memoriaTable;

    @FXML
    private Button HozzadasMemoriaBtt;

    @FXML
    private Button ExportálásMemoriaBtt;

    @FXML
    private Pane popUpMemoriaHozzadasPane;

    @FXML
    private TextField memoriaHozzadasNameInput;

    @FXML
    private TextField memoriaHozzadasSlotInput;

    @FXML
    private TextField memoriaHozzadasSizeInput;

    @FXML
    private TextField memoriaHozzadasFrequencyInput;

    @FXML
    private TextField memoriaHozzadasTimingInput;

    @FXML
    private TextField memoriaHozzadasAmountInput;

    @FXML
    private TextField memoriaHozzadasPriceInput;

    @FXML
    private Pane popUpMemoriaExportPane;

    @FXML
    private TextField memoriaExportFileNeveInput;

  

    @FXML
    void exportalasAMemoriahoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true);        
        memoriaPane.setOpacity(0.3);
        memoriaPane.setDisable(true); 
        popUpMemoriaExportPane.setVisible(true);
    }

 
    @FXML
    void popUpMemoriaExportalasMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        memoriaPane.setOpacity(1);
        memoriaPane.setDisable(false); 
        popUpMemoriaExportPane.setVisible(false);
    }

    @FXML
    void popUpMemoriaExportalasPDFBttAction(ActionEvent event) {
        String fileNev=memoriaExportFileNeveInput.getText();
        fileNev = fileNev.replaceAll("\\s+","");
        
        if(fileNev != null && !fileNev.equals("") )
        {              
            /*KiEG  */
        }
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        memoriaPane.setOpacity(1);
        memoriaPane.setDisable(false); 
        popUpMemoriaExportPane.setVisible(false);
    }

    @FXML
    void popUpMemoriaHozzaadasBttAction(ActionEvent event) {
         try
        {
        Memoria newMemoria= new Memoria(
                memoriaHozzadasNameInput.getText(),
                memoriaHozzadasSlotInput.getText(),
                memoriaHozzadasSizeInput.getText(),
                memoriaHozzadasFrequencyInput.getText(),
                memoriaHozzadasTimingInput.getText(),
                memoriaHozzadasAmountInput.getText(),
                memoriaHozzadasPriceInput.getText());  
                  
        dataMemoria.add(newMemoria);
        m.addMemoria(newMemoria);
                  
        memoriaHozzadasNameInput.clear();
        memoriaHozzadasSlotInput.clear();
        memoriaHozzadasSizeInput.clear();
        memoriaHozzadasFrequencyInput.clear();
        memoriaHozzadasTimingInput.clear();
        memoriaHozzadasAmountInput.clear();
        memoriaHozzadasPriceInput.clear(); 
        
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        memoriaPane.setOpacity(1);
        memoriaPane.setDisable(false); 
        popUpMemoriaHozzadasPane.setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void popUpMemoriaMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        memoriaPane.setOpacity(1);
        memoriaPane.setDisable(false); 
        popUpMemoriaExportPane.setVisible(false);
    }

   private final ObservableList<Memoria> dataMemoria=
            FXCollections.observableArrayList();

    @FXML
    void ujHozzadasAMemoriahozhozhoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true);        
        memoriaPane.setOpacity(0.3);
        memoriaPane.setDisable(true); 
        popUpMemoriaHozzadasPane.setVisible(true);
    }

    
    public void setTableDataMemoria(){
        TableColumn nevCol= new TableColumn("Memoria:");
        nevCol.setMinWidth(100);
        nevCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nevCol.setCellValueFactory(new PropertyValueFactory<Memoria,String>("name"));
        
        nevCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Memoria,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Memoria,String> t)
                    {
                        Memoria actualMemoria= (Memoria) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualMemoria.setName(t.getNewValue());
                        m.updateMemoria(actualMemoria);
                    }
                }
        );
        
        TableColumn slotCol= new TableColumn("Foglalat:");
        slotCol.setMinWidth(100);
        slotCol.setCellFactory(TextFieldTableCell.forTableColumn());
        slotCol.setCellValueFactory(new PropertyValueFactory<Memoria,String>("slot"));
        
        slotCol.setOnEditCommit(
        new EventHandler<TableColumn.CellEditEvent<Memoria,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Memoria,String> t)
                    {
                        Memoria actualMemoria= (Memoria) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualMemoria.setSlot(t.getNewValue());
                        m.updateMemoria(actualMemoria);
                    }
                }
        );
        
        TableColumn sizeCol= new TableColumn("Méret:");
        sizeCol.setMinWidth(100);
        sizeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        sizeCol.setCellValueFactory(new PropertyValueFactory<Memoria,String>("size"));
        
        sizeCol.setOnEditCommit(
        new EventHandler<TableColumn.CellEditEvent<Memoria,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Memoria,String> t)
                    {
                        Memoria actualMemoria= (Memoria) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualMemoria.setSize(t.getNewValue());
                        m.updateMemoria(actualMemoria);
                    }
                }
        );
        
        TableColumn frequencyCol= new TableColumn("Órajel:");
        frequencyCol.setMinWidth(100);
        frequencyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        frequencyCol.setCellValueFactory(new PropertyValueFactory<Memoria,String>("frequency"));
        
        frequencyCol.setOnEditCommit(
        new EventHandler<TableColumn.CellEditEvent<Memoria,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Memoria,String> t)
                    {
                        Memoria actualMemoria= (Memoria) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualMemoria.setFrequency(t.getNewValue());
                        m.updateMemoria(actualMemoria);
                    }
                }
        );
        
        TableColumn timingCol= new TableColumn("Időzítés:");
        timingCol.setMinWidth(100);
        timingCol.setCellFactory(TextFieldTableCell.forTableColumn());
        timingCol.setCellValueFactory(new PropertyValueFactory<Memoria,String>("timing"));
        
        timingCol.setOnEditCommit(
        new EventHandler<TableColumn.CellEditEvent<Memoria,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Memoria,String> t)
                    {
                        Memoria actualMemoria= (Memoria) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualMemoria.setTiming(t.getNewValue());
                        m.updateMemoria(actualMemoria);
                    }
                }
        );
        
        TableColumn amountCol= new TableColumn("KIT tartalma:");
        amountCol.setMinWidth(100);
        amountCol.setCellFactory(TextFieldTableCell.forTableColumn());
        amountCol.setCellValueFactory(new PropertyValueFactory<Memoria,String>("amount"));
        
        timingCol.setOnEditCommit(
        new EventHandler<TableColumn.CellEditEvent<Memoria,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Memoria,String> t)
                    {
                        Memoria actualMemoria= (Memoria) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualMemoria.setAmount(t.getNewValue());
                        m.updateMemoria(actualMemoria);
                    }
                }
        );
        
         TableColumn priceCol= new TableColumn("Ár");
        priceCol.setMinWidth(100);
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        priceCol.setCellValueFactory(new PropertyValueFactory<Memoria,String>("price"));
        
        priceCol.setOnEditCommit(
        new EventHandler<TableColumn.CellEditEvent<Memoria,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Memoria,String> t)
                    {
                        Memoria actualMemoria= (Memoria) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualMemoria.setPrice(t.getNewValue());
                        m.updateMemoria(actualMemoria);
                    }
                }
        );
        
               
        
        TableColumn removeCol= new TableColumn("Törlés");
        

        Callback<TableColumn<Memoria, String>, TableCell<Memoria, String>> cellFactory = 
                new Callback<TableColumn<Memoria, String>, TableCell<Memoria, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Memoria, String> param )
                    {
                        final TableCell<Memoria, String> cell = new TableCell<Memoria, String>()
                        {   
                            final Button btn = new Button( "Törlés" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                                Memoria memoria = getTableView().getItems().get( getIndex() );
                                                dataMemoria.remove(memoria);
                                                m.removeMemoria(memoria);
                                            } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
        
        
        memoriaTable.getColumns().addAll(nevCol,slotCol,
                sizeCol,frequencyCol,timingCol,amountCol,priceCol,removeCol);
        
        dataMemoria.addAll(m.getAllMemoria());
        
        memoriaTable.setItems(dataMemoria);
    } 
    
    /*#######################################################*/
                    /*Processzor*/
   
    @FXML
    private Pane processzorPane;

    @FXML
    private TableView processzorTable;

    @FXML
    private Pane popUpProcesszorHozzadasPane;

    @FXML
    private TextField processzorHozzadasNameInput;

    @FXML
    private TextField processzorHozzadasSocketInput;

    @FXML
    private TextField processzorHozzadasCoresInput;

    @FXML
    private TextField processzorHozzadasThreadsInput;

    @FXML
    private TextField processzorHozzadasFrequencyInput;

    @FXML
    private TextField processzorHozzadasMaxfrequencyInput;

    @FXML
    private TextField processzorHozzadasPriceInput;

    @FXML
    private Pane popUpProcesszorExportPane;

    @FXML
    private TextField processzorExportFileNeveInput;

  

    @FXML
    void exportalasAProcesszorhoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true);        
        processzorPane.setOpacity(0.3);
        processzorPane.setDisable(true); 
        popUpProcesszorExportPane.setVisible(true);
    }

 
 
    @FXML
    void popUpProcesszorExportalasMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        processzorPane.setOpacity(1);
        processzorPane.setDisable(false); 
        popUpProcesszorExportPane.setVisible(false);
    }

    @FXML
    void popUpProcesszorExportalasPDFBttAction(ActionEvent event) {
        String fileNev=processzorExportFileNeveInput.getText();
        fileNev = fileNev.replaceAll("\\s+","");
        
        if(fileNev != null && !fileNev.equals("") )
        {              
            //ide kéne valami nagyon!!!!!444!!!!444!4!!!!!!444!
        }
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        processzorPane.setOpacity(1);
        processzorPane.setDisable(false); 
        popUpProcesszorExportPane.setVisible(false);
    }

    @FXML
    void popUpProcesszorHozzaadasBttAction(ActionEvent event) {
        try
        {
        Processzor newProcesszor= new Processzor(
                processzorHozzadasNameInput.getText(),
                processzorHozzadasSocketInput.getText(),
                processzorHozzadasCoresInput.getText(),
                processzorHozzadasThreadsInput.getText(),               
                processzorHozzadasFrequencyInput.getText(),
		processzorHozzadasMaxfrequencyInput.getText(),
                processzorHozzadasPriceInput.getText());   
                  
        dataProcesszor.add(newProcesszor);
        pr.addProcesszor(newProcesszor);
                  
        processzorHozzadasNameInput.clear();
        processzorHozzadasSocketInput.clear();
        processzorHozzadasCoresInput.clear();
        processzorHozzadasThreadsInput.clear();             
        processzorHozzadasFrequencyInput.clear();
	processzorHozzadasMaxfrequencyInput.clear();
        processzorHozzadasPriceInput.clear();
        
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        processzorPane.setOpacity(1);
        processzorPane.setDisable(false); 
        popUpProcesszorHozzadasPane.setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void popUpProcesszorMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        processzorPane.setOpacity(1);
        processzorPane.setDisable(false); 
        popUpProcesszorHozzadasPane.setVisible(false);
    }

     private final ObservableList<Processzor> dataProcesszor=
            FXCollections.observableArrayList();
    
    @FXML
    void ujHozzadasAProcesszorhoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true);        
        processzorPane.setOpacity(0.3);
        processzorPane.setDisable(true); 
        popUpProcesszorHozzadasPane.setVisible(true);
    }

public void setTableDataProcesszor(){
        TableColumn nevCol= new TableColumn("Processzor:");
        nevCol.setMinWidth(100);
        nevCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nevCol.setCellValueFactory(new PropertyValueFactory<Processzor,String>("name"));
        
        nevCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Processzor,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Processzor,String> t)
                    {
                        Processzor actualProcesszor= (Processzor) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualProcesszor.setName(t.getNewValue());
                        pr.updateProcesszor(actualProcesszor);
                    }
                }
        );
        
        
         TableColumn socketCol= new TableColumn("Foglalat:");
        socketCol.setMinWidth(100);
        socketCol.setCellFactory(TextFieldTableCell.forTableColumn());
        socketCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("socket"));
        
        socketCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Processzor,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Processzor,String> t)
                    {
                         Processzor actualProcesszor= (Processzor) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualProcesszor.setSocket(t.getNewValue());
                        pr.updateProcesszor(actualProcesszor);
                    }
                }
        );
        
         TableColumn coresCol= new TableColumn("Magok száma:");
        coresCol.setMinWidth(100);
        coresCol.setCellFactory(TextFieldTableCell.forTableColumn());
        coresCol.setCellValueFactory(new PropertyValueFactory<Processzor,String>("cores"));
        
         coresCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Processzor,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Processzor,String> t)
                    {
                         Processzor actualProcesszor= (Processzor) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualProcesszor.setCores(t.getNewValue());
                        pr.updateProcesszor(actualProcesszor);
                    }
                }
        );
        
  
        
         TableColumn threadsCol= new TableColumn("Szálak száma:");
        threadsCol.setMinWidth(100);
        threadsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        threadsCol.setCellValueFactory(new PropertyValueFactory<Processzor,String>("threads"));
        
        threadsCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Processzor,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Processzor,String> t)
                    {
                        Processzor actualProcesszor= (Processzor) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualProcesszor.setThreads(t.getNewValue());
                        pr.updateProcesszor(actualProcesszor);
                    }
                }
        );
        
        TableColumn frequencyCol= new TableColumn("Órajel:");
        frequencyCol.setMinWidth(100);
        frequencyCol.setCellFactory(TextFieldTableCell.forTableColumn());
       	frequencyCol.setCellValueFactory(new PropertyValueFactory<Processzor,String>("frequency"));
        
        frequencyCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Processzor,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Processzor,String> t)
                    {
                         Processzor actualProcesszor= (Processzor) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualProcesszor.setFrequency(t.getNewValue());
                        pr.updateProcesszor(actualProcesszor);
                    }
                }
        );
 	TableColumn maxfrequencyCol= new TableColumn("Turbo Órajel:");
        maxfrequencyCol.setMinWidth(100);
        maxfrequencyCol.setCellFactory(TextFieldTableCell.forTableColumn());
       	maxfrequencyCol.setCellValueFactory(new PropertyValueFactory<Processzor,String>("maxfrequency"));
        
        maxfrequencyCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Processzor,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Processzor,String> t)
                    {
                         Processzor actualProcesszor= (Processzor) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualProcesszor.setMaxfrequency(t.getNewValue());
                        pr.updateProcesszor(actualProcesszor);
                    }
                }
        );
                    
        
        TableColumn arCol= new TableColumn("Ár");
        arCol.setMinWidth(100);
        arCol.setCellFactory(TextFieldTableCell.forTableColumn());
        arCol.setCellValueFactory(new PropertyValueFactory<Processzor,String>("price"));
        
        arCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Processzor,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Processzor,String> t)
                    {
                        Processzor actualProcesszor= (Processzor) t.getTableView().getItems().get(t.getTablePosition().getRow());
                        actualProcesszor.setPrice(t.getNewValue());
                        pr.updateProcesszor(actualProcesszor);
                    }
                }
        );
        
        TableColumn removeCol= new TableColumn("Törlés");
        

        Callback<TableColumn<Processzor, String>, TableCell<Processzor, String>> cellFactory = 
                new Callback<TableColumn<Processzor, String>, TableCell<Processzor, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Processzor, String> param )
                    {
                        final TableCell<Processzor, String> cell = new TableCell<Processzor, String>()
                        {   
                            final Button btn = new Button( "Törlés" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                                Processzor processzor = getTableView().getItems().get( getIndex() );
                                                dataProcesszor.remove(processzor);
                                                pr.removeProcesszor(processzor);
                                            } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
        
        
        processzorTable.getColumns().addAll(nevCol,socketCol,
                coresCol,threadsCol,frequencyCol,maxfrequencyCol,arCol,removeCol);
        
        dataProcesszor.addAll(pr.getAllProcesszor());
        
        processzorTable.setItems(dataProcesszor);
}
   
    
    /*#######################################################*/
             /*Videokartya*/

    @FXML
    private Pane videokartyaPane;

    @FXML
    private TableView videokartyaTable;

    @FXML
    private Pane popUpVideokartyaHozzadasPane;

    @FXML
    private TextField videokartyaHozzadasManifactureInput;

    @FXML
    private TextField videokartyaHozzadasNameInput;

    @FXML
    private TextField videokartyaHozzadasSlotInput;

    @FXML
    private TextField videokartyaHozzadasVramInput;

    @FXML
    private TextField videokartyaHozzadasFrequencyInput;

    @FXML
    private TextField videokartyaHozzadasLengthInput;

    @FXML
    private TextField videokartyaHozzadasPriceInput;

    @FXML
    private Pane popUpVideokartyaExportPane;



    @FXML
    void exportalasAVideokartyahoz(ActionEvent event) {

    }

    @FXML
    void popUpVideokartyaExportalasMegseBttAction(ActionEvent event) {

    }

    @FXML
    void popUpVideokartyaExportalasPDFBttAction(ActionEvent event) {

    }

    @FXML
    void popUpVideokartyaHozzaadasBttAction(ActionEvent event) {

    }

    @FXML
    void popUpVideokartyaMegseBttAction(ActionEvent event) {

    }

    @FXML
    void ujHozzadasAVideokartyahoz(ActionEvent event) {

    }

    private final ObservableList<Videokartya> dataVideokartya=
            FXCollections.observableArrayList();
    /*#######################################################*/

    public void setMenuData(){
        TreeItem<String> treeItemroot1= new TreeItem<>("Menü:");
        TreeView<String> treeView = new TreeView<>(treeItemroot1);
        treeView.setShowRoot(false);
        
        TreeItem<String> nodeItemA= new TreeItem<>(MENU_PC_RESZEK);
        TreeItem<String> nodeItemB= new TreeItem<>(MENU_EXIT);
        
        nodeItemA.setExpanded(true);
        
        TreeItem<String> nodeItemA1= new TreeItem<>(MENU_GEPHAZAK/*,gephaznodes*/);
        TreeItem<String> nodeItemA2= new TreeItem<>(MENU_ALAPLAP/*,exportnodes*/);
        TreeItem<String> nodeItemA3= new TreeItem<>(MENU_MEMORIA/*,exportnodes*/);
        TreeItem<String> nodeItemA4= new TreeItem<>(MENU_PROCESSZOR/*,exportnodes*/);
        TreeItem<String> nodeItemA5= new TreeItem<>(MENU_VIDEOKARTYA/*,exportnodes*/);
       
        nodeItemA.getChildren().addAll(nodeItemA1,nodeItemA2,nodeItemA3,nodeItemA4,nodeItemA5);
        treeItemroot1.getChildren().addAll( nodeItemA, nodeItemB);
        
        menuPane.getChildren().add(treeView);
        
        
            treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() 
            {
                public void changed(ObservableValue observable,Object oldValue, Object newValue)
                {
                    TreeItem<String> selectedItem=(TreeItem<String>)newValue;
                    
                    String selectedMenu;
                    selectedMenu=selectedItem.getValue();
                    if(null != selectedMenu)
                    {
                        switch(selectedMenu)
                        {
                            case MENU_PC_RESZEK:
                                try
                                {   
                                  selectedItem.setExpanded(true);
                                }
                                catch(Exception e){}
                                break;
                                
                            case MENU_GEPHAZAK:
                                try
                                {   
                                  hazPane.setVisible(true);
                                  starterPane.setVisible(false);
                                  alaplapPane.setVisible(false);
                                  memoriaPane.setVisible(false);
                                  processzorPane.setVisible(false);
                                  videokartyaPane.setVisible(false);
                                }
                                catch(Exception e){}
                                break;
                             
                            case MENU_ALAPLAP:
                                try
                                {   
                                  hazPane.setVisible(false);
                                  starterPane.setVisible(false);
                                  alaplapPane.setVisible(true);
                                  memoriaPane.setVisible(false);
                                  processzorPane.setVisible(false);
                                  videokartyaPane.setVisible(false);
                                }
                                catch(Exception e){}
                                break;  
                                
                            case MENU_MEMORIA:
                                try
                                {   
                                  hazPane.setVisible(false);
                                  starterPane.setVisible(false);
                                  alaplapPane.setVisible(false);
                                  memoriaPane.setVisible(true);
                                  processzorPane.setVisible(false);
                                  videokartyaPane.setVisible(false);
                                }
                                catch(Exception e){}
                                break;
                              
                            case MENU_PROCESSZOR:
                                try
                                {   
                                  hazPane.setVisible(false);
                                  starterPane.setVisible(false);
                                  alaplapPane.setVisible(false);
                                  memoriaPane.setVisible(false);
                                  processzorPane.setVisible(true);
                                  videokartyaPane.setVisible(false);
                                  
                                }
                                catch(Exception e){}
                                break; 
                                
                             case MENU_VIDEOKARTYA:
                                try
                                {   
                                  hazPane.setVisible(false);
                                  starterPane.setVisible(false);
                                  alaplapPane.setVisible(false);
                                  memoriaPane.setVisible(false);
                                  processzorPane.setVisible(false);
                                  videokartyaPane.setVisible(true);
                                }
                                catch(Exception e){}
                                break;                
           
                            case MENU_EXIT:
                                System.exit(0);
                                break;
                        }
                    }
                }
            });
            

    }
    
     public void setStarterPic(){
        Image image = new Image("https://e7.pngegg.com/pngimages/534/1005/png-clipart-computer-monitors-Gephazal-computer-output-device-desktop-computers-multimedia-computer-desktop-pc-computer-computer-monitor-accessory.png"); 
        ImageView imageview = new ImageView(image);
        starterPane.getChildren().add(imageview);
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
       
        
        setTableDataAlaplap();
        setTableDataGephaz();
        setTableDataMemoria();
        setTableDataProcesszor();
        setMenuData();
        setStarterPic();
      
    }    

    
} 
