/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NiklasPieper
 */
@XmlRootElement(name="transaktion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaktion {
    private TransaktionsTyp typ;
    private int betrag;

    public Transaktion() {
        
    }

    public Transaktion(TransaktionsTyp typ, int betrag) {
        super();
        this.typ = typ;
        this.betrag = betrag;
    }
    

    
    

    public TransaktionsTyp getTyp() {
        return typ;
    }

    public void setTyp(TransaktionsTyp typ) {
        this.typ = typ;
    }

    public int getBetrag() {
        return betrag;
    }

    public void setBetrag(int betrag) {
        this.betrag = betrag;
    }
}
