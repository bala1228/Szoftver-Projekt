package hu.unideb.inf;

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
import javafx.scene.Node;
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
   private final String MENU_EXPORT="Exportálás";
   
   @FXML
    private AnchorPane BASE;
   
    @FXML
    private StackPane menuPane;

    @FXML
    private Pane starterPane;
    
    @FXML
    private Pane exportPane;

    @FXML
    private Pane hazPane;

    @FXML
    private TableView hazTable;
    
    @FXML
    private Pane popUpGephazPane;
       
    @FXML
    private TextField gephazNevInput;

    @FXML
    private TextField gephazalAlaplaptipusInput;

    @FXML
    private TextField gephazVentillatorokszamaInput;

    @FXML
    private TextField gephazSsdhelyInput;

    @FXML
    private TextField gephazArInput;   

    @FXML
    void popUpGephazHozzaadasBttAction(ActionEvent event) {
        data.add(new Gephaz(
                gephazNevInput.getText(),
                gephazalAlaplaptipusInput.getText(),
                gephazVentillatorokszamaInput.getText(),
                gephazSsdhelyInput.getText(),               
                gephazArInput.getText()));
        
        gephazNevInput.clear();
        gephazalAlaplaptipusInput.clear();
        gephazVentillatorokszamaInput.clear();
        gephazSsdhelyInput.clear();             
        gephazArInput.clear();
        
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        hazPane.setOpacity(1);
        hazPane.setDisable(false); 
        popUpGephazPane.setVisible(false);
    }

    @FXML
    void popUpGephazMegseBttAction(ActionEvent event) {
        menuPane.setOpacity(1);
        menuPane.setDisable(false);
        hazPane.setOpacity(1);
        hazPane.setDisable(false); 
        popUpGephazPane.setVisible(false);
    }

    @FXML
    void ujHozzadasAGephazhoz(ActionEvent event) {
        menuPane.setOpacity(0.3);
        menuPane.setDisable(true); 
        
        hazPane.setOpacity(0.3);
        hazPane.setDisable(true); 
        popUpGephazPane.setVisible(true);
    }
    
    
    
    
    private final ObservableList<Gephaz> data=
            FXCollections.observableArrayList(
            new Gephaz("1 gép neve","1 gép alaplaptipusa","3","sssd ehlx 3","20"),
            new Gephaz("2 gép neve","2 gép alaplaptipusa","3","sssd ehlx 3","20"),
            new Gephaz("3 gép neve","3 gép alaplaptipusa","3","sssd ehlx 3","20"));
    
    public void setStarterPic(){
        Image image = new Image("https://e7.pngegg.com/pngimages/534/1005/png-clipart-computer-monitors-personal-computer-output-device-desktop-computers-multimedia-computer-desktop-pc-computer-computer-monitor-accessory.png"); 
        ImageView imageview = new ImageView(image);
        starterPane.getChildren().add(imageview);
        
    }
    
    public void setTableData(){
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
        
        hazTable.setItems(data);
    } 
    
    public void setMenuData(){
        TreeItem<String> treeItemroot1= new TreeItem<>("Menü:");
        TreeView<String> treeView = new TreeView<>(treeItemroot1);
        treeView.setShowRoot(false);
        
        TreeItem<String> nodeItemA= new TreeItem<>(MENU_PC_RESZEK);
        TreeItem<String> nodeItemB= new TreeItem<>(MENU_EXIT);
        
        nodeItemA.setExpanded(true);
        
     //   Node gephaznodes = new ImageView( new Image(getClass().getResourceAsStream("/raketa.png")));
     //   Node exportnodes = new ImageView( new Image(getClass().getResourceAsStream("/kerdojel.png")));
        TreeItem<String> nodeItemA1= new TreeItem<>(MENU_GEPHAZAK/*,gephaznodes*/);
        TreeItem<String> nodeItemA2= new TreeItem<>(MENU_EXPORT/*,exportnodes*/);
       
        nodeItemA.getChildren().addAll(nodeItemA1,nodeItemA2);
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
                                  exportPane.setVisible(false);
                                  starterPane.setVisible(false);
                                }
                                catch(Exception e){}
                                break;
                             
                            case MENU_EXPORT:
                                try
                                {   
                                  exportPane.setVisible(true);
                                  hazPane.setVisible(false);
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
        setTableData();
        setMenuData();
        setStarterPic();
    }    

    
} 
