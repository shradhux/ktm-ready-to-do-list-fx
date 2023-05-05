package graphicController;

public class Type {

    private String libelle;
    private String code_couleur;

    public String getCode_couleur() {
        return code_couleur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setCode_couleur(String code_couleur) {
        this.code_couleur = code_couleur;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Type(String libelle, String code_couleur) {
        this.libelle = libelle;
        this.code_couleur = code_couleur;
    }
}


