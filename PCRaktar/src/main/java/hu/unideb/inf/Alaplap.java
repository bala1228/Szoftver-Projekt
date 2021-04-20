
package hu.unideb.inf;

import javafx.beans.property.SimpleStringProperty;


public class Alaplap {
    private final SimpleStringProperty nev;
    private final SimpleStringProperty formatum;
    private final SimpleStringProperty proceszorFog;
    private final SimpleStringProperty memoriaFog;
    private final SimpleStringProperty ar;

    public Alaplap() {
        this.nev = new SimpleStringProperty("");
        this.formatum = new SimpleStringProperty( "");
        this.proceszorFog = new SimpleStringProperty("");
        this.memoriaFog = new SimpleStringProperty("");
        this.ar = new SimpleStringProperty("");
    }
    
    
    public Alaplap(String nev, String alaplaptipus, String beepitetVentilatorokSzama,
                   String ssdhely, String ar) {
        this.nev = new SimpleStringProperty(nev);
        this.formatum = new SimpleStringProperty( alaplaptipus);
        this.proceszorFog = new SimpleStringProperty(beepitetVentilatorokSzama);
       // this.szin = new SimpleStringProperty(szin);
        this.memoriaFog = new SimpleStringProperty(ssdhely);
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
        this.formatum.set(alaplaptipus);
    }

    public String getAlaplaptipus() {
        return this.formatum.get() ; 
    }
    
    public void setBeepitetVentilatorokSzama(String beepitetVentilatorokSzama)
    {
        this.proceszorFog.set(beepitetVentilatorokSzama);
    }

    public String getBeepitetVentilatorokSzama() {
        return this.proceszorFog.get() ; 
    }
    
    public void setSsdhely(String ssdhely)
    {
        this.memoriaFog.set(ssdhely);
    }

    public String getSsdhely() {
        return this.memoriaFog.get() ; 
    }
    
    public void setAr(String ar)
    {
        this.ar.set(ar);
    }

    public String getAr() {
        return this.ar.get() ; 
    }
    
}
