package graphicController;


import java.util.ArrayList;

public class CarnetDeListe {

    private ArrayList<Liste> lesListes;

    public CarnetDeListe(){
        this.lesListes = new ArrayList<Liste>();
    }

    public void appelValidationTache(int i, int y, boolean b){
        lesListes.get(i).validerTache(y, b);
    }

    public void appelModificationTache(int i, int numerotache, String nvnom, String nvdescription){
        lesListes.get(i).modifierTache(numerotache,nvnom,nvdescription);
    }

    public void appelSupressionTache(int i, int y){
        lesListes.get(i).supprimerTache(y);
    }

    public int appelNbTache(int i){
        return lesListes.get(i).nombreTache();
    }

    public void modifierListe(int index, String nom, String descrition){
        lesListes.get(index).setNom(nom);
        lesListes.get(index).setDescription(descrition);
    }

    public void supprimerListe(String i){
        lesListes.remove(i);
    }

    public void ajouterListe(Liste uneListe) {
        lesListes.add(uneListe);
    }
    public void ajouterTache(int i,Tache tache) {
        this.lesListes.get(i).ajouterTache(tache);
    }

    public String afficherTache( int i, int y) {
        return "\nLe nom de la tache: "+this.lesListes.get(i).afficherNomTache(y)+"\nDescription "+this.lesListes.get(i).afficherDesfriptionTache(y)+"\nSon état : "+this.lesListes.get(i).afficherEtatTache(y)+"\n\n";
    }

    public String appelAfficherNomTache( int i, int y) {
        return this.lesListes.get(i).afficherNomTache(y);
    }

    public String appelAfficherDescriptionTache( int i, int y) {
        return this.lesListes.get(i).afficherDesfriptionTache(y);
    }


    public String getNomListe(int i){
        return lesListes.get(i).getNom();
    }

    public String getDescriptionListe(int i){
        return lesListes.get(i).getDescription();
    }

    public int nbListe(){
        return lesListes.size();
    }

    public int appelRefType(int i,int y){
        return lesListes.get(i).afficherRefType(y);
    }




}