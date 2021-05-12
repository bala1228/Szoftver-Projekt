
package Components;

import javafx.beans.property.SimpleStringProperty;
   
public class Tarhely
{
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleStringProperty formfactor;
    private final SimpleStringProperty volume;
    private final SimpleStringProperty readspeed;
    private final SimpleStringProperty writespeed;
    private final SimpleStringProperty price;
    
    public Tarhely() {
        
        this.name = new SimpleStringProperty("");
        this.type = new SimpleStringProperty("");
        this.formfactor = new SimpleStringProperty("");
        this.volume= new SimpleStringProperty("");
        this.readspeed= new SimpleStringProperty("");
        this.writespeed= new SimpleStringProperty("");
        this.price = new SimpleStringProperty("");
        this.id = new SimpleStringProperty("");
    }
    
    
    public Tarhely(Integer id, String name , String type, String formfactor, String volume, String readspeed,String writespeed, String price) {
        
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.formfactor = new SimpleStringProperty(formfactor);
        this.volume= new SimpleStringProperty(volume);
        this.readspeed= new SimpleStringProperty(readspeed);
        this.writespeed= new SimpleStringProperty(writespeed);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty(String.valueOf(id));
    }
    
    public Tarhely(String name , String type, String formfactor, String volume, String readspeed,String writespeed, String price) {
        
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.formfactor = new SimpleStringProperty(formfactor);
        this.volume= new SimpleStringProperty(volume);
        this.readspeed= new SimpleStringProperty(readspeed);
        this.writespeed= new SimpleStringProperty(writespeed);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty("");
    }
    

     public void setID(String id)
    {
        this.name.set(id);
    }

    public String getID() {
        return this.id.get() ; 
    }
    
    public void setName(String fname)
    {
        name.set(fname);
    }

    public String getName() {

        return name.get() ; 

    }
    
     public void setType(String type)
    {
        this.type.set(type);
    }

    public String getType() {
        return this.type.get() ; 
    }
    
    public void setFormFactor(String formfactor)
    {
        this.formfactor.set(formfactor);
    }

    public String getFormFactor() {
        return this.formfactor.get() ; 
    }
    
     public void setVolume(String volume)
    {
        this.volume.set(volume);
    }

    public String getVolume() {
        return this.volume.get() ; 
    }
    
    public void setReadSpeed(String readspeed)
    {
        this.readspeed.set(readspeed);
    }

    public String getReadSpeed() {
        return this.readspeed.get() ; 
    }
    
    public void setWriteSpeed(String writespeed)
    {
        this.writespeed.set(writespeed);
    }

    public String getWriteSpeed() {
        return this.writespeed.get() ; 
    }
    
     public void setPrice(String price)
    {
        this.price.set(price);
    }

    public String getPrice() {
        return this.price.get() ; 
    }

    
}
