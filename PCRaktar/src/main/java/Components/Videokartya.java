
package Components;

import javafx.beans.property.SimpleStringProperty;
    
public class Videokartya
{
    private final SimpleStringProperty id;
    private final SimpleStringProperty manifacture;
    private final SimpleStringProperty name;
    private final SimpleStringProperty slot;
    private final SimpleStringProperty vram;
    private final SimpleStringProperty frequency;
    private final SimpleStringProperty length;
    private final SimpleStringProperty price;
    
    public Videokartya() 
    {
        
        this.manifacture = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.slot = new SimpleStringProperty("");
        this.vram= new SimpleStringProperty("");
        this.frequency= new SimpleStringProperty("");
        this.length= new SimpleStringProperty("");
        this.price = new SimpleStringProperty("");
        this.id = new SimpleStringProperty("");
    }
    
    
    public Videokartya(Integer id, String manifacture , String name, String slot, String vram, String frequency, String length, String price) 
    {
        
        this.name = new SimpleStringProperty(name);
        this.manifacture = new SimpleStringProperty(manifacture);
        this.slot= new SimpleStringProperty(slot);
        this.vram= new SimpleStringProperty(vram);
        this.frequency= new SimpleStringProperty(frequency);
        this.length = new SimpleStringProperty(length);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty(String.valueOf(id));
    }
    
    public Videokartya(String manifacture , String name, String slot, String vram, String frequency, String length, String price) 
    {
        
       this.name = new SimpleStringProperty(name);
        this.manifacture = new SimpleStringProperty(manifacture);
        this.slot= new SimpleStringProperty(slot);
        this.vram= new SimpleStringProperty(vram);
        this.frequency= new SimpleStringProperty(frequency);
        this.length = new SimpleStringProperty(length);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty("");
    }
    

     public void setID(String id)
    {
        this.name.set(id);
    }

    public String getID() {
        return this.id.get(); 
    }
    
    public void setManifacture(String manifacture)
    {
        this.manifacture.set(manifacture);
    }

    public String getManifacture() 
    {
        return this.manifacture.get(); 
    }
     
    public void setName(String fname)
    {
        name.set(fname);
    }

    public String getName() 
    {

        return name.get(); 

    }
    
     public void setSlot(String slot)
    {
        this.slot.set(slot);
    }

    public String getSlot() 
    {
        return this.slot.get(); 
    }
     
     public void setVram(String vram)
    {
        this.vram.set(vram);
    }

    public String getVram() {
        return this.vram.get(); 
    }
        
    public void setFrequency(String frequency)
    {
        this.frequency.set(frequency);
    }

    public String getFrequency() 
    {
        return this.frequency.get(); 
    }
    
    public void setLength(String length)
    {
        this.length.set(length);
    }

    public String getLength() {
        return this.length.get() ; 
    }
    
     public void setPrice(String price)
    {
        this.price.set(price);
    }

    public String getPrice() 
    {
        return this.price.get() ; 
    }
}
