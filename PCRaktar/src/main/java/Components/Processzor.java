
package Components;



import javafx.beans.property.SimpleStringProperty;


    
public class Processzor
{
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty socket;
    private final SimpleStringProperty cores;
    private final SimpleStringProperty threads;
    private final SimpleStringProperty frequency;
    private final SimpleStringProperty maxfrequency;
    private final SimpleStringProperty price;
    
    public Processzor() {
        
        this.name = new SimpleStringProperty("");
        this.socket = new SimpleStringProperty("");
        this.cores = new SimpleStringProperty("");
        this.threads= new SimpleStringProperty("");
        this.frequency= new SimpleStringProperty("");
        this.maxfrequency= new SimpleStringProperty("");
        this.price = new SimpleStringProperty("");
        this.id = new SimpleStringProperty("");
    }
    
    
    public Processzor(Integer id, String name , String socket, String cores, String threads, String frequency,String maxfrequency, String price) {
        
        this.name = new SimpleStringProperty(name);
        this.socket = new SimpleStringProperty(socket);
        this.cores = new SimpleStringProperty(cores);
        this.threads= new SimpleStringProperty(threads);
        this.frequency= new SimpleStringProperty(frequency);
        this.maxfrequency= new SimpleStringProperty(maxfrequency);
        this.price = new SimpleStringProperty(price);
        this.id = new SimpleStringProperty(String.valueOf(id));
    }
    
    public Processzor(String name , String socket, String cores, String threads, String frequency,String maxfrequency, String price) {
        
        this.name = new SimpleStringProperty(name);
        this.socket = new SimpleStringProperty(socket);
        this.cores = new SimpleStringProperty(cores);
        this.threads= new SimpleStringProperty(threads);
        this.frequency= new SimpleStringProperty(frequency);
        this.maxfrequency= new SimpleStringProperty(maxfrequency);
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
    
     public void setSocket(String socket)
    {
        this.socket.set(socket);
    }

    public String getSocket() {
        return this.socket.get() ; 
    }
    
    public void setCores(String cores)
    {
        this.cores.set(cores);
    }

    public String getCores() {
        return this.cores.get() ; 
    }
    
     public void setThreads(String threads)
    {
        this.cores.set(threads);
    }

    public String getThreads() {
        return this.threads.get() ; 
    }
    
    public void setFrequency(String frequency)
    {
        this.frequency.set(frequency);
    }

    public String getFrequency() {
        return this.frequency.get() ; 
    }
    
    public void setMaxFrequency(String maxfrequency)
    {
        this.maxfrequency.set(maxfrequency);
    }

    public String getMaxFrequency() {
        return this.maxfrequency.get() ; 
    }
    
     public void setPrice(String price)
    {
        this.price.set(price);
    }

    public String getPrice() {
        return this.price.get() ; 
    }

    
}
