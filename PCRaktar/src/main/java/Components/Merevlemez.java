
package Components;

import javafx.beans.property.SimpleStringProperty;

public class Merevlemez {
    private final SimpleStringProperty nev;
    private final SimpleStringProperty cache;
    private final SimpleStringProperty csatoloFelulet;
    private final SimpleStringProperty kapacitas;
    private final SimpleStringProperty ar;

    public Merevlemez() {
        this.nev = new SimpleStringProperty("");
        this.cache = new SimpleStringProperty( "");
        this.csatoloFelulet = new SimpleStringProperty("");
        this.kapacitas = new SimpleStringProperty("");
        this.ar = new SimpleStringProperty("");
    }
    
    
    public Merevlemez(String nev, String alaplaptipus, String beepitetVentilatorokSzama,
                   String ssdhely, String ar) {
        this.nev = new SimpleStringProperty(nev);
        this.cache = new SimpleStringProperty( alaplaptipus);
        this.csatoloFelulet = new SimpleStringProperty(beepitetVentilatorokSzama);
       // this.szin = new SimpleStringProperty(szin);
        this.kapacitas = new SimpleStringProperty(ssdhely);
        this.ar = new SimpleStringProperty(ar);
    }

    
    
    public void setNev(String nev)
    {
        this.nev.set(nev);
    }

    public String getNev() {
        return this.nev.get() ; 
    }

    public void setCache(String alaplaptipus)
    {
        this.cache.set(alaplaptipus);
    }

    public String getCache() {
        return this.cache.get() ; 
    }
    
    public void setCsatoloFelulet(String beepitetVentilatorokSzama)
    {
        this.csatoloFelulet.set(beepitetVentilatorokSzama);
    }

    public String getCsatoloFelulet() {
        return this.csatoloFelulet.get() ; 
    }
    
    public void setKapacitas(String ssdhely)
    {
        this.kapacitas.set(ssdhely);
    }

    public String getKapacitas() {
        return this.kapacitas.get() ; 
    }
    
    public void setAr(String ar)
    {
        this.ar.set(ar);
    }

    public String getAr() {
        return this.ar.get() ; 
    }
}