/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entit;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NiklasPieper
 */
@XmlRootElement(name="konto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Konto {
    @XmlElement(name="stand")
    private int stand;
    @XmlElement(name="nummer")
    private int nummer;
    @XmlTransient
    private Kunde kunde;
    private ArrayList<Transaktion> aktionen;

    public Konto() {
        
    }

    public Konto(int stand, int nummer, Kunde kunde) {
        super();
        this.stand = stand;
        this.nummer = nummer;
        this.kunde = kunde;
        this.aktionen = new ArrayList<>();
    }

    
    public int getStand() {
        return stand;
    }

    public void setStand(int stand) {
        this.stand = stand;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public ArrayList<Transaktion> getAktionen() {
        return aktionen;
    }

    public void setAktionen(ArrayList<Transaktion> aktionen) {
        this.aktionen = aktionen;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    
}
