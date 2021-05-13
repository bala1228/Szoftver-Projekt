
    
package Database;

import Components.Videokartya;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db_videokartya
{
    final String sqlcreat="create table videokartya (id INT primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),manifacture varchar(30), name varchar(50), slot varchar(20),vram varchar(3), frequency varchar(8), length varchar(5), price varchar(7))";
    final String jdbcUrl = "jdbc:derby:sampleDB;create=true";
    //final String jdbcUrl2 = "jdbc:sqlite:smfdb.db";
    
    Connection conn=null;
    Statement creatStatement = null;
    DatabaseMetaData dbmd = null;
    
    public Db_videokartya()
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
             ResultSet rs = dbmd.getTables(null,"APP","videokartya" , null);
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

    public ArrayList<Videokartya> getAllVideokartya()
    {
            String sql = "select * from videokartya";
            ArrayList<Videokartya> gpu = null;
            try {
                ResultSet rs = creatStatement.executeQuery(sql);
                gpu = new ArrayList<>();

                while (rs.next()){
                    Videokartya actualVideokartya = new Videokartya(rs.getInt("id"), rs.getString("manifacture"), rs.getString("name"), rs.getString("slot"),
                                            rs.getString("vram"), rs.getString("frequency"), rs.getString("length"), rs.getString("price"));
                    gpu.add(actualVideokartya);

                }
            } catch (SQLException ex) {
                System.out.println("Valami baj van az adatok kiolvasásakor");
                ex.printStackTrace();
            }

          return gpu;
    }  

    public void addVideokartya(Videokartya videokartya)
    {
        try
        {
        String sql = "insert into videokartya (manifacture, name, slot, vram, frequency, length, price) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, videokartya.getManifacture());
        preparedStatement.setString(2, videokartya.getName());
        preparedStatement.setString(3, videokartya.getSlot());
        preparedStatement.setString(4, videokartya.getVram());
        preparedStatement.setString(5, videokartya.getFrequency());
        preparedStatement.setString(6, videokartya.getLength());
        preparedStatement.setString(7, videokartya.getPrice());
         preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a videokartya hozzáadásakor");
            ex.printStackTrace();
        }
    }    
        
        

    public void updateVideokartya(Videokartya videokartya)
    {
        try
        {
        String sql = "update videokartya set manifacture=?, name=?, slot=?, vram=?, frequency=?, length=?, price=? where id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, videokartya.getManifacture());
        preparedStatement.setString(2, videokartya.getName());
        preparedStatement.setString(3, videokartya.getSlot());
        preparedStatement.setString(4, videokartya.getVram());
        preparedStatement.setString(5, videokartya.getFrequency());
        preparedStatement.setString(6, videokartya.getLength());
        preparedStatement.setString(7, videokartya.getPrice());
        preparedStatement.setInt(8, Integer.parseInt(videokartya.getID()));
        preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a videokartya hozzáadásakor");
            ex.printStackTrace();
        }
            
    }
    
    public void removeVideokartya(Videokartya videokartya){
      try {
            String sql = "delete from videokartya where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(videokartya.getID()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a videokartya törlésekor");
            System.out.println(""+ex);
        }
    }


}