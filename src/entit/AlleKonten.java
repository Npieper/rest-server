/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entit;

import java.util.ArrayList;

/**
 *
 * @author NiklasPieper
 */
public class AlleKonten {
    private ArrayList <Konto> kontenListe;
    private static AlleKonten exemplar;
    
    private AlleKonten() {
        kontenListe = new ArrayList<>();
    }
    public static AlleKonten getExemplar() {
        if(exemplar == null) {
            exemplar = new AlleKonten();
        }
        return exemplar;
    }

    public ArrayList<Konto> getAlleKonten() {
        return kontenListe;
    }

    public void setKontenliste(ArrayList<Konto> kontenliste) {
        this.kontenListe = kontenliste;
    }
    
    public void addKonto(Konto konto) {
	kontenListe.add(konto);

    }
	
    public void deleteKonto(Konto konto) {
	kontenListe.remove(konto);
    }
    public Konto getKontoByID(int kontonummer) {
        Konto returnKonto = null;
        for(Konto k : kontenListe) {
            if(kontonummer == k.getNummer()) {
                returnKonto = k;
            }
        }
        return returnKonto;
    }
    
    
    
}
