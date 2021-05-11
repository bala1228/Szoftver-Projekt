package hu.unideb.inf;

import hu.unideb.inf.components.Alaplap;
import hu.unideb.inf.components.Gephaz;
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



  


public class FXMLController implements Initializable {
    
   private final String MENU_EXIT="Kilépés";
   private final String MENU_GEPHAZAK="Gépházak"; 
   private final String MENU_PC_RESZEK="PC részek"; 
   private final String MENU_ALAPLAP="Alaplapok";
   private final String MENU_MEREVLEMEZ="Merevlemezek";
   
   @FXML
    private AnchorPane BASE;
   
    @FXML
    private StackPane menuPane;

    @FXML
    private Pane starterPane;
    
    @FXML
    private Pane AlaplapPane;

    @FXML
    private Pane hazPane;

    @FXML
    private TableView hazTable;
    
    @FXML
    private TableView alaplapTable;
    
    @FXML
    private Pane popUpGephazHozzadasPane;
       
    @FXML
    private TextField gephazHozzadasNevInput;

    @FXML
    private TextField gephazHozzadasAlaplaptipusInput;

    @FXML
    private TextField gephazHozzadasVentillatorokszamaInput;

    @FXML
    private TextField gephazHozzadasSsdhelyInput;

    @FXML
    private TextField gephazHozzadasArInput; 
    
    @FXML
    private TextField gephazExportFileNeveInput;
    
    @FXML
    private Pane popUpGephazExportPane;
    
    @FXML
    private Pane popUpAlaplapHozzadasPane;

    @FXML
    private TextField AlaplapHozzadasNevInput;

    @FXML
    private TextField AlaplapHozzadasFormatumInput;

    @FXML
    private TextField AlaplapHozzadasProcesszorFogInput;

    @FXML
    private TextField AlaplapHozzadasmemoriaFogInput;

    @FXML
    private TextField AlaplapHozzadasArInput;
    
    @FXML
    private Pane popUpAlaplapExportPane;

    @FXML
    private TextField alaplapExportFileNeveInput;

