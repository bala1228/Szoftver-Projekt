<<<<<<< HEAD

    
package Database;

import Components.Tarhely;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Db_tarhely
{
    final String sqlcreat="create table processzor (id INT primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),name varchar(50), name varchar(50), socket varchar(15), cores varchar(2), threads varchar(2), frequency varchar(3), maxfrequency varchar(3), price varchar(7))";
    final String jdbcUrl = "jdbc:derby:sampleDB;create=true";
    //final String jdbcUrl2 = "jdbc:sqlite:smfdb.db";
    
    Connection conn=null;
    Statement creatStatement = null;
    DatabaseMetaData dbmd = null;
    
    public Db_tarhely()
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
             ResultSet rs = dbmd.getTables(null,null,"tarhely" , null);
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

    public ArrayList<Tarhely> getAllTarhely()
    {
            String sql = "select * from tarhely";
            ArrayList<Tarhely> stor = null;
            try {
                ResultSet rs = creatStatement.executeQuery(sql);
                stor = new ArrayList<>();

                while (rs.next()){
                    Tarhely actualTarhely = new Tarhely(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getString("formfactor"),
                                                  rs.getString("volume"), rs.getString("readspeed"), rs.getString("writespeed"), rs.getString("price"));
                    stor.add(actualTarhely);

                }
            } catch (SQLException ex) {
                System.out.println("Valami baj van az adatok kiolvasásakor");
                ex.printStackTrace();
            }

          return stor;
    }  

    public void addTarhely(Tarhely tarhely)
    {
        try
        {
        String sql = "insert into tarhely (name, type, formfactor, volume, readspeed, writespeed, price) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, tarhely.getName());
        preparedStatement.setString(2, tarhely.getType());
        preparedStatement.setString(3, tarhely.getFormFactor());
        preparedStatement.setString(4, tarhely.getVolume());
        preparedStatement.setString(5, tarhely.getReadSpeed());
        preparedStatement.setString(6, tarhely.getWriteSpeed());
        preparedStatement.setString(7, tarhely.getPrice());
         preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a tarhely hozzáadásakor");
            ex.printStackTrace();
        }
    }    
        
        

    public void updateProcesszor(Tarhely tarhely)
    {
        try
        {
        String sql = "update tarhely set name=?, type=?, formfactor=?, volume=?, readspeed=?, writespeed=?, price=? where id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, tarhely.getName());
        preparedStatement.setString(2, tarhely.getType());
        preparedStatement.setString(3, tarhely.getFormFactor());
        preparedStatement.setString(4, tarhely.getVolume());
        preparedStatement.setString(5, tarhely.getReadSpeed());
        preparedStatement.setString(6, tarhely.getWriteSpeed());
        preparedStatement.setString(7, tarhely.getPrice());
        preparedStatement.setInt(8, Integer.parseInt(tarhely.getID()));
        preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Valami baj van a tarhely hozzáadásakor");
            ex.printStackTrace();
        }
            
    }
    
    public void removeProcesszor(Tarhely tarhely){
      try {
            String sql = "delete from tarhely where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(tarhely.getID()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a tarhely törlésekor");
            System.out.println(""+ex);
        }
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Szulejman
 */
public class Db_tarhely {
    
}
>>>>>>> parent of 6db2cd4 (még müxik)
