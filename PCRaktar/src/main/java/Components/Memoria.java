
package Components;

import javafx.beans.property.SimpleStringProperty;
    
public class Memoria
{
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty slot;
    private final SimpleStringProperty size;
    private final SimpleStringProperty frequency;
    private final SimpleStringProperty timing;
    private final SimpleStringProperty amount;
    private final SimpleStringProperty price;
    
    public Memoria() 
    {
        
        this.name = new SimpleStringProperty("");
        this.slot = new SimpleStringProperty("");
        this.size = new SimpleStringProperty("");
        this.frequency= new SimpleStringProperty("");
        this.timing= new SimpleStringProperty("");
        this.amount= new SimpleStringProperty("");
        this.price = new SimpleStringProperty("");
        this.id = new SimpleStringProperty("");
    }
    
    
    public Memoria(Integer id, String name , String slot, String size, String frequency, String timing, String amount, String price) 
    {
        
        this.name = new SimpleStringProperty(name);
        this.slot = new SimpleStringProperty(slot);
        this.size = new SimpleStringProperty(size);
        this.frequency= new SimpleStringProperty(frequency);
        this.timing= new SimpleStringProperty(timing);
        this.amount= new SimpleStringProperty(amount);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty(String.valueOf(id));
    }
    
    public Memoria(String name , String slot, String size, String frequency, String timing, String amount, String price) 
    {
        
        this.name = new SimpleStringProperty(name);
        this.slot = new SimpleStringProperty(slot);
        this.size = new SimpleStringProperty(size);
        this.frequency= new SimpleStringProperty(frequency);
        this.timing= new SimpleStringProperty(timing);
        this.amount= new SimpleStringProperty(amount);
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
    
    public void setSize(String size)
    {
        this.size.set(size);
    }

    public String getSize() 
    {
        return this.size.get(); 
    }
       
    public void setFrequency(String frequency)
    {
        this.frequency.set(frequency);
    }

    public String getFrequency() 
    {
        return this.frequency.get(); 
    }
    
     public void setTiming(String timing)
    {
        this.timing.set(timing);
    }

    public String getTiming() {
        return this.timing.get(); 
    }
    
    public void setAmount(String amount)
    {
        this.amount.set(amount);
    }

    public String getAmount() {
        return this.amount.get() ; 
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
