/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entit;

import java.util.ArrayList;

public class AlleTransaktionen {

	private static AlleTransaktionen exemplar;
	private ArrayList<Transaktion> transaktionListe;

	public static AlleTransaktionen getExemplar() {
		if (exemplar == null) {
			exemplar = new AlleTransaktionen();
		}
		return exemplar;
	}

	private AlleTransaktionen() {
		transaktionListe = new ArrayList<>();
	}

	public void addTranaktion(Transaktion transaktion) {
		transaktionListe.add(transaktion);

	}
	
	public void deleteTransaktion(Transaktion transaktion) {
		transaktionListe.remove(transaktion);
	}
	
	public ArrayList<Transaktion> getAlleTransaktionenVomTyp(TransaktionsTyp typ) {
		ArrayList<Transaktion> ergebnisListe = (ArrayList<Transaktion>) transaktionListe.clone();
		
		for (int i = 0; i < ergebnisListe.size(); i++) {
			if (ergebnisListe.get(i).getTyp()!=typ) {
				ergebnisListe.remove(i);
			}
			
		}
		
		return ergebnisListe;
	}
	
	public ArrayList<Transaktion> getAlleTransaktionen(){
		return this.transaktionListe;
	}
        
        

}