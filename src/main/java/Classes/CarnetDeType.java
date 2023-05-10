package Classes;

import Classes.Type;

import java.util.ArrayList;

public class CarnetDeType {

    private ArrayList<Type> lesTypes;

    public CarnetDeType() {
        this.lesTypes = new ArrayList<Type>();
    }


    public void ajouterType(Type type) {
        lesTypes.add(type);
    }

    public int nbTypes(){
        return lesTypes.size();
    }

    public String affichertype(int i) {
        return "libelle : "+lesTypes.get(i).getLibelle()+"\ncode couleur : "+lesTypes.get(i).getCode_couleur()+"\n\n";
    }

    public String appelLibelle(int i){
        return lesTypes.get(i).getLibelle();
    }

    public String appelCodeCouleur(int i){
        return lesTypes.get(i).getCode_couleur();
    }

    public void supprimerType(int i){
        lesTypes.remove(i);
    }
    public void modifierType(int i, String libelle, String code){
        lesTypes.get(i).setCode_couleur(code);
        lesTypes.get(i).setLibelle(libelle);
    }

}