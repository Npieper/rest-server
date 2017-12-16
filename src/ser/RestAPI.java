/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ser;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entit.AlleKonten;
import entit.AlleKonten;
import entit.AlleKunden;
import entit.AlleTransaktionen;
import entit.Konto;
import entit.Kunde;
import entit.Transaktion;
import entit.TransaktionsTyp;
import static entit.TransaktionsTyp.AUSZAHLUNG;
import static entit.TransaktionsTyp.EINZAHLUNG;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NiklasPieper
 */
@Path("bankservices")
public class RestAPI {
    
    // Nummer 1, Kunden anlegen anhand Name und Addresse
    @POST
    @Path("kunden")
    @Consumes(MediaType.APPLICATION_XML)
    public void kundenAnlegen(Kunde kunde) {
        
        AlleKunden.getExemplar().addKunde(kunde);
	System.out.println("Kunde: "+kunde.getName() +" wurde angelegt");
    }
    
     // Nummer 2, Kunden mit Namen abfragen
    @GET
    @Path("kunden/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public Kunde getKundeByName(@PathParam("name") String name) {
        System.out.println("Bin in getKundeByName!");
        return AlleKunden.getExemplar().getKundeById(name);
    }
    
    // Nummer 3, neues Konto anlegen
    @POST
    @Path("kunden/{name}/konten")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String kontoAnlegen(String kontostandP, @PathParam("name") String name) {
        System.out.println("Bin in kontoAnlegen!");
        int kontonummer = AlleKonten.getExemplar().getAlleKonten().size()+1;
        // int stand, int nummer, ArrayList<Transaktion> aktionen, Kunde kunde
        Kunde kunde = AlleKunden.getExemplar().getKundeById(name);
        if(kunde == null) {
            System.out.println("Für das Konto was sie anlegen wollen existiert kein Kunde !");
            return "" + -1;
        } else {
            Konto konto = new Konto(Integer.parseInt(kontostandP),kontonummer,kunde);
            kunde.getBesitzt().add(konto);
            AlleKonten.getExemplar().addKonto(konto);
            return ""+kontonummer;
        }

    }
    
    
    
   
        
        
          
    
    // Nummer 4
    @POST
    @Path("konten/{kontonummer}/transaktionen")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Kunde neueTransaktion(Transaktion transaktion, @PathParam("kontonummer") String kontonummer) {
        Konto k = AlleKonten.getExemplar().getKontoByID(Integer.parseInt(kontonummer));
        
        if(k == null) {
            System.out.println("Konto existiert nicht.");
        } else {
            
            if(transaktion.getTyp() == EINZAHLUNG) {
                k.setStand(k.getStand() + transaktion.getBetrag());
            } else {
                k.setStand(k.getStand() - transaktion.getBetrag());
            }
            k.getAktionen().add(transaktion);
        }
        
        
        return k.getKunde();
    }
    
    // Nummer 5
    
    @GET
    @Path("kunden/{name}/konten")
    @Produces(MediaType.APPLICATION_XML)
    public List<Konto> getAlleKontenVonKunde(@PathParam("name") String name) {
        Kunde k = AlleKunden.getExemplar().getKundeById(name);
        List<Konto> kontoListe = k.getBesitzt();
        
        return kontoListe;
    }
    
    // Nummer 6
    @GET
    @Path("konten/{kontonummer}/kontostand")
    @Produces(MediaType.TEXT_PLAIN)
    public String getKontostand(@PathParam("kontonummer") int kontonummer) {
        Konto k = AlleKonten.getExemplar().getKontoByID(kontonummer);
        int gesuchteNummer = k.getStand();
        
        return gesuchteNummer + "";
    }
    
    // Nummer 7
    @GET
    @Path("konten/{kontonummer}/transaktionen")
    @Produces(MediaType.APPLICATION_XML)
    public List<Transaktion> getAlleTransaktionenVonKonto(@PathParam("kontonummer") int kontonummer, @QueryParam("typ") String typ) {
        Konto k = AlleKonten.getExemplar().getKontoByID(kontonummer);
        List <Transaktion> aktList = k.getAktionen();
        List<Transaktion> ergebnisListe = new ArrayList<Transaktion>();
        
        if(typ.equals("EINZAHLUNG")) {
            System.out.println("Bin in Einzahlung !!!!!!!");
             for(Transaktion t : aktList) {
                 if(t.getTyp().equals(EINZAHLUNG)) {
                    ergebnisListe.add(t);
                 }
        }
        } else {
            System.out.println("Bin in Auszahlung !!!!!!!");
            for(Transaktion t : aktList) {
                 if(t.getTyp().equals(AUSZAHLUNG)) {
                    ergebnisListe.add(t);
                 }
        }
        }
       
        return ergebnisListe;
        }
        
       
    
    
    
    
    
    // Abfrage aller Kunden unter dem Path kunden
    @GET
    @Path("kunden")
    @Produces(MediaType.APPLICATION_XML)
    
    public List<Kunde> getAlleKunden() {
        System.out.println("Bin in getAlleKunden!");
        return AlleKunden.getExemplar().getAlleKunden();
    }
    
   
}
