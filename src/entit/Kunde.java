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

/**
 *
 * @author NiklasPieper
 */
@XmlRootElement(name="kunde")
@XmlAccessorType(XmlAccessType.FIELD)
public class Kunde {
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="adresse")
    private String adresse;
    private ArrayList <Konto> besitzt;

    public Kunde() {
        besitzt = new ArrayList<>();
    }

    public Kunde(String name, String adresse) {
        super();
        this.name = name;
        this.adresse = adresse;
        this.besitzt = besitzt;
        besitzt = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Konto> getBesitzt() {
        return besitzt;
    }

    public void setBesitzt(ArrayList<Konto> besitzt) {
        this.besitzt = besitzt;
    }
}
