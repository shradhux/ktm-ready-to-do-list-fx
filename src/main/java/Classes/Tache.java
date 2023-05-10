package Classes;

import java.util.ArrayList;

public class Tache {


    private int idTache;
    private String nom;
    private String description;
    private boolean est_realise;
    private int refListe;

    private int refType;


    public int getIdTache() {
        return idTache;
    }

    public String getDescription() {
        return description;
    }

    public void setRealise(boolean realisation){
        this.est_realise = realisation;
    }

    public String getNom() {
        return nom;
    }

    public int getRefListe() {
        return refListe;
    }


    public int getRefType(){
        return refType;
    }

    public boolean getRealise(){
        return this.est_realise;
    }

    public Tache(String description, String nom, boolean est_realise, int ref_liste, int ref_type){
        this.refListe = ref_liste;
        this.est_realise = est_realise;
        this.nom = nom;
        this.description = description;
        this.refType = ref_type;
    }

    public void nvNom(String nom) {
        this.nom = nom;
    }

    public void nvDescription(String description) {
        this.description = description;
    }
}