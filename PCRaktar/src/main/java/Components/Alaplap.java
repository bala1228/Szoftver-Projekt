
package Components;

import javafx.beans.property.SimpleStringProperty;
    
public class Alaplap
{
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty formfactor;
    private final SimpleStringProperty socket;
    private final SimpleStringProperty memoryslot;
    private final SimpleStringProperty amountofmem;
    private final SimpleStringProperty price;
    
    public Alaplap() {
        
        this.name = new SimpleStringProperty("");
        this.formfactor = new SimpleStringProperty("");
        this.socket = new SimpleStringProperty("");
        this.memoryslot= new SimpleStringProperty("");
        this.amountofmem= new SimpleStringProperty("");
        this.price = new SimpleStringProperty("");
        this.id = new SimpleStringProperty("");
    }
    
    
    public Alaplap(Integer id,String name , String formfactor, String socket, String memoryslot, String amountofmem, String price) {
        
        this.name = new SimpleStringProperty(name);
        this.formfactor = new SimpleStringProperty(formfactor);
        this.socket = new SimpleStringProperty(socket);
        this.memoryslot= new SimpleStringProperty(memoryslot);
        this.amountofmem= new SimpleStringProperty(amountofmem);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty(String.valueOf(id));
    }
    
    public Alaplap(String name , String formfactor, String socket, String memoryslot, String amountofmem, String price) {
        
        this.name = new SimpleStringProperty(name);
        this.formfactor = new SimpleStringProperty(formfactor);
        this.socket = new SimpleStringProperty(socket);
        this.memoryslot= new SimpleStringProperty(memoryslot);
        this.amountofmem= new SimpleStringProperty(amountofmem);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty("");
    }
    

     public void setID(String id)
    {
        this.name.set(id);
    }

    public String getID() 
    {
        return this.id.get() ; 
    }
    
    public void setName(String fname)
    {
        name.set(fname);
    }

    public String getName() 
    {
        return name.get() ; 
    }
    
     public void setFormfactor(String formfactor)
    {
        this.formfactor.set(formfactor);
    }

    public String getFormfactor() 
    {
        return this.formfactor.get() ; 
    }
    
    public void setSocket(String socket)
    {
        this.socket.set(socket);
    }

    public String getSocket() 
    {
        return this.socket.get() ; 
    }
    
     public void setMemorySlot(String memoryslot)
    {
        this.memoryslot.set(memoryslot);
    }

    public String getMemorySlot() 
    {
        return this.memoryslot.get() ; 
    }
    
    public void setAmountOfMem(String amountofmem)
    {
        this.amountofmem.set(amountofmem);
    }

    public String getAmountOfMem() {
        return this.amountofmem.get() ; 
    }
    
     public void setPrice(String price)
    {
        this.price.set(price);
    }

    public String getPrice() {
        return this.price.get() ; 
    }

    
}
