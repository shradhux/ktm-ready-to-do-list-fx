package Classes;

import java.util.ArrayList;

public class Tache {


    private int id_tache;
    private String nom;
    private String description;
    private boolean est_realise;
    private int ref_liste;

    private int ref_type;


    public int getId_tache() {
        return id_tache;
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

    public int getRef_liste() {
        return ref_liste;
    }


    public int getRef_type(){
        return ref_type;
    }

    public boolean getRealise(){
        return this.est_realise;
    }

    public Tache(String description, String nom, boolean est_realise, int ref_liste, int ref_type){
        this.ref_liste = ref_liste;
        this.est_realise = est_realise;
        this.nom = nom;
        this.description = description;
        this.ref_type = ref_type;
    }

    public void nvNom(String nom) {
        this.nom = nom;
    }

    public void nvDescription(String description) {
        this.description = description;
    }
}