     @FXML
     //Alaplap almenü -> Exportalás gomb Action    
    void exportalasAzAlaplaphoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true); 
        
        AlaplapPane.setOpacity(0.3);
        AlaplapPane.setDisable(true); 
        popUpAlaplapExportPane.setVisible(true);
    }

    @FXML
    //Alaplap almenü -> Exportalás gomb -> popUp -> Mégse gomb Action        
    void popUpAlaplapExportalasMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        AlaplapPane.setOpacity(1);
        AlaplapPane.setDisable(false); 
        popUpAlaplapExportPane.setVisible(false);
    }

    @FXML
    void popUpAlaplapExportalasPDFBttAction(ActionEvent event) {
        String fileNev=alaplapExportFileNeveInput.getText();
        fileNev = fileNev.replaceAll("\\s+","");
        
        if(fileNev != null && !fileNev.equals("") )
        {              
            AlplapPdfGeneration pdfCreator=new AlplapPdfGeneration();
           pdfCreator.AlaplappdfGenration(fileNev,dataAlaplap);
        }
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        AlaplapPane.setOpacity(1);
        AlaplapPane.setDisable(false); 
        popUpAlaplapExportPane.setVisible(false);
    }

    @FXML
    // Alaplap almenü -> Új Hozzáadás gomb -> Hozzáadás gomb Action        
    void popUpAlaplapHozzaadasBttAction(ActionEvent event) {
        try
        {
        dataAlaplap.add(new Alaplap(
                AlaplapHozzadasNevInput.getText(),
                AlaplapHozzadasFormatumInput.getText(),
                AlaplapHozzadasProcesszorFogInput.getText(),
                AlaplapHozzadasmemoriaFogInput.getText(),               
                AlaplapHozzadasArInput.getText()));
        
        AlaplapHozzadasNevInput.clear();
        AlaplapHozzadasFormatumInput.clear();
        AlaplapHozzadasProcesszorFogInput.clear();
        AlaplapHozzadasmemoriaFogInput.clear();             
        AlaplapHozzadasArInput.clear();
        
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        AlaplapPane.setOpacity(1);
        AlaplapPane.setDisable(false); 
        popUpAlaplapHozzadasPane.setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    // Alaplap almenü -> Új Hozzáadás gomb -> Mégse gomb Action
    void popUpAlaplapMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        AlaplapPane.setOpacity(1);
        AlaplapPane.setDisable(false); 
        popUpAlaplapHozzadasPane.setVisible(false);
    }
    
    @FXML
    // Alaplap almenü -> Új Hozzáadás gomb Action
    void ujHozzadasAzAlaplaphoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true); 
        
        AlaplapPane.setOpacity(0.3);
        AlaplapPane.setDisable(true); 
        popUpAlaplapHozzadasPane.setVisible(true);
    }

    
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
            pdfCreator.pdfGenration(fileNev,dataGephaz);
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
        dataGephaz.add(new Gephaz(
                gephazHozzadasNevInput.getText(),
                gephazHozzadasAlaplaptipusInput.getText(),
                gephazHozzadasVentillatorokszamaInput.getText(),
                gephazHozzadasSsdhelyInput.getText(),               
                gephazHozzadasArInput.getText()));
        
        gephazHozzadasNevInput.clear();
        gephazHozzadasAlaplaptipusInput.clear();
        gephazHozzadasVentillatorokszamaInput.clear();
        gephazHozzadasSsdhelyInput.clear();             
        gephazHozzadasArInput.clear();
        
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
    
    
    private final ObservableList<Alaplap> dataAlaplap=
            FXCollections.observableArrayList(
            new Alaplap("MSI B450 TOMAHAWK MAX","ATX","Socket AM4","DDR4 - 4db","32 690Ft"),
            new Alaplap("ASUS ROG STRIX B450-F GAMING","ATX","Socket AM4","DDR4 - 4db","39 900Ft"),
            new Alaplap("ASRock H110 Pro BTC+","ATX","Socket 1151","DDR4 - 2db","15 990Ft"),
            new Alaplap("MSI Z490-A PRO","ATX","Socket 1200","DDR4 - 4db","57 380Ft"),
            new Alaplap("ASUS PRIME H310M-E R2.0/CSM","microATX","Socket 1151","DDR4 - 2db","18 746Ft"));
    
    private final ObservableList<Gephaz> dataGephaz=
            FXCollections.observableArrayList(
            new Gephaz("Aerocool PGS ORE SATURN","ATX","3","4","12 345Ft"),
            new Gephaz("be quiet! Pure Base 500DX","ATX","2","5","36 430Ft"),
            new Gephaz("NZXT H510","ATX","2","3","24 890Ft"),
            new Gephaz("CHIEFTEC CI-02B-OP","Micro ATX","3","3","13 317Ft"),
            new Gephaz("Corsair 275R Airflow TG","Mini ATX","4","5","27 790Ft"),
            new Gephaz("SilentiumPC Signum","ATX","3","5","17 499Ft"));
    
    
    public void setStarterPic(){
        Image image = new Image("https://e7.pngegg.com/pngimages/534/1005/png-clipart-computer-monitors-personal-computer-output-device-desktop-computers-multimedia-computer-desktop-pc-computer-computer-monitor-accessory.png"); 
        ImageView imageview = new ImageView(image);
        starterPane.getChildren().add(imageview);
        
    }
    
    public void setTableDataGephaz(){
        TableColumn nevCol= new TableColumn("Gépház:");
        nevCol.setMinWidth(100);
        nevCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nevCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("nev"));
        
        nevCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        ((Gephaz) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setNev(t.getNewValue());
                    }
                }
        );
        
        
         TableColumn alaplaptipusCol= new TableColumn("Alaplaptípusa:");
        alaplaptipusCol.setMinWidth(100);
        alaplaptipusCol.setCellFactory(TextFieldTableCell.forTableColumn());
        alaplaptipusCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("alaplaptipus"));
        
        alaplaptipusCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        ((Gephaz) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAlaplaptipus(t.getNewValue());
                    }
                }
        );
        
         TableColumn beepitetVentilatorokSzamaCol= new TableColumn("Beépített ventilatorok száma:");
        beepitetVentilatorokSzamaCol.setMinWidth(100);
        beepitetVentilatorokSzamaCol.setCellFactory(TextFieldTableCell.forTableColumn());
        beepitetVentilatorokSzamaCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("beepitetVentilatorokSzama"));
        
         beepitetVentilatorokSzamaCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        ((Gephaz) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setBeepitetVentilatorokSzama(t.getNewValue());
                    }
                }
        );
        
  //       TableColumn szinCol= new TableColumn("Szín:");
  //      szinCol.setMinWidth(100);
  //      szinCol.setCellFactory(TextFieldTableCell.forTableColumn());
  //      szinCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("szin"));
        
         TableColumn ssdhelyCol= new TableColumn("Ssd helyek száma:");
        ssdhelyCol.setMinWidth(100);
        ssdhelyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ssdhelyCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("ssdhely"));
        
        ssdhelyCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        ((Gephaz) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setSsdhely(t.getNewValue());
                    }
                }
        );
        
         TableColumn arCol= new TableColumn("Ár");
        arCol.setMinWidth(100);
        arCol.setCellFactory(TextFieldTableCell.forTableColumn());
        arCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("ar"));
        
        arCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Gephaz,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Gephaz,String> t)
                    {
                        ((Gephaz) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAr(t.getNewValue());
                    }
                }
        );
        
        hazTable.getColumns().addAll(nevCol,alaplaptipusCol,
                beepitetVentilatorokSzamaCol,/*szinCol,*/ssdhelyCol,arCol);
        
        hazTable.setItems(dataGephaz);
    } 
    
    public void setTableDataAlaplap(){
        try{
        TableColumn nevCol= new TableColumn("Alaplap:");
        nevCol.setMinWidth(100);
        nevCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nevCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("nev"));
        
        nevCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        ((Alaplap) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setNev(t.getNewValue());
                    }
                }
        );
        
        
         TableColumn formatumCol= new TableColumn("Formatum:");
        formatumCol.setMinWidth(100);
        formatumCol.setCellFactory(TextFieldTableCell.forTableColumn());
        formatumCol.setCellValueFactory(new PropertyValueFactory<Alaplap,String>("formatum"));
        
        formatumCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        ((Alaplap) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setFormatum(t.getNewValue());
                    }
                }
        );
        
         TableColumn procFogCol= new TableColumn("Processzor :");
        procFogCol.setMinWidth(100);
        procFogCol.setCellFactory(TextFieldTableCell.forTableColumn());
        procFogCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("proceszorFog"));
        
         procFogCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        ((Alaplap) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setProceszorFog(t.getNewValue());
                    }
                }
        );
        
         TableColumn memoriaFogCol= new TableColumn("Memoria:");
        memoriaFogCol.setMinWidth(100);
        memoriaFogCol.setCellFactory(TextFieldTableCell.forTableColumn());
        memoriaFogCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("memoriaFog"));
        
        memoriaFogCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        ((Alaplap) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setMemoriaFog(t.getNewValue());
                    }
                }
        );
        
         TableColumn arCol= new TableColumn("Ár");
        arCol.setMinWidth(100);
        arCol.setCellFactory(TextFieldTableCell.forTableColumn());
        arCol.setCellValueFactory(new PropertyValueFactory<Gephaz,String>("ar"));
        
        arCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Alaplap,String>> ()
                {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Alaplap,String> t)
                    {
                        ((Alaplap) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAr(t.getNewValue());
                    }
                }
        );
        
        alaplapTable.getColumns().addAll(nevCol,formatumCol,
                procFogCol,memoriaFogCol,arCol);
        
        alaplapTable.setItems(dataAlaplap);
        }
        catch(Exception e){
            System.out.println(".setTableDataAlaplap()");
            e.printStackTrace();
        }
    }
    
    public void setMenuData(){
        TreeItem<String> treeItemroot1= new TreeItem<>("Menü:");
        TreeView<String> treeView = new TreeView<>(treeItemroot1);
        treeView.setShowRoot(false);
        
        TreeItem<String> nodeItemA= new TreeItem<>(MENU_PC_RESZEK);
        TreeItem<String> nodeItemB= new TreeItem<>(MENU_EXIT);
        
        nodeItemA.setExpanded(true);
        
        TreeItem<String> nodeItemA1= new TreeItem<>(MENU_GEPHAZAK/*,gephaznodes*/);
        TreeItem<String> nodeItemA2= new TreeItem<>(MENU_ALAPLAP/*,exportnodes*/);
        TreeItem<String> nodeItemA3= new TreeItem<>(MENU_MEREVLEMEZ/*,exportnodes*/);
       
        nodeItemA.getChildren().addAll(nodeItemA1,nodeItemA2,nodeItemA3);
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
                                  AlaplapPane.setVisible(false);
                                  starterPane.setVisible(false);
                                }
                                catch(Exception e){}
                                break;
                             
                            case MENU_ALAPLAP:
                                try
                                {   
                                  AlaplapPane.setVisible(true);
                                  hazPane.setVisible(false);
                                  starterPane.setVisible(false);
                                }
                                catch(Exception e){}
                                break;
                                
                            case MENU_MEREVLEMEZ:
                                try{
                                    
                                }
                                catch(Exception e){
                                    
                                }
                                break;
                            case MENU_EXIT:
                                System.exit(0);
                                break;
                        }
                    }
                }
            });
            

    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTableDataGephaz();
        setTableDataAlaplap();
        setMenuData();
        setStarterPic();
        
    }    

    
} 
