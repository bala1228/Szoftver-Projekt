package hu.unideb.inf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Raktár");
        stage.setWidth(750);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String jdbcUrl = "jdbc:sqlite:smfdb.db";
         try 
        {
            Connection connection = DriverManager.getConnection(jdbcUrl);
            String sql = "SELECT * FROM gephaz";
            
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next())
            {
                int ID = result.getInt("id");
                String name = result.getString("name");
                String formfactor = result.getString("formfactor");
                int vents = result.getInt("vents");
                int storage = result.getInt("storage");
                int GPULength = result.getInt("GPULength");
                int price = result.getInt("price");
                
                System.out.println(ID + " | " + name + " | " + formfactor + " | " + vents +" db" + " | " + storage + " db" + " | " + GPULength + " cm" + " | " + price + " Ft");
            }
            
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error connection to SQL database");
        }
         
         launch(args);
    }

}
