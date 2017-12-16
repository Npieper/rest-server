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
public class AlleKunden {
     private ArrayList <Kunde> kundenListe;
    private static AlleKunden exemplar;
    
    private AlleKunden() {
        kundenListe = new ArrayList<>();
    }
    
    public static AlleKunden getExemplar() {
        if(exemplar == null) {
            exemplar = new AlleKunden();
        }
        return exemplar;
    }

    public ArrayList<Kunde> getAlleKunden() {
        return kundenListe;
    }

    public void setKundenListe(ArrayList<Kunde> kundenListe) {
        this.kundenListe = kundenListe;
    }
    
    public void addKunde(Kunde kunde) {
	kundenListe.add(kunde);

    }
	
    public void deleteKunde(Kunde kunde) {
	kundenListe.remove(kunde);
    }
    
    public Kunde getKundeById(String name) {
        Kunde einzigerKunde = null;
        
        for(Kunde kunde : kundenListe) {
            if(kunde.getName().equals(name)) {
                einzigerKunde = kunde;
            }
        }
        return einzigerKunde;
    }
}
