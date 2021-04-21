/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Felhasználó(user)
 */
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

    public void setFormatum(String alaplaptipus)
    {
        this.cache.set(alaplaptipus);
    }

    public String getFomatum() {
        return this.cache.get() ; 
    }
    
    public void setProceszorFog(String beepitetVentilatorokSzama)
    {
        this.csatoloFelulet.set(beepitetVentilatorokSzama);
    }

    public String getProceszorFog() {
        return this.csatoloFelulet.get() ; 
    }
    
    public void setMemoriaFog(String ssdhely)
    {
        this.kapacitas.set(ssdhely);
    }

    public String getMemoriaFog() {
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
