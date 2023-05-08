package Classes;


import Classes.Tache;

import java.util.ArrayList;
public class Liste {

    private ArrayList<Tache> lesTaches = new ArrayList<Tache>();
    private String nom;
    private String description;

    private int id_liste;



    public Liste (String nom, String description){
        this.nom = nom;
        this.description = description;
    }

    public Liste(int id_liste ,String nom ,String description){
        this.id_liste=id_liste;
        this.nom=nom;
        this.description=description;
    }

    public String getNom() {
        return nom;
    }



    public String getDescription() {
        return description;
    }

    public void validerTache(int i,boolean x){
        lesTaches.get(i).setRealise(x);
    }

    public void supprimerTache(int i) {
        lesTaches.remove(i);
    }

    public int nombreTache(){
        return lesTaches.size();
    }

    public void modifierTache(int index, String nom, String description){
        lesTaches.get(index).nvNom(nom);
        lesTaches.get(index).nvDescription(description);
    }

    public void ajouterTache(Tache uneTache){
        this.lesTaches.add(uneTache);
    }

    public String afficherNomTache(int i){
        return this.lesTaches.get(i).getNom();
    }

    public int afficherIdTache(int i){
        return this.lesTaches.get(i).getId_tache();
    }

    public String afficherDesfriptionTache(int i){
        return this.lesTaches.get(i).getDescription();
    }

    public String afficherEtatTache(int i){
        if(this.lesTaches.get(i).getRealise()){
            return "effectué";
        }else{
            return "non effectué";
        }
    }

    public int afficherRefType(int i){
        return lesTaches.get(i).getRef_type();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
