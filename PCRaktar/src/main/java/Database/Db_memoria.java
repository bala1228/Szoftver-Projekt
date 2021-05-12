
    
package Database;

import Components.Memoria;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db_memoria
{
    final String sqlcreat="create table memoria (id INT primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),name varchar(50), slot varchar(5),size varchar(4), frequency varchar(5), timing varchar(5) amount varchar(2), price varchar(7))";
    final String jdbcUrl = "jdbc:derby:sampleDB;create=true";
    //final String jdbcUrl2 = "jdbc:sqlite:smfdb.db";
    
    Connection conn=null;
    Statement creatStatement = null;
    DatabaseMetaData dbmd = null;
    
    public Db_memoria()
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
             ResultSet rs = dbmd.getTables(null,null,"memoria" , null);
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

    public ArrayList<Memoria> getAllMemoria()
    {
            String sql = "select * from memoria";
            ArrayList<Memoria> mem = null;
            try {
                ResultSet rs = creatStatement.executeQuery(sql);
                mem = new ArrayList<>();

                while (rs.next()){
                    Memoria actualMemoria = new Memoria(rs.getInt("id"), rs.getString("name"), rs.getString("slot"), rs.getString("size"),
                                            rs.getString("frequency"), rs.getString("timing"), rs.getString("amount"), rs.getString("price"));
                    mem.add(actualMemoria);

                }
            } catch (SQLException ex) {
                System.out.println("Valami baj van az adatok kiolvasásakor");
                ex.printStackTrace();
            }

          return mem;
    }  

    public void addMemoria(Memoria memoria)
    {
        try
        {
        String sql = "insert into memoria (name, slot, size, frequency, timing, amount, price) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, memoria.getName());
        preparedStatement.setString(2, memoria.getSlot());
        preparedStatement.setString(3, memoria.getSize());
        preparedStatement.setString(4, memoria.getFrequency());
        preparedStatement.setString(5, memoria.getTiming());
        preparedStatement.setString(6, memoria.getAmount());
        preparedStatement.setString(7, memoria.getPrice());
         preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a memoria hozzáadásakor");
            ex.printStackTrace();
        }
    }    
        
        

    public void updateGephaz(Memoria memoria)
    {
        try
        {
        String sql = "update memoria set name=?, slot=?, size=?, frequency=?, timing=?, amount=?, price=? where id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, memoria.getName());
        preparedStatement.setString(2, memoria.getSlot());
        preparedStatement.setString(3, memoria.getSize());
        preparedStatement.setString(4, memoria.getFrequency());
        preparedStatement.setString(5, memoria.getTiming());
        preparedStatement.setString(6, memoria.getAmount());
        preparedStatement.setString(7, memoria.getPrice());
        preparedStatement.setInt(8, Integer.parseInt(memoria.getID()));
        preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a memoria hozzáadásakor");
            ex.printStackTrace();
        }
            
    }
    
    public void removeGephaz(Memoria memoria){
      try {
            String sql = "delete from memoria where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(memoria.getID()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a memoria törlésekor");
            System.out.println(""+ex);
        }
    }


}