package modele.utilisateur;

public class Utilisateur {

    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public Boolean getAdmin() {
        return admin;
    }

    private String prenom;
    private String email;
    private String mdp;
    private Boolean admin;


    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Utilisateur(int id, String nom, String prenom, String email, String mdp, Boolean admin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.admin = admin;

    }
    public Utilisateur(String nom, String prenom, String email, String mdp){
        this(0,nom,prenom,email,mdp,null);
    }
}

