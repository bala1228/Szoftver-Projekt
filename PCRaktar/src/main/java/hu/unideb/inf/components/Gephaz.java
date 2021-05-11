
package hu.unideb.inf.components;


import javafx.beans.property.SimpleStringProperty;


    
public class Gephaz
{
    private final SimpleStringProperty nev;
    private final SimpleStringProperty alaplaptipus;
    private final SimpleStringProperty beepitetVentilatorokSzama;
    private final SimpleStringProperty ssdhely;
    private final SimpleStringProperty ar;

    public Gephaz() {
        this.nev = new SimpleStringProperty("");
        this.alaplaptipus = new SimpleStringProperty( "");
        this.beepitetVentilatorokSzama = new SimpleStringProperty("");
        this.ssdhely = new SimpleStringProperty("");
        this.ar = new SimpleStringProperty("");
    }
    
    
    public Gephaz(String nev, String alaplaptipus, String beepitetVentilatorokSzama,
                   String ssdhely, String ar) {
        this.nev = new SimpleStringProperty(nev);
        this.alaplaptipus = new SimpleStringProperty( alaplaptipus);
        this.beepitetVentilatorokSzama = new SimpleStringProperty(beepitetVentilatorokSzama);
       // this.szin = new SimpleStringProperty(szin);
        this.ssdhely = new SimpleStringProperty(ssdhely);
        this.ar = new SimpleStringProperty(ar);
    }

    
    
    public void setNev(String nev)
    {
        this.nev.set(nev);
    }

    public String getNev() {
        return this.nev.get() ; 
    }

    public void setAlaplaptipus(String alaplaptipus)
    {
        this.alaplaptipus.set(alaplaptipus);
    }

    public String getAlaplaptipus() {
        return this.alaplaptipus.get() ; 
    }
    
    public void setBeepitetVentilatorokSzama(String beepitetVentilatorokSzama)
    {
        this.beepitetVentilatorokSzama.set(beepitetVentilatorokSzama);
    }

    public String getBeepitetVentilatorokSzama() {
        return this.beepitetVentilatorokSzama.get() ; 
    }
    
    public void setSsdhely(String ssdhely)
    {
        this.ssdhely.set(ssdhely);
    }

    public String getSsdhely() {
        return this.ssdhely.get() ; 
    }
    
    public void setAr(String ar)
    {
        this.ar.set(ar);
    }

    public String getAr() {
        return this.ar.get() ; 
    }
    
 
}
