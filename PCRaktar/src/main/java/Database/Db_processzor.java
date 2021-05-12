
    
package Database;

import Components.Processzor;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db_processzor
{
    final String sqlcreat="create table processzor (id INT primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),name varchar(50), name varchar(50), socket varchar(15), cores varchar(2), threads varchar(2), frequency varchar(3), maxfrequency varchar(3), price varchar(7))";
    final String jdbcUrl = "jdbc:derby:sampleDB;create=true";
    //final String jdbcUrl2 = "jdbc:sqlite:smfdb.db";
    
    Connection conn=null;
    Statement creatStatement = null;
    DatabaseMetaData dbmd = null;
    
    public Db_processzor()
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
             ResultSet rs = dbmd.getTables(null,null,"processzor" , null);
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

    public ArrayList<Processzor> getAllProcesszor()
    {
            String sql = "select * from processzor";
            ArrayList<Processzor> proc = null;
            try {
                ResultSet rs = creatStatement.executeQuery(sql);
                proc = new ArrayList<>();

                while (rs.next()){
                    Processzor actualProcesszor = new Processzor(rs.getInt("id"), rs.getString("name"), rs.getString("socket"), rs.getString("cores"),
                                                  rs.getString("threads"), rs.getString("frequency"), rs.getString("maxfrequency"), rs.getString("price"));
                    proc.add(actualProcesszor);

                }
            } catch (SQLException ex) {
                System.out.println("Valami baj van az adatok kiolvasásakor");
                ex.printStackTrace();
            }

          return proc;
    }  

    public void addProcesszor(Processzor processzor)
    {
        try
        {
        String sql = "insert into processzor (name, socket, cores, threads, frequency, maxfrequency, price) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, processzor.getName());
        preparedStatement.setString(2, processzor.getSocket());
        preparedStatement.setString(3, processzor.getCores());
        preparedStatement.setString(4, processzor.getThreads());
        preparedStatement.setString(5, processzor.getFrequency());
        preparedStatement.setString(6, processzor.getMaxFrequency());
        preparedStatement.setString(7, processzor.getPrice());
         preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a processzor hozzáadásakor");
            ex.printStackTrace();
        }
    }    
        
        

    public void updateProcesszor(Processzor processzor)
    {
        try
        {
        String sql = "update processzor set name=?, socket=?, cores=?, threads=?, frequency=?, maxfrequency =?, price=? where id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
       preparedStatement.setString(1, processzor.getName());
        preparedStatement.setString(2, processzor.getSocket());
        preparedStatement.setString(3, processzor.getCores());
        preparedStatement.setString(4, processzor.getThreads());
        preparedStatement.setString(5, processzor.getFrequency());
        preparedStatement.setString(6, processzor.getMaxFrequency());
        preparedStatement.setString(7, processzor.getPrice());
        preparedStatement.setInt(8, Integer.parseInt(processzor.getID()));
        preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a processzor hozzáadásakor");
            ex.printStackTrace();
        }
            
    }
    
    public void removeProcesszor(Processzor processzor){
      try {
            String sql = "delete from processzor where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(processzor.getID()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a processzor törlésekor");
            System.out.println(""+ex);
        }
    }


}

