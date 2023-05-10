package Classes;

public class Type {

    private String libelle;
    private String code_couleur;
    private int id_type;

    public String getCode_couleur() {
        return code_couleur;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
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

    public Type(int idType, String libelle, String code_couleur) {
        this.id_type = idType;
        this.libelle = libelle;
        this.code_couleur = code_couleur;
    }
}


