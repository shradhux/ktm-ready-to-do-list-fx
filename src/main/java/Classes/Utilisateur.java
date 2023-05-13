package Classes;

public class Utilisateur {

    private static int id;
    private String nom;

    public static int getId() {
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

    public Boolean getEst_admin() {
        return est_admin;
    }

    private String prenom;
    private String email;
    private String mdp;
    private Boolean est_admin;


    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Utilisateur(int id, String nom, String prenom, String email, String mdp, Boolean est_admin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.est_admin = est_admin;

    }
    public Utilisateur(String nom, String prenom, String email, String mdp){
        this(0,nom,prenom,email,mdp,null);
    }


    public Utilisateur(String nom, String prenom) {

        this.nom = nom;
        this.prenom = prenom;

    }
    }

