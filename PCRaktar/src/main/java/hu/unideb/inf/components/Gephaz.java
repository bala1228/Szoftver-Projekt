
package hu.unideb.inf.components;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


    
public class Gephaz
{
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty formfactor;
    private final SimpleStringProperty vents;
    private final SimpleStringProperty storage;
    private final SimpleStringProperty GPULength;
    private final SimpleStringProperty price;
    
    
    
    
    
    
    
    
    public Gephaz() {
        this.id = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.formfactor = new SimpleStringProperty("");
        this.vents = new SimpleStringProperty("");
        this.storage= new SimpleStringProperty("");
        this.GPULength= new SimpleStringProperty("");
        this.price = new SimpleStringProperty("");
    }
    
    
    public Gephaz(String name , String formfactor, String vents, String storage, String GPULength, String price) {
        this.id = new SimpleStringProperty("");
        this.name = new SimpleStringProperty(name);
        this.formfactor = new SimpleStringProperty(formfactor);
        this.vents = new SimpleStringProperty(vents);
        this.storage= new SimpleStringProperty(storage);
        this.GPULength= new SimpleStringProperty(GPULength);
        this.price = new SimpleStringProperty(price);
    }

    
    
    public void setName(String name)
    {
        this.name.set(name);
    }

    public String getNev() {
        return this.name.get() ; 
    }
    
     public void setFormfactor(String formfactor)
    {
        this.formfactor.set(formfactor);
    }

    public String getFormfactor() {
        return this.formfactor.get() ; 
    }
    
    public void setVents(String vents)
    {
        this.vents.set(vents);
    }

    public String getVents() {
        return this.vents.get() ; 
    }
    
     public void setStorage(String storage)
    {
        this.storage.set(storage);
    }

    public String getStorage() {
        return this.storage.get() ; 
    }
    
    public void setGPULength(String GPULength)
    {
        this.GPULength.set(GPULength);
    }

    public String getGPULength() {
        return this.GPULength.get() ; 
    }
    
     public void setPrice(String price)
    {
        this.price.set(price);
    }

    public String getPrice() {
        return this.price.get() ; 
    }

    
}
