
    
package hu.unideb.inf;

import hu.unideb.inf.components.Alaplap;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db_alaplap
{
    final String sqlcreat="create table gephaz (id INT primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),name varchar(50), formfactor varchar(10), socket varchar(15), memoryslot varchar(5), amountofmem varchar(2), price varchar(7))";
    final String jdbcUrl = "jdbc:derby:sampleDB;create=true";
    final String jdbcUrl2 = "jdbc:sqlite:smfdb.db";
    
    Connection conn=null;
    Statement creatStatement = null;
    DatabaseMetaData dbmd = null;
    
    public Db_alaplap()
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
             ResultSet rs = dbmd.getTables(null,null,"alaplap" , null);
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

    public ArrayList<Alaplap> getAllAlaplap()
    {
            String sql = "select * from alaplap";
            ArrayList<Alaplap> alaplap = null;
            try {
                ResultSet rs = creatStatement.executeQuery(sql);
                alaplap = new ArrayList<>();

                while (rs.next()){
                    Alaplap actualAlaplap = new Alaplap(rs.getInt("id"), rs.getString("name"), rs.getString("formfactor"), rs.getString("socket"),
                                                                         rs.getString("memoryslot"), rs.getString("amountofmem"), rs.getString("price"));
                    alaplap.add(actualAlaplap);

                }
            } catch (SQLException ex) {
                System.out.println("Valami baj van az adatok kiolvasásakor");
                ex.printStackTrace();
            }

          return alaplap;
    }  

    public void addAlaplap(Alaplap alaplap)
    {
        try
        {
        String sql = "insert into alaplap (name, formfactor, socket, memoryslot, amountofmem, price) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, alaplap.getName());
        preparedStatement.setString(2, alaplap.getFormfactor());
        preparedStatement.setString(3, alaplap.getSocket());
        preparedStatement.setString(4, alaplap.getMemorySlot());
        preparedStatement.setString(5, alaplap.getAmountOfMem());
        preparedStatement.setString(6, alaplap.getPrice());
         preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van az alaplap  hozzáadásakor");
            ex.printStackTrace();
        }
    }    
        
        

    public void updateAlaplap(Alaplap alaplap)
    {
        try
        {
        String sql = "update alaplap set name=?, formfactor=?, socket=?, memoryslot=?, amountofmem=?, price=? where id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, alaplap.getName());
        preparedStatement.setString(2, alaplap.getFormfactor());
        preparedStatement.setString(3, alaplap.getSocket());
        preparedStatement.setString(4, alaplap.getMemorySlot());
        preparedStatement.setString(5, alaplap.getAmountOfMem());
        preparedStatement.setString(6, alaplap.getPrice());
        preparedStatement.setInt(7, Integer.parseInt(alaplap.getID()));
        preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van az alaplap hozzáadásakor");
            ex.printStackTrace();
        }
            
    }
    
    public void removeGephaz(Alaplap alaplap){
      try {
            String sql = "delete from alaplap where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(alaplap.getID()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van az alaplap törlésekor");
            System.out.println(""+ex);
        }
    }


}

