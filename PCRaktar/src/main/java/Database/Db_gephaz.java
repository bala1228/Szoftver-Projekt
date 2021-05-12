
    
package Database;

import Components.Gephaz;
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
    final String sqlcreat="create table gephaz (id INT primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),name varchar(50), formfactor varchar(20), vents varchar(20), storage varchar(20), GPULength varchar(20), price varchar(20))";
    final String jdbcUrl = "jdbc:derby:sampleDB;create=true";
    //final String jdbcUrl2 = "jdbc:sqlite:smfdb.db";
    
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
            ex.printStackTrace();
        }            
         
        if (conn !=null)
        {
            try
            {
              creatStatement= conn.createStatement();

              System.out.println("Minden rendben creatStatementnél ");
            } catch (SQLException ex)

            {
             System.out.println("Valami bajvan a creatStatementnél ");
             ex.printStackTrace();
            }            
            
        try {           
            dbmd = conn.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a DatabaseMetaData (adatbázis leírása) létrehozásakor..");
            System.out.println(""+ex);
        }    
            
        }

        
         try
            {
             ResultSet rs = dbmd.getTables(null,null,"gephaz" , null);
             System.out.println("Minden rendben dbmd ");
                if (!rs.next())
                {
                    creatStatement.execute(sqlcreat);
                }         
            } catch (SQLException ex)
            {
             System.out.println("Valami bajvan az adattáblák létrehozásában");
             ex.printStackTrace();
            }              
    }

    public ArrayList<Gephaz> getAllGephaz()
    {
            String sql = "select * from gephaz";
            ArrayList<Gephaz> gep = null;
            try {
                ResultSet rs = creatStatement.executeQuery(sql);
                gep = new ArrayList<>();

                while (rs.next()){
                    Gephaz actualGephaz = new Gephaz(rs.getInt("id"), rs.getString("name"), rs.getString("formfactor"), rs.getString("vents"), rs.getString("storage"), rs.getString("GPULength"), rs.getString("price"));
                    gep.add(actualGephaz);

                }
            } catch (SQLException ex) {
                System.out.println("Valami baj van az adatok kiolvasásakor");
                ex.printStackTrace();
            }

          return gep;
    }  

    public void addGephaz(Gephaz gephaz)
    {
        try
        {
        String sql = "insert into gephaz (name, formfactor, vents, storage, GPULength, price) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, gephaz.getName());
        preparedStatement.setString(2, gephaz.getFormfactor());
        preparedStatement.setString(3, gephaz.getVents());
        preparedStatement.setString(4, gephaz.getStorage());
        preparedStatement.setString(5, gephaz.getGPULength());
        preparedStatement.setString(6, gephaz.getPrice());
         preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a gépház hozzáadásakor");
            ex.printStackTrace();
        }
    }    
        
        

    public void updateGephaz(Gephaz gephaz)
    {
        try
        {
        String sql = "update gephaz set name=?, formfactor=?, vents=?, storage=?, GPULength=?, price=? where id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, gephaz.getName());
        preparedStatement.setString(2, gephaz.getFormfactor());
        preparedStatement.setString(3, gephaz.getVents());
        preparedStatement.setString(4, gephaz.getStorage());
        preparedStatement.setString(5, gephaz.getGPULength());
        preparedStatement.setString(6, gephaz.getPrice());
        preparedStatement.setInt(7, Integer.parseInt(gephaz.getID()));
        preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a gépház hozzáadásakor");
            ex.printStackTrace();
        }
            
    }
    
    public void removeGephaz(Gephaz gephaz){
      try {
            String sql = "delete from gephaz where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(gephaz.getID()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a contact törlésekor");
            System.out.println(""+ex);
        }
    }


}

