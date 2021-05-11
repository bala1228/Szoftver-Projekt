
    
package hu.unideb.inf;

import hu.unideb.inf.components.Gephaz;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db_gephaz
{
    final String sqlcreat="create table gephaz (id int(2), name varchar(50), formfactor varchar(10), vents int(3), storage int(3), GPULength int(5), price int(7))";
    final String jdbcUrl = "jdbc:sqlite:smfdb.db";
    
    Connection conn=null;
    Statement creatStatement = null;
    DatabaseMetaData dbmd = null;
    
    public Db_gephaz()
    {
        try 
        {
            conn = DriverManager.getConnection(jdbcUrl);
            System.out.println("A híd létrejött!");
        } catch (SQLException ex){
            System.out.println("Valami bajvan a (híd) létrehozásában");
             System.out.println(""+ex);
        }            
         
        if (conn !=null)
        {
            try
            {
              creatStatement= conn.createStatement();
            } 
            catch (SQLException ex)
            {
             System.out.println("Valami bajvan a creatStatementnél ");
             System.out.println(""+ex);
            }            
            
        }
        try
        {
             ResultSet rs = dbmd.getTables(null,null,"gephaz", null);
            if (!rs.next())
            {
                creatStatement.execute(sqlcreat);
            }         
        } 
        catch (SQLException ex)
        {
             System.out.println("Valami bajvan az adattáblák létrehozásában");
             System.out.println(""+ex);
        }           
    }

    public ArrayList<Gephaz> getAllgephaz(){
            String sql = "select * from gephaz";
            ArrayList<Gephaz> gephazak = null;
            try {
                ResultSet rs = creatStatement.executeQuery(sql);
                gephazak = new ArrayList<>();

                while (rs.next()){
                    Gephaz actualGephaz = new Gephaz(rs.getInt("id"), rs.getString("name"), rs.getString("formfactor"), rs.getInt("vents"), rs.getInt("storage"), rs.getInt("GPULength"), rs.getInt("price"));
                    gephazak.add(actualGephaz);
                    
                }
            } catch (SQLException ex) {
                System.out.println("Valami baj van az adatok kiolvasásakor");
                System.out.println(""+ex);
            }
          return gephazak;
    }  

    public void addgephaz(Gephaz gephaz){
      try {
        String sql = "insert into gephaz values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, gephaz.getID());
        preparedStatement.setString(2, gephaz.getName());
        preparedStatement.setString(3, gephaz.getFormFactor());
        preparedStatement.setString(4, gephaz.getVents());
        preparedStatement.setString(5, gephaz.getStorage());
        preparedStatement.setString(6, gephaz.getGPULength());
        preparedStatement.setString(7, gephaz.getPrice());        
        preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a gépház hozzáadásakor");
            System.out.println(""+ex);
        }
    }
    
}

