package Classes;

public class Type {

    private String libelle;
    private String codeCouleur;
    private int idType;

    public String getCodeCouleur() {
        return codeCouleur;
    }

    public int getIdType(){
        return getIdType();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setCodeCouleur(String codeCouleur) {
        this.codeCouleur = codeCouleur;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Type(String libelle, String codeCouleur) {
        this.libelle = libelle;
        this.codeCouleur = codeCouleur;
    }
}


