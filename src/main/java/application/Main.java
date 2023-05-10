package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.bdd.Bdd;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main extends Application {

    public static Stage stage;

    private static FXMLLoader fxmlLoader;


    @Override
    public void start(Stage mystage) throws IOException, SQLException {


        PreparedStatement extraireListes = new Bdd().getBdd().prepareStatement("SELECT * FROM liste");






        this.stage = mystage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Connection.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void change(String fxml, Object controller, String title) {
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(controller);
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }


    public static void change(String fxml) {
        // Step 1
        stage.close();
        try {
            // Step 2
            fxmlLoader = new FXMLLoader(Main.class.getResource(fxml+".fxml"));
            // Step 5
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

/*
    public void main(String[] args) throws SQLException {
        launch();
    }

        PreparedStatement extraireListes = new Bdd().getBdd().prepareStatement("SELECT * FROM liste");
        ResultSet recupListes = extraireListes.executeQuery();
        int positionliste = 0;
        while (recupListes.next()){     // On extrait la liste, on la place dans le carnet, et on attribue les taches avec leur types respectifs UNIQUEMENT si elle correspond à un utilisateur


            PreparedStatement ListeUser = new Bdd().getBdd().prepareStatement("SELECT * FROM UtilisateurListe WHERE ref_utilisateur = ? AND ref_liste = ?");
            ListeUser.setInt(1, Utilisateur.getId());
            ListeUser.setInt(2,recupListes.getInt(1));
            ResultSet RecupListeUser = ListeUser.executeQuery();
            if (RecupListeUser.next()) {


                Liste liste = new Liste(recupListes.getString(2), recupListes.getString(3));

                this.getCarnet().ajouterListe(liste);
                PreparedStatement extraireTaches = new Bdd().getBdd().prepareStatement("SELECT * FROM tache");
                ResultSet recupTaches = extraireTaches.executeQuery();

                while (recupTaches.next()) {

                    if (recupTaches.getInt(6) == recupListes.getInt(1)) {
                        Tache tache = new Tache(recupTaches.getString(3), recupTaches.getString(2), recupTaches.getBoolean(4), recupTaches.getInt(6), recupTaches.getInt(5));
                        carnet.ajouterTache(positionliste, tache);
                    }
                }
                positionliste++;

            }
        }

        PreparedStatement extraireType = new Bdd().getBdd().prepareStatement("SELECT * FROM type");
        ResultSet recupTypes = extraireType.executeQuery();
        while (recupTypes.next()){
            Type unType = new Type(recupTypes.getString(2),recupTypes.getString(3));
            this.getTouslestypes().ajouterType(unType);
        }

    }
        /*
        Scanner sc = new Scanner(System.in);
       // while(!deco){
            boolean menuprincipal = true;
            String choix;





            int numeroid = 0;

            String nomutilisateur = "";
            String prenomutilisateur = ""; //les informations de l'utilisateur récupérées
            String emailutilisateur = "";
            String mailconnexion;
            String mdpconnexion;
            String reinitialisaion = "";
            String mail = "";
            boolean choixreinitialisation = false;
            boolean choixdereinitialisation = false;
            boolean login = false;
            boolean mailcorrect = false;
            int numeroliste = 1;
            int idnumeroliste = 0;
            boolean choixliste = false;





            PreparedStatement extraireListes = new Bdd().getBdd().prepareStatement("SELECT * FROM liste");
            ResultSet recupListes = extraireListes.executeQuery();
            int positionliste = 0;
            while (recupListes.next()){     // On extrait la liste, on la place dans le carnet, et on attribue les taches avec leur types respectifs UNIQUEMENT si elle correspond à un utilisateur


                PreparedStatement ListeUser = Connection.prepareStatement("SELECT * FROM UtilisateurListe WHERE ref_utilisateur = ? AND ref_liste = ?");
                ListeUser.setInt(1,numeroid);
                ListeUser.setInt(2,recupListes.getInt(1));
                ResultSet RecupListeUser = ListeUser.executeQuery();
                if (RecupListeUser.next()) {


                    Liste liste = new Liste(recupListes.getString(2), recupListes.getString(3));

                    carnet.ajouterListe(liste);
                    PreparedStatement extraireTaches = Connection.prepareStatement("SELECT * FROM tache");
                    ResultSet recupTaches = extraireTaches.executeQuery();

                    while (recupTaches.next()) {

                        if (recupTaches.getInt(6) == recupListes.getInt(1)) {
                            Tache tache = new Tache(recupTaches.getString(3), recupTaches.getString(2), recupTaches.getBoolean(4), recupTaches.getInt(6), recupTaches.getInt(5));
                            carnet.ajouterTache(positionliste, tache);
                        }
                    }
                    positionliste++;

                }
            }

            PreparedStatement extraireType = Connection.prepareStatement("SELECT * FROM type");
            ResultSet recupTypes = extraireType.executeQuery();
            while (recupTypes.next()){
                Type unType = new Type(recupTypes.getString(2),recupTypes.getString(3));
                touslestypes.ajouterType(unType);
            }




            while (menuprincipal) {

                System.out.println("\n\n\n          _________________________________________________________________________\n\n                                  \uD835\uDDE0\uD835\uDDD8\uD835\uDDE1\uD835\uDDE8 \uD835\uDDE3\uD835\uDDE5\uD835\uDDDC\uD835\uDDE1\uD835\uDDD6\uD835\uDDDC\uD835\uDDE3\uD835\uDDD4\uD835\uDDDF \uD835\uDDD7\uD835\uDDD8 \uD835\uDDD6\uD835\uDDE2\uD835\uDDE0\uD835\uDDE0\uD835\uDDD4\uD835\uDDE1\uD835\uDDD7\uD835\uDDD8");
                System.out.println("\n\n\n              Veuillez entrer le mot désignant l'action que vous voudrez faire \n\n\n                       Ecrivez `aide` pour voir la liste des commandes\n\n          _________________________________________________________________________\n\n\n");

                if (choixliste) {

                    System.out.println("\nVous êtes sur la liste "+numeroliste);
                    System.out.println("Nom de la liste : "+carnet.getNomListe(numeroliste-1));
                    System.out.println("Description de la liste : "+carnet.getDescriptionListe(numeroliste-1)+"\n\n");
                    if (carnet.appelNbTache(numeroliste - 1) >= 1){

                        System.out.println("Voici la liste des tâches\n");
                        for (int i = 0; i < carnet.appelNbTache(numeroliste - 1); i++) {
                            System.out.println("\n\n\ntache " + (i + 1));
                            System.out.println(carnet.afficherTache((numeroliste - 1), i));

                            // Affiche le type associé à la tache
                            PreparedStatement recupType = Connection.prepareStatement("SELECT ref_type FROM tache WHERE nom = ? AND description = ?");
                            recupType.setString(1,carnet.appelAfficherNomTache(numeroliste-1,i));
                            recupType.setString(2,carnet.appelAfficherDescriptionTache(numeroliste-1,i));
                            ResultSet recup = recupType.executeQuery();
                            recup.next();


                            PreparedStatement afficherType = Connection.prepareStatement("SELECT libelle, code_couleur FROM type WHERE id_type = ?");
                            afficherType.setInt(1,recup.getInt(1));
                            ResultSet affiType = afficherType.executeQuery();
                            if(affiType.next()){
                                System.out.print("Son libelle : ");
                                System.out.println(affiType.getString(1));
                                System.out.print("Son code couleur : ");
                                System.out.println(affiType.getString(2));
                            }else{
                                System.out.print("Son libelle : ");
                                System.out.println("non renseigné");
                                System.out.print("Son code couleur : ");
                                System.out.println("non renseigné");
                                System.out.println("REMARQUE : le type de cette tache a été supprimé, son libelle et code couleur ne sont donc plus référencés, modifier cette tache afin de lui attribuer un type défini");
                            }
                        }

                    }else{
                        System.out.println("Cette liste ne contient pas encore de taches, ajoutez-en en écrivant 'ajoutertache'\n ");
                    }
                } else {
                    System.out.println("Veuillez d'abord selectionner une liste afin de pouvoir ajouter et afficher les taches");
                }

                System.out.print("\n->");
                choix = sc.nextLine().toLowerCase();


                if (choix.equals("ajouterliste")) {

                    //CHECKKKK

                    System.out.println("Veuillez écrire le nom de la liste");
                    String nom = sc.nextLine();
                    System.out.println("Veuillez entrez une description");
                    String description = sc.nextLine();

                    Liste liste = new Liste(nom, description);
                    carnet.ajouterListe(liste);

                    PreparedStatement ajoutListe = Connection.prepareStatement("INSERT INTO Liste (nom, description) VALUES (?,?)");
                    ajoutListe.setString(1, nom);
                    ajoutListe.setString(2, description);
                    ajoutListe.executeUpdate();

                    // Je recupère l'id de la liste créée pour la ref d'après
                    PreparedStatement recupIdListe = Connection.prepareStatement("SELECT id_liste FROM liste WHERE nom = ? AND description = ?");
                    recupIdListe.setString(1, nom);
                    recupIdListe.setString(2, description);
                    ResultSet recup = recupIdListe.executeQuery();
                    recup.next();
                    int idliste = recup.getInt(1);


                    PreparedStatement permissions = Connection.prepareStatement("INSERT INTO UtilisateurListe (ref_utilisateur, ref_liste) VALUES (?, ?)"); // J'octroie à l'utilisateur les droits d'accéder à la liste qu'il a créée
                    permissions.setInt(1, numeroid);
                    permissions.setInt(2, idliste);
                    permissions.executeUpdate();
                    System.out.println("Opération réalisée avec succès !");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");
                }

                if (choix.equals("selectionnerliste")) {

                    //CHECKKKK


                    System.out.println("Voici la liste des listes ( cette phrase n'est pas très jolie )\n");
                    for (int i = 0; i < carnet.nbListe(); i++) {
                        System.out.println("liste " + (i + 1));
                        System.out.println("Le nom de la liste : " + carnet.getNomListe(i) + "\nLa description : " + carnet.getDescriptionListe(i));
                    }


                    System.out.println("quelle liste ?");
                    numeroliste = sc.nextInt();
                    sc.nextLine();

                    PreparedStatement recupererId = Connection.prepareStatement("SELECT id_liste from liste where nom = ? AND description = ?");
                    recupererId.setString(1, carnet.getNomListe(numeroliste - 1));
                    recupererId.setString(2, carnet.getDescriptionListe(numeroliste - 1));
                    ResultSet recupereId = recupererId.executeQuery();
                    recupereId.next();
                    idnumeroliste = recupereId.getInt(1);
                    choixliste = true;
                    System.out.println("Opération réalisée avec succès !");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");

                }

                if (choixliste) {

                    if (choix.equals("ajoutertache")) {

                        //CHECKKKK

                        System.out.println("Veuillez écrire le nom de la tache");
                        String nom = sc.nextLine();
                        System.out.println("Veuillez entrez une description");
                        String description = sc.nextLine();

                        System.out.println("Voici la liste des types disponibles");
                        int positiontype = 0;
                        for (int i = 0; i < touslestypes.nbTypes(); i++) {
                            System.out.println((positiontype + 1) + touslestypes.affichertype(i));
                            positiontype++;
                        }
                        System.out.println("Selectionnez le numero du type");
                        int numerotype = sc.nextInt();
                        sc.nextLine();

                        // recupere l'id
                        PreparedStatement recupererIdType = Connection.prepareStatement("SELECT id_type from type where libelle = ? AND code_couleur = ?");
                        recupererIdType.setString(1, touslestypes.appelLibelle(numerotype - 1));
                        recupererIdType.setString(2, touslestypes.appelCodeCouleur(numerotype - 1));
                        ResultSet recupereIdType = recupererIdType.executeQuery();
                        recupereIdType.next();
                        int idnumerotype = recupereIdType.getInt(1);


                        Tache tache = new Tache(description, nom, false, numeroliste - 1, numerotype);
                        carnet.ajouterTache(numeroliste-1, tache);

                        PreparedStatement ajouterTache = Connection.prepareStatement("INSERT INTO Tache (nom,description,est_realise,ref_type, ref_liste) VALUES (?,?,?,?,?)");
                        ajouterTache.setString(1, nom);
                        ajouterTache.setString(2, description);
                        ajouterTache.setBoolean(3, false);
                        ajouterTache.setInt(4, idnumerotype);
                        ajouterTache.setInt(5, idnumeroliste);
                        ajouterTache.executeUpdate();
                        System.out.println("Opération réalisée avec succès !");
                        System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                        sc.nextLine();
                        System.out.println("\n \n");

                    }


                    if (choix.equals("modifiertache")) {

// CHECKKKK
                        if (carnet.appelNbTache(numeroliste - 1) >= 1) {

                            System.out.println("quelle tache voulez vous modifier ?");
                            int numerotache = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Nouveau nom ");
                            String nvnom = sc.nextLine();
                            System.out.println("Nouvelle description ");
                            String nvdescription = sc.nextLine();






                            System.out.println("Voici la liste des types disponibles");
                            int positiontype = 0;
                            for (int i = 0; i < touslestypes.nbTypes(); i++) {
                                System.out.println((positiontype + 1) + touslestypes.affichertype(i));
                                positiontype++;
                            }
                            System.out.println("Selectionnez le numero du type");
                            int numerotype = sc.nextInt();
                            sc.nextLine();

                            // recupere l'id
                            PreparedStatement recupererIdType = Connection.prepareStatement("SELECT id_type from type where libelle = ? AND code_couleur = ?");
                            recupererIdType.setString(1, touslestypes.appelLibelle(numerotype - 1));
                            recupererIdType.setString(2, touslestypes.appelCodeCouleur(numerotype - 1));
                            ResultSet recupereIdType = recupererIdType.executeQuery();
                            recupereIdType.next();
                            int idnumerotype = recupereIdType.getInt(1);




                            PreparedStatement modifTache = Connection.prepareStatement("UPDATE tache SET nom = ?, description = ?, ref_type = ? WHERE nom = ? AND description = ?");  // Marche Pas
                            modifTache.setString(1, nvnom);
                            modifTache.setString(2, nvdescription);
                            modifTache.setInt(3,idnumerotype);
                            modifTache.setString(4, carnet.appelAfficherNomTache(numeroliste - 1, numerotache - 1));
                            modifTache.setString(5, carnet.appelAfficherDescriptionTache(numeroliste - 1, numerotache - 1));
                            modifTache.executeUpdate();

                            carnet.appelModificationTache(numeroliste - 1, numerotache - 1, nvnom, nvdescription);







                        }else{
                            System.out.println("Cette liste ne contient pas de tâches pour le moment !");
                        }
                    }


                    if (choix.equals("supprimertache")) {

                        //CHECKKK

                        if (carnet.appelNbTache(numeroliste - 1) >= 1) {


                            System.out.println("quelle tache voulez vous supprimer ?");
                            int numerotache = sc.nextInt();
                            sc.nextLine();

                            boolean confirmer = false;
                            while (!confirmer) {
                                System.out.println("Cette action est irréversible, continuer ? (oui/non)");
                                String confirmation = sc.nextLine();
                                if (confirmation.equals("oui")) {

                                    PreparedStatement supprimeTache = Connection.prepareStatement("DELETE FROM tache WHERE nom = ? AND description = ?");
                                    supprimeTache.setString(1, carnet.appelAfficherNomTache(numeroliste - 1, numerotache - 1));
                                    supprimeTache.setString(2, carnet.appelAfficherDescriptionTache(numeroliste - 1, numerotache - 1));
                                    supprimeTache.executeUpdate();
                                    carnet.appelSupressionTache(numeroliste - 1, numerotache - 1);

                                    System.out.println("Opération réalisée avec succès !");
                                    confirmer = true;
                                } else if (confirmation.equals("non")) {
                                    System.out.println("\nAbandon de la séquence de suppression");
                                    confirmer = true;
                                } else {
                                    System.out.println("\nErreur, veuillez choisir par oui ou non");
                                }


                            }

                        }else{
                            System.out.println("Cette liste ne contient pas de tâches pour le moment !");
                        }
                    }

                    if (choix.equals("validertache")) {
//checkk

                        if (carnet.appelNbTache(numeroliste - 1) >= 1) {

                            System.out.println("Quelle tache voulez vous valider ou invalider ?");
                            int numerotache = sc.nextInt();
                            sc.nextLine();
                            boolean validation = true;
                            boolean confvalid = false;
                            while (!confvalid) {
                                System.out.println("Valider ou Invalider ? (V/I) ");
                                String valide = sc.nextLine().toUpperCase();

                                if (valide.equals("V")) {
                                    confvalid = true;
                                } else if (valide.equals("I")) {
                                    validation = false;
                                    confvalid = true;
                                } else {
                                    System.out.println("Erreur veuillez écrire V ou I en fonctione de votre choix de validation");
                                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                                    sc.nextLine();
                                    System.out.println("\n \n");
                                }
                                carnet.appelValidationTache(numeroliste - 1, numerotache - 1, validation);

                                PreparedStatement valider = Connection.prepareStatement("UPDATE tache SET est_realise = ? WHERE nom = ? AND description = ?");
                                valider.setBoolean(1, validation);
                                valider.setString(2, carnet.appelAfficherNomTache(numeroliste - 1, numerotache - 1));
                                valider.setString(3, carnet.appelAfficherDescriptionTache(numeroliste - 1, numerotache - 1));
                                valider.executeUpdate();
                            }
                            System.out.println("Opération réussie avec succès !");
                            System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                            sc.nextLine();
                            System.out.println("\n \n");
                        }
                        else{
                            System.out.println("Cette liste ne contient pas de tâches pour le moment !");
                        }
                    }

                    if (choix.equals("modifierliste")) {

                        // CHECKKKK

                        System.out.println("Modification de la liste " + numeroliste);

                        System.out.println("Nouveau nom ");
                        String nvnom = sc.nextLine();
                        System.out.println("Nouvelle description ");
                        String nvdescription = sc.nextLine();
                        carnet.modifierListe(numeroliste - 1, nvnom, nvdescription);

                        PreparedStatement modif = Connection.prepareStatement("UPDATE liste SET nom = ?, description = ? WHERE id_liste = ?");
                        modif.setString(1, nvnom);
                        modif.setString(2, nvdescription);
                        modif.setInt(3, idnumeroliste);
                        modif.executeUpdate();
                        System.out.println("Opération réalisée avec succès !");
                        System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                        sc.nextLine();
                        System.out.println("\n \n");

                    }

                    if (choix.equals("supprimerliste")) {


                        //CHECKKK

                        boolean choixconfirmation = false;
                        while (!choixconfirmation) {
                            System.out.println("La liste numéro " + numeroliste + " va être supprimée et les tâches attribuées seront supprimées d'autant, cette action est irréversible, continuer ? (oui/non)");

                            String confirmation = sc.nextLine();
                            if (confirmation.equals("oui")) {
                                System.out.println("\nSéquence de suppression en cours...");

                                PreparedStatement supprTaches = new Bdd().getBdd().prepareStatement("DELETE FROM tache WHERE ref_liste = ?"); //Supprime d'abord les tâches associées
                                supprTaches.setInt(1, idnumeroliste);
                                supprTaches.executeUpdate();

                                carnet.supprimerListe(numeroliste - 1);
                                PreparedStatement modification = Connection.prepareStatement("DELETE FROM liste WHERE id_liste = ? "); // Puis la liste en elle même
                                modification.setInt(1, idnumeroliste);
                                modification.executeUpdate();
                                System.out.println("Opération réalisée avec succès !");
                                choixconfirmation = true;
                                System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                                sc.nextLine();
                                System.out.println("\n \n");

                                choixliste = false;
                            } else if (confirmation.equals("non")) {
                                System.out.println("\nAbandon de la séquence de suppression");
                                choixconfirmation = true;
                            } else {
                                System.out.println("\nErreur, veuillez choisir par oui ou non");
                            }
                        }
                    }
                }


                if (choix.equals("ajoutertype")) {
                    System.out.println("Veuillez écrire le libelle du type");
                    String libelle = sc.nextLine();
                    System.out.println("Veuillez entrez le code_couleur");
                    String codecouleur = sc.nextLine();
                    PreparedStatement ajoutertype = Connection.prepareStatement("INSERT INTO type (libelle, code_couleur) VALUES (?,?)");
                    ajoutertype.setString(1, libelle);
                    ajoutertype.setString(2, codecouleur);
                    ajoutertype.executeUpdate();
                    Type unType = new Type(libelle, codecouleur);
                    touslestypes.ajouterType(unType);
                    System.out.println("Opération réalisée avec succès !");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");

                }

                if (choix.equals("modifiertype")) {

                    System.out.println("Voici la liste des types disponibles");
                    int positiontype = 0;
                    for (int i = 0; i < touslestypes.nbTypes(); i++) {
                        System.out.println((positiontype + 1) + touslestypes.affichertype(i));
                        positiontype++;
                    }

                    System.out.println("Selectionnez le numero du type");
                    int numerotype = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Veuillez écrire le libelle du type");
                    String nvlibelle = sc.nextLine();
                    System.out.println("Veuillez entrez le code_couleur");
                    String nvcodecouleur = sc.nextLine();
                    PreparedStatement modifType = Connection.prepareStatement("UPDATE type SET libelle = ?, code_couleur = ? WHERE libelle = ? AND code_couleur = ?");
                    modifType.setString(1, nvlibelle);
                    modifType.setString(2, nvcodecouleur);
                    modifType.setString(3, touslestypes.appelLibelle(numerotype - 1));
                    modifType.setString(4, touslestypes.appelCodeCouleur(numerotype - 1));
                    modifType.executeUpdate();
                    touslestypes.modifierType(numerotype - 1, nvlibelle, nvcodecouleur);
                    System.out.println("Opération réalisée avec succès !");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");

                } if(choix.equals("listertype")){
                    System.out.println("Voici la liste des types disponibles");
                    int positiontype = 0;
                    for (int i = 0; i < touslestypes.nbTypes(); i++) {
                        System.out.println((positiontype + 1) + touslestypes.affichertype(i));
                        positiontype++;
                    }
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");

                }
                if (choix.equals("supprimertype")) {

                    System.out.println("Voici la liste des types disponibles");
                    int positiontype = 0;
                    for (int i = 0; i < touslestypes.nbTypes(); i++) {
                        System.out.println((positiontype + 1) + touslestypes.affichertype(i));
                        positiontype++;
                    }

                    System.out.println("Selectionnez le numero du type à supprimer");
                    int numerotype = sc.nextInt();
                    sc.nextLine();

                    boolean choixconfirmation = false;
                    while (!choixconfirmation) {
                        System.out.println("Ce type sera supprimé, toutes les taches de ce types sont conservées mais leur type seront non renseignés, continuer ? (oui/non)");

                        String confirmation = sc.nextLine().toLowerCase();
                        if (confirmation.equals("oui")) {
                            System.out.println("\nSéquence de suppression en cours...");

                            PreparedStatement supprimerType = new Bdd().getBdd().prepareStatement("DELETE FROM type WHERE libelle = ? AND code_couleur = ?");
                            supprimerType.setString(1,touslestypes.appelLibelle(numerotype-1));
                            supprimerType.setString(2,touslestypes.appelCodeCouleur(numerotype-1));
                            supprimerType.executeUpdate();
                            touslestypes.supprimerType(numerotype-1);

                            System.out.println("Opération réalisée avec succès !");
                            choixconfirmation = true;
                            System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                            sc.nextLine();
                            System.out.println("\n \n");

                        } else if (confirmation.equals("non")) {
                            System.out.println("\nAbandon de la séquence de suppression");
                            choixconfirmation = true;
                        } else {
                            System.out.println("\nErreur, veuillez choisir par oui ou non");
                        }
                    }



                }

                if (choix.equals("credit")) {


                    System.out.println("\nCredits : \n");
                    System.out.println("\n\nCe programme a été fait avec ♥ pour notre Dieu de la Programmation Ô monsieur Lemoine !!");
                    System.out.println("\n\nCe programme est l'exemplaire OFFICIEL, toute copie est formellement interdite et fera l'objet d'heure de colle !");
                    System.out.println("\n\nVersion actuelle du programme : 1.1 ; correction de problèmes mineurs et ajout de manipulation des types\nDate de la version : 07/03/2023  \n\n");
                    System.out.println("\n\nVersion précédente du programme : 1.0 ; \nDate de la version : 03/03/2023  \n\n");
                    System.out.println("\n\nSi vous rencontrez des problèmes, avez besoin d'informations ou des idées concernant des fonctions supplémentaires \n\n");
                    System.out.println("\n\nN'hésitez pas à me faire un don afin de soutenir mon travail :) \n\n");
                    System.out.println("\n\n                                                                      \uD83C\uDD7C\uD83C\uDD74\uD83C\uDD81\uD83C\uDD72\uD83C\uDD78\uD800\uDD20 \n\n");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");
                }
                if (choix.equals("deconnecter")) {
                    menuprincipal = false;
                    System.out.println("Au revoir " + prenomutilisateur + " !");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");
                }
                if (choix.equals("fin")) {
                    menuprincipal = false;
                    deco = true;
                    System.out.println("Arrêt du programme...");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");
                }

                if (choix.equals("moi")) {
                    System.out.println("A propos de vous : \n");
                    System.out.print("Votre identifiant :");
                    System.out.println(numeroid);
                    System.out.print("\nVotre prenom : ");
                    System.out.println(prenomutilisateur);
                    System.out.print("\nVotre nom : ");
                    System.out.println(nomutilisateur);
                    System.out.print("\nVotre email : ");
                    System.out.println(emailutilisateur);

                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n");

                }

                if (choix.equals("aide")){

                    System.out.println("\nListe des commandes :\n");
                    System.out.println("ajouterliste - Pour ajouter une liste");
                    System.out.println("ajoutertype - Pour ajouter un type");
                    System.out.println("modifiertype - Pour modifier un type");
                    System.out.println("listertype - Pour afficher tous les types");
                    System.out.println("supprimertype - Pour supprimer un type");
                    System.out.println("selectionnerliste - Pour selectionner une liste");

                    if (choixliste) {

                        System.out.println("La liste choisie est la "+ numeroliste );
                        System.out.println("\tmodifierliste - Pour modifier la liste "+numeroliste);
                        System.out.println("\tsupprimerliste - pour supprimer la liste "+numeroliste + " avec toutes les taches qui y sont attribuées");
                        System.out.println("\tajoutertache - pour ajouter une tache dans la liste "+numeroliste);
                        System.out.println("\tsupprimertache - pour supprimer une tache de la liste "+numeroliste);
                        System.out.println("\tmodifiertache - pour modifier une tache de la liste "+numeroliste);
                        System.out.println("\tvalidertache - pour valider une tache de la liste "+numeroliste);
                    } else {
                        System.out.println("Aucune liste n'a pour le moment été sélectionnée, sélectionnez-en une afin de bénéficier de paramètres supplémentaires");
                    }

                    System.out.println("moi - Pour afficher vos données personnelles ");
                    System.out.println("deconnecter - Pour vous deconnecter et vous authentifier avec un autre utilisateur");
                    System.out.println("fin - Pour mettre fin au programme et donc à la connexion à la base de données");
                    System.out.println("credit - Pour afficher les credits ");
                    System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                    sc.nextLine();
                    System.out.println("\n \n \n");

                }


            }
        }
    }
}


*/
}