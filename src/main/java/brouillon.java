
/*
package interfaceUtilisateur;
import taches.*;
import utilisateur.Utilisateur;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Connection Connection;
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean connexionechouee = false;
        boolean deco = false;

        try {
            Connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pre_todolist", "root", "");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("\nLa connexion à la base de données a échoué, veuillez vérifier que les serveurs WAMP sont bien lancés.");   //Méthode reprise sur nos devoirs PHP : envoyer un message d'erreur si la connexion a échoué
            connexionechouee = true;

        }


        if (!connexionechouee) { //Lance la continuité du programme si la connexion a fonctionné
            System.out.println("Connexion réussie !");



            while(!deco){
                boolean menuprincipal = true;
                String choix;
                CarnetDeListe carnet = new CarnetDeListe(); // Je crée un carnet de liste
                CarnetDeType touslestypes = new CarnetDeType(); // Je crée un carnet de types (utile pour ajouter des types de taches)




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

                System.out.println("\n✔X✔X✔X✔X✔");
                System.out.println("\uD83C\uDD83\uD83C\uDD7E \uD83C\uDD73\uD83C\uDD7E \uD83C\uDD7B\uD83C\uDD78\uD83C\uDD82\uD83C\uDD83");
                System.out.println("✔X✔X✔X✔X✔\n\n");
                while (!login) {


                    mailcorrect = false;
                    int mdpfaux = 0;
                    int mailfaux = 0; // les compteurs d'erreurs lors de la réinitialisation du mot de passe
                    choixreinitialisation = false;

                    System.out.println("\n\n\uD835\uDD39\uD835\uDD5A\uD835\uDD56\uD835\uDD5F\uD835\uDD67\uD835\uDD56\uD835\uDD5F\uD835\uDD66\uD835\uDD56, \uD835\uDD67\uD835\uDD56\uD835\uDD66\uD835\uDD5A\uD835\uDD5D\uD835\uDD5D\uD835\uDD56\uD835\uDD6B-\uD835\uDD67\uD835\uDD60\uD835\uDD66\uD835\uDD64 \uD835\uDD52\uD835\uDD66\uD835\uDD65\uD835\uDD59\uD835\uDD56\uD835\uDD5F\uD835\uDD65\uD835\uDD5A\uD835\uDD57\uD835\uDD5A\uD835\uDD56\uD835\uDD63");

                    System.out.println("\n\nVeuillez entrer votre adresse e-mail\n");     //la connexion, propose de se connecter tant que ses identifiants ne sont pas trouvés dans la base de données
                    System.out.print("->");
                    mailconnexion = sc.nextLine();
                    System.out.println("Veuillez entrer votre mot de passe\n");
                    System.out.print("->");
                    mdpconnexion = sc.nextLine();




                    PreparedStatement verification = Connection.prepareStatement("SELECT * FROM utilisateur");
                    ResultSet Affichage = verification.executeQuery();


                    while (Affichage.next()) {

                        Utilisateur user = new Utilisateur(Affichage.getInt(1),Affichage.getString(2),Affichage.getString(3),Affichage.getString(4),Affichage.getString(5));

                        if (Affichage.getString(4).equals(mailconnexion)) {
                            mailcorrect = true;
                        }

                        if (Affichage.getString(4).equals(mailconnexion) && (Affichage.getString(5).equals(mdpconnexion))) {
                            login = true;
                            numeroid = user.getId_utilisateur();
                            nomutilisateur = user.getNom();
                            prenomutilisateur = user.getPrenom();
                            emailutilisateur = user.getLogin();

                        }

                    }

                    if (login) {    //connexion réussie

                        System.out.print("Bienvenue " + prenomutilisateur + " !");
                        System.out.println("\nVotre id est " + numeroid);
                        System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                        sc.nextLine();
                        System.out.println("\n \n");
                    } else {
                        if (mailcorrect) {
                            System.out.println("Le login entré est correct mais le mot de passe ne correspond pas !");
                        } else {
                            System.out.println("Erreur ! Login et/ou mot de passe incorrect !\n");
                        }

                        while (choixreinitialisation == false) {

                            System.out.println("Mot de passe oublié ? écrivez (oui/non) afin de reinitialiser ou non votre mot de passe");     //Procedure de reinitialisation de mot de passe
                            reinitialisaion = sc.nextLine();

                            if (reinitialisaion.equals("oui")) {

                                choixreinitialisation = true;
                                choixdereinitialisation = true;
                            } else if (reinitialisaion.equals("non")) {

                                choixreinitialisation = true;
                                choixdereinitialisation = false;
                            } else {

                                System.out.println("Erreur veuillez confirmer par oui ou non\n");
                                choixreinitialisation = false;
                            }
                        }

                    }


                    while (choixdereinitialisation == true) {
                        System.out.println("\n-- Procedure de réinitialisation de mot de passe --\n");
                        System.out.println("Veuillez entrer votre login\n");
                        System.out.println("\nREMARQUE : écrivez ABANDONNER en majuscule si vous souhaitez annuler la séquence de modification de mot de passe\n");
                        mail = sc.nextLine();

                        if (mail.equals("ABANDONNER")) {
                            choixdereinitialisation = false;
                            System.out.println("\nAbandon de la sequence d'annulation de mot de passe\n");
                            System.out.println("\n** Appuyez sur entrée pour continuer **");
                            sc.nextLine();

                        } else {

                            PreparedStatement verifier = Connection.prepareStatement("SELECT * FROM utilisateur WHERE login IN (?)");
                            verifier.setString(1, mail);
                            ResultSet verifff = verifier.executeQuery();
                            if (verifff.next()) {            //Verifie si l'email est bon
                                choixdereinitialisation = false;


                                // le code qui permet de générer un code de vérification pour le changement de mot de passe dont le "bound" correspond a la lettre 'a' d'après la table ascii et 97  correspond à la lettre 'z', de ce fait, le code de vérification est très sécurisé par rapport à un code donné uniquement en chiffres
                                Random random = new Random();
                                String codeerreur = "";
                                for (int i = 0; i < 9; i++) {
                                    char lettreerreur = (char) (random.nextInt(26) + 97);
                                    codeerreur = lettreerreur + codeerreur;
                                }


                                System.out.println("Un code confirmant qu'il s'agit bien de vous a été envoyé à cette adresse mail : " + mail + "\n(comme dans cet exercice nous travaillons uniquement avec la console d'intellij, voici le code généré qui serait envoyé à l'adresse mail entréee : " + codeerreur+")");
                                System.out.println("\n Veuillez entrer le code qui vous a été envoyé ");
                                String verifcode = sc.nextLine();
                                boolean coderreur = false;

                                if (verifcode.equals(codeerreur)) {
                                    System.out.println("Code bon");
                                    while (coderreur == false) {
                                        System.out.println("Veuillez désormais entrer votre nouveau mot de passe :\n");
                                        String nouveaumdp1 = sc.nextLine();
                                        System.out.println("Veuillez confirmer votre mot de passe en l'entrant une seconde fois :\n");
                                        String nouveaumdp2 = sc.nextLine();


                                        if (nouveaumdp2.equals(nouveaumdp1)) { //code pour la modification du mot de passe


                                            PreparedStatement modifmdp = Connection.prepareStatement("UPDATE utilisateur SET mdp = ? WHERE login = ?");
                                            modifmdp.setString(1, nouveaumdp1);
                                            modifmdp.setString(2, mail);
                                            modifmdp.executeUpdate();
                                            System.out.println("Mot de passe modifié avec succès !");
                                            System.out.println("\n** Appuyez sur entrée pour continuer **");
                                            sc.nextLine();
                                            coderreur = true;


                                        } else {

                                            if (mdpfaux >= 4) {
                                                System.out.println("Vous avez effectué trop de tentatives de confirmation de mot de passe eronnées, nous avons annulé votre tentative de modification de mot de passe, je vous invite à consulter un ophtalmologue !");
                                                coderreur = true; //abandonne l'opération si l'utilisateur se trompe trop de fois sur son nouveau mot de passe
                                                System.out.println("\n\n** Appuyez sur entrée pour continuer **");
                                                sc.nextLine();
                                                System.out.println("\n \n");
                                            } else {

                                                System.out.println("Les mots de passes ne correspondent pas, veuillez les entrer à nouveau\n\n");
                                                coderreur = false;
                                                mdpfaux++;
                                            }
                                        }
                                    }



                                } else {

                                    System.out.println("Code éronné ! Par mesure de sécurité, nous avons annulé votre tentative de modification de mot de passe, le code de vérification n'est donc plus valide !");
                                    //ici j'aurais envoyé un email à l'utilisateur concerné lui informant que quelqu'un essaye de se connecter et souhaite changer le mot de passe
                                    codeerreur = "zeirgzfkernhgouhveopgferçtupeertyger"; //modifie le code au cas où pour être sûr qu'il ne soit pas ré utilisé
                                    System.out.println("\n** Appuyez sur entrée pour continuer **");
                                    sc.nextLine();
                                }


                            } else {

                                if (mailfaux >= 4) {

                                    System.out.println("\nTrop de tentatives échouées ! Par mesure de sécurité, nous avons annulé votre tentative de modification de mot de passe");
                                    choixdereinitialisation = false;
                                    System.out.println("\n** Appuyez sur entrée pour continuer **");
                                    sc.nextLine();

                                } else {

                                    System.out.println("\nCette adresse mail n'existe pas ! Veuillez en entrer une correcte\n");
                                    choixdereinitialisation = true;
                                    mailfaux++;
                                }

                            }

                        }
                    }


                }



                PreparedStatement extraireListes = Connection.prepareStatement("SELECT * FROM liste");
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

                                    PreparedStatement supprTaches = Connection.prepareStatement("DELETE FROM tache WHERE ref_liste = ?"); //Supprime d'abord les tâches associées
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

                                PreparedStatement supprimerType = Connection.prepareStatement("DELETE FROM type WHERE libelle = ? AND code_couleur = ?");
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
}


*/