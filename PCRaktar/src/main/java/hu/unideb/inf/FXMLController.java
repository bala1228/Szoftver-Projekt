package hu.unideb.inf;

import Database.Db_gephaz;
import Components.Alaplap;
import Components.Gephaz;
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
    
    
    public void setStarterPic(){
        Image image = new Image("https://e7.pngegg.com/pngimages/534/1005/png-clipart-computer-monitors-Gephazal-computer-output-device-desktop-computers-multimedia-computer-desktop-pc-computer-computer-monitor-accessory.png"); 
        ImageView imageview = new ImageView(image);
        starterPane.getChildren().add(imageview);
        
    }
    
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
    

    private final ObservableList<Gephaz> dataGephaz=
            FXCollections.observableArrayList();
    
    /*######################################################################*/
   
    /*Alaplap*/
    
    @FXML
    private Pane alaplapPane;

    @FXML
    private TableView alaplapTable;

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

    }

    @FXML
    void popUpAlaplapExportalasMegseBttAction(ActionEvent event) {

    }

    @FXML
    void popUpAlaplapExportalasPDFBttAction(ActionEvent event) {

    }

    @FXML
    void popUpAlaplapHozzaadasBttAction(ActionEvent event) {

    }

    @FXML
    void popUpAlaplapMegseBttAction(ActionEvent event) {

    }

    @FXML
    void ujHozzadasAzAlaplaphoz(ActionEvent event) {

    }
    /*#####################################################*/
    
    /*Memória*/
    @FXML
    private Pane memoriaPane;

    @FXML
    private TableView<?> memoriaTable;

    @FXML
    private Pane popUpMemoriaHozzadasPane;

    @FXML
    private Pane popUpMemoriaExportPane;

    @FXML
    private TextField memoriaExportFileNeveInput;

    @FXML
    void exportalasAMemoriahoz(ActionEvent event) {

    }

    @FXML
    void popUpMemoriaExportalasMegseBttAction(ActionEvent event) {

    }

    @FXML
    void popUpMemoriaExportalasPDFBttAction(ActionEvent event) {

    }

    @FXML
    void popUpMemoriaHozzaadasBttAction(ActionEvent event) {

    }

    @FXML
    void popUpMemoriaMegseBttAction(ActionEvent event) {

    }
    
    
    
    

    @FXML
    void ujHozzadasAMemoriahoz(ActionEvent event) {

    }
    /*#####################################################*/

    
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
                                  starterPane.setVisible(false);
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
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        setTableDataGephaz();
        setMenuData();
        setStarterPic();
        
        
        
        
    }    

    
} 